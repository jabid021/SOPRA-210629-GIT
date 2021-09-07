package formation.sopra.springBoot.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import formation.sopra.springBoot.model.Client;
import formation.sopra.springBoot.model.Login;

public interface ClientRepository extends JpaRepository<Client, Integer> {
	public Optional<Client> findByLogin(Login login);
}
