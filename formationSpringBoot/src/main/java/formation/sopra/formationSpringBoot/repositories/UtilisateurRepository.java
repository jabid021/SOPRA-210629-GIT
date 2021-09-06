package formation.sopra.formationSpringBoot.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import formation.sopra.formationSpringBoot.model.Utilisateur;

public interface UtilisateurRepository extends JpaRepository<Utilisateur, Long> {
	public Optional<Utilisateur> findByLogin(String login);
}
