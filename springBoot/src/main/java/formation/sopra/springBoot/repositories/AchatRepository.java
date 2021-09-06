package formation.sopra.springBoot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import formation.sopra.springBoot.model.Achat;

public interface AchatRepository extends JpaRepository<Achat, Integer> {

}
