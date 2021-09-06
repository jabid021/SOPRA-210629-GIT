package formation.sopra.springBoot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import formation.sopra.springBoot.model.ElementAchat;
import formation.sopra.springBoot.model.ElementAchatKey;

public interface ElementAchatRepository extends JpaRepository<ElementAchat, ElementAchatKey> {

}
