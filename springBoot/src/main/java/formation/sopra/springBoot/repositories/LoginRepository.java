package formation.sopra.springBoot.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import formation.sopra.springBoot.model.Login;

public interface LoginRepository extends JpaRepository<Login, Long> {
	Optional<Login> findByLogin(String login);
}
