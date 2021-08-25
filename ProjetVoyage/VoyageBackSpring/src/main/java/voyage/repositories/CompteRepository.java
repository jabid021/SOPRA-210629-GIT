package voyage.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import voyage.metier.Compte;

public interface CompteRepository extends JpaRepository<Compte, Integer> {
	@Query("from Compte c where c.login=:text or c.password=:text")
	List<Compte> findByLoginContainingOrPasswordContaining(@Param("text") String texte);

	Optional<Compte> findByLoginAndPassword(String login, String password);
}
