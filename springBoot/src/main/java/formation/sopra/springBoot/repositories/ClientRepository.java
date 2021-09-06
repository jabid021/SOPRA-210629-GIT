package formation.sopra.springBoot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import formation.sopra.springBoot.model.Client;

public interface ClientRepository extends JpaRepository<Client, Integer> {
	
}
