package guru.springframework.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import guru.springframework.model.Owner;

public interface OwnerRepository extends CrudRepository<Owner, Long> {

	Optional<Owner> findByLastName(String lastName);
}
