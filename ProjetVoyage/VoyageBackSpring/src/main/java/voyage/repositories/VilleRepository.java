package voyage.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import voyage.metier.Ville;

public interface VilleRepository extends JpaRepository<Ville, Integer>{
	List<Ville> findByNomContaining(String nom);
}
