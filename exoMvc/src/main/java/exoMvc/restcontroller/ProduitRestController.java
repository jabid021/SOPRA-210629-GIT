package exoMvc.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import eshop.model.Produit;
import eshop.repositories.ProduitRepository;

@RestController
@RequestMapping("/api/produit")
public class ProduitRestController {

	@Autowired
	private ProduitRepository produitRepo;

	@GetMapping("")
	public ResponseEntity<List<Produit>> list() {
		return new ResponseEntity<List<Produit>>(produitRepo.findAll(), HttpStatus.OK);
	}
}
