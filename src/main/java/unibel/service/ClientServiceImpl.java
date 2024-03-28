package unibel.service;

import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
import unibel.dtos.ClientDto;
import unibel.dtos.ContactDto;
import unibel.exceptions.ClientAlreadyexistException;
import unibel.exceptions.ClientDoesntExistException;
import unibel.models.Client;
import unibel.models.Contact;
import unibel.models.ContactType;
import unibel.repositories.ClientRepository;
import unibel.repositories.ContactRepository;

@Service
@RequiredArgsConstructor
public class ClientServiceImpl implements ClientService {

	final private ClientRepository clientRepository;
	final private ContactRepository contactRepository;
	final private ModelMapper modelMapper;

	@Override
	public void addClient(ClientDto clientDto) {
		if (clientRepository.existsByName(clientDto.getName())) {
			throw new ClientAlreadyexistException(clientDto.getName());
		}
		Client client = modelMapper.map(clientDto, Client.class);
		clientRepository.save(client);

	}

	@Override
	public void addContactToClient(ContactDto contactDto, Long clientId) {
		Client client = clientRepository.findById(clientId).orElseThrow(() -> new ClientDoesntExistException());

		Contact contact = modelMapper.map(contactDto, Contact.class);
		contact.setClient(client);
		contactRepository.save(contact);

	}

	@Transactional(readOnly = true)
	@Override
	public Iterable<ClientDto> getClients() {
	
		return StreamSupport.stream(clientRepository.findAll().spliterator(), false)
				.map(c->modelMapper.map(c, ClientDto.class))
						.collect(Collectors.toList());
	}

	@Transactional(readOnly = true)
	@Override
	public ClientDto getClient(Long id) {
		Client client = clientRepository.findById(id).orElseThrow(() -> new ClientDoesntExistException());
		return modelMapper.map(client, ClientDto.class);
	}

	@Transactional(readOnly = true)
	@Override
	public Iterable<ContactDto> getClientContacts(Long id) {
		if (!clientRepository.existsById(id)) {
			throw new ClientDoesntExistException();
		}
		return contactRepository.findAllByClientClientId(id).map(c->modelMapper.map(c, ContactDto.class))
														.collect(Collectors.toList());
	}

	@Transactional(readOnly = true)
	@Override
	public Iterable<ContactDto> getClientContactsByType(Long id, ContactType contactType) {
		if (!clientRepository.existsById(id)) {
			throw new ClientDoesntExistException();
		}
		return contactRepository.findAllByClientClientIdAndContactType(id,contactType).map(c->modelMapper.map(c, ContactDto.class))
				.collect(Collectors.toList());
	}

}
