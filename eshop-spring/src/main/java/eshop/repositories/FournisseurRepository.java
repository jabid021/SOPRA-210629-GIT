package eshop.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import eshop.model.Fournisseur;

public interface FournisseurRepository extends JpaRepository<Fournisseur, Integer> {

	@Query("select distinct f from Fournisseur f left join fetch f.produits where f.id=:id")
	Optional<Fournisseur> findByIdWithProduits(@Param("id") Integer id);
}
