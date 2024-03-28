package unibel.repositories;

import org.springframework.data.repository.CrudRepository;

import unibel.models.Client;

public interface ClientRepository extends CrudRepository<Client, Long> {
	
	boolean existsByName(String name);

}
