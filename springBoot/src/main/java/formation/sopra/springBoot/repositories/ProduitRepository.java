package formation.sopra.springBoot.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import formation.sopra.springBoot.model.Fournisseur;
import formation.sopra.springBoot.model.Produit;

public interface ProduitRepository extends JpaRepository<Produit, Integer> {

	// Optional si 1 resultat garanti
	// List si plusieurs resultat possible
	List<Produit> findByLibelle(String libelle);

	List<Produit> findByLibelleContaining(String libelle);

	@Transactional
	@Modifying
	@Query("update Produit p set p.fournisseur=null where p.fournisseur=:fournisseur")
	void setFournisseurNullByFournisseur(@Param("fournisseur") Fournisseur fournisseur);

	@Transactional
	@Modifying
	@Query("delete from Produit p where p.fournisseur=:fournisseur")
	void deleteByFournisseur(@Param("fournisseur") Fournisseur fournisseur);
}
