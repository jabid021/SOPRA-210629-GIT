package formation.sopra.formationSpringBoot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import formation.sopra.formationSpringBoot.model.Utilisateur;

public interface UtilisateurRepository extends JpaRepository<Utilisateur, Long> {

}
