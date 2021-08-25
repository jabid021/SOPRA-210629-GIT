package voyage.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import voyage.metier.Voyage;

public interface VoyageRepository extends JpaRepository<Voyage, Integer> {

	@Query("select distinct v from Voyage v " 
			+ "where v.trajet.depart.nom like :lib "
			+ "or v.trajet.destination.nom like :lib " 
			+ "or v.transport.nom like :lib")
	List<Voyage> filterVoyage(@Param("lib") String lib);
	
}
