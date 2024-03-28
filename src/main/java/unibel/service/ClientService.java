package unibel.service;

import unibel.dtos.ClientDto;
import unibel.dtos.ContactDto;
import unibel.models.Client;
import unibel.models.ContactType;

public interface ClientService {
	
	void addClient(ClientDto clientDto);
	
	void addContactToClient(ContactDto contactDto,Long clientId);
	
	Iterable<ClientDto> getClients();
	
	ClientDto getClient(Long id);
	
	Iterable<ContactDto> getClientContacts(Long id);
	
	Iterable<ContactDto> getClientContactsByType(Long id,ContactType contactType);

}
