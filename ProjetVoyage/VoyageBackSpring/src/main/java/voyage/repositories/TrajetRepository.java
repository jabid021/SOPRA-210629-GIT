package voyage.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import voyage.metier.Trajet;
import voyage.metier.Ville;

public interface TrajetRepository extends JpaRepository<Trajet, Integer> {

	@Query("from Trajet t where t.depart=:ville or t.destination=:ville")
	List<Trajet> findByDepartOrDestination(@Param("ville") Ville ville);
}
