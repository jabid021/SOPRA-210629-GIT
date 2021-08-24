package eshop;

import java.util.Iterator;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import eshop.dao.DaoProduit;
import eshop.model.Fournisseur;
import eshop.model.Produit;
import eshop.repositories.FournisseurRepository;
import eshop.repositories.ProduitRepository;

public class AppSpring {

	@Autowired
	private DaoProduit daoProduit;

	@Autowired
	private ProduitRepository produitRepo;
	@Autowired
	private FournisseurRepository frsRepo;

	public void run(String[] args) {

		Optional<Fournisseur> opt = frsRepo.findByIdWithProduits(8);
		Fournisseur f = opt.get();
		System.out.println(produitRepo.count());
		produitRepo.deleteByFournisseur(f);
		System.out.println(produitRepo.count());
//		Fournisseur f = new Fournisseur("olivier", "gozlan", "ajc");
//		frsRepo.save(f);

//		System.out.println(produitRepo.findByLibelleContaining("t"));
//		System.out.println(produitRepo.findAll());
//		Optional<Produit> opt = produitRepo.findById(6666);
//		System.out.println(opt);
//		if (opt.isPresent()) {
//			System.out.println(opt.get());
//		}
//		System.out.println(produitRepo.findAll(Sort.by(Sort.Direction.DESC, "libelle")));
//
//		Pageable page1 = PageRequest.of(0, 4);
//		Pageable page2 = PageRequest.of(1, 4);
//		Page<Produit> page = produitRepo.findAll(page1);
//		System.out.println(page);
//		System.out.println(page.getNumberOfElements());
//		Iterator<Produit> iterator = page.iterator();
////		while (iterator.hasNext()) {
////			System.out.println(iterator.next());
////		}
//		System.out.println("-----------------");
//		page = produitRepo.findAll(page2);
//		System.out.println(page);
//		System.out.println(page.getNumberOfElements());
//
//		
	}
}
