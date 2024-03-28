package unibel.repositories;

import java.util.stream.Stream;

import org.springframework.data.repository.CrudRepository;

import unibel.models.Contact;
import unibel.models.ContactType;

public interface ContactRepository extends CrudRepository<Contact, Long> {
	
	Stream<Contact> findAllByClientClientId(Long clientId);
	
	Stream<Contact> findAllByClientClientIdAndContactType(Long clientId,ContactType contactType);

}
