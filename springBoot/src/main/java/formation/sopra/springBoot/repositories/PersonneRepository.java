package formation.sopra.springBoot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import formation.sopra.springBoot.model.Personne;

public interface PersonneRepository extends JpaRepository<Personne, Integer> {

}
