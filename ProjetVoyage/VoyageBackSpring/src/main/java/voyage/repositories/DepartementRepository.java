package voyage.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import voyage.metier.Compte;
import voyage.metier.Departement;
import voyage.metier.Region;

public interface DepartementRepository extends JpaRepository<Departement, Integer> {
	Optional<Departement> findByNom(String nom);

	Optional<Departement> findByNumero(String numero);

	List<Departement> findByRegion(Region region);

	List<Departement> findByNomContaining(String nom);

	@Query("select distinct d from Departement d where d.nom like :lib or d.numero like :lib or d.region like :lib")
	List<Departement> filterDepartement(@Param("lib") String texte);
}
