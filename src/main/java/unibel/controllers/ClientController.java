package unibel.controllers;

import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import unibel.dtos.ClientDto;
import unibel.dtos.ContactDto;
import unibel.models.ContactType;
import unibel.service.ClientService;

@RestController
@RequiredArgsConstructor
public class ClientController {
	
	final private ClientService clientService;
	
	@PostMapping("/client")
	public ResponseEntity<Object> addClient(@RequestBody ClientDto clientDto) {
		try {
			clientService.addClient(clientDto);
			return ResponseEntity.status(HttpStatus.CREATED).build();
		} catch (RuntimeException e) {
			return ResponseEntity.status(HttpStatus.CONFLICT).body("Client already exist");
		}
	}
	
	@PostMapping("/client/{clientId}/contact")
	public ResponseEntity<Object> addContactToClient(@RequestBody ContactDto contactDto,@PathVariable Long clientId){
		try {
			clientService.addContactToClient(contactDto, clientId);
			return ResponseEntity.status(HttpStatus.CREATED).build();
		} catch (RuntimeException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
		}
	}
	
	@GetMapping("/clients")
	public ResponseEntity<Object> getClients(){
		return ResponseEntity.ok().body(clientService.getClients());
	}
	
	@GetMapping("/client/{clientId}")
	public ResponseEntity<Object> getClient(@PathVariable Long clientId){
		try {
			return ResponseEntity.ok().body(clientService.getClient(clientId));
		} catch (RuntimeException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
		}
	}
	
	@GetMapping("/client/{clientId}/contacts")
	public ResponseEntity<Object> getClientContacts(@PathVariable Long clientId){
		try {
			return ResponseEntity.ok().body(clientService.getClientContacts(clientId));
		} catch (RuntimeException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
		}
	}
	
	@GetMapping("/client/{id}/contacts/types")
	public ResponseEntity<Object> getClientContactsByType(@PathVariable Long id,@RequestParam("contactType") ContactType contactType){
		try {
			return ResponseEntity.ok().body(clientService.getClientContactsByType(id, contactType));
		} catch (RuntimeException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
		}
	}

}
