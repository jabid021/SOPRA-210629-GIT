package formation.sopra.springBoot.restController;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.util.ReflectionUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;

import formation.sopra.springBoot.exceptions.ProduitException;
import formation.sopra.springBoot.model.Fournisseur;
import formation.sopra.springBoot.model.JsonViews;
import formation.sopra.springBoot.model.Produit;
import formation.sopra.springBoot.repositories.FournisseurRepository;
import formation.sopra.springBoot.repositories.ProduitRepository;

@RestController
@RequestMapping("/api/produit")
@CrossOrigin(origins = "*")
public class ProduitRestController {

	@Autowired
	private ProduitRepository produitRepo;
	@Autowired
	private FournisseurRepository fournisseurRepo;

	@GetMapping("")
	@JsonView(JsonViews.ProduitWthFournisseur.class)
	public List<Produit> getAllProduits() {
		return produitRepo.findAll();
	}

	@GetMapping("/{id}")
	@JsonView(JsonViews.ProduitWthFournisseur.class)
	public Produit getProduit(@PathVariable Integer id) {
		Optional<Produit> opt = produitRepo.findById(id);
		if (opt.isPresent()) {
			return opt.get();
		}
		throw new ProduitException();
	}

	@PostMapping("")
	@JsonView(JsonViews.ProduitWthFournisseur.class)
	@ResponseStatus(HttpStatus.CREATED)
	public Produit create(@Valid @RequestBody Produit produit, BindingResult br) {
		if (br.hasErrors()) {
			throw new ProduitException();
		}
		if (produit.getFournisseur() != null) {
			Optional<Fournisseur> opt = fournisseurRepo.findById(produit.getFournisseur().getId());
			if (!opt.isPresent()) {
				throw new ProduitException();
			}
			produit.setFournisseur(opt.get());
		}
		return produitRepo.save(produit);
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Integer id) {
		Optional<Produit> opt = produitRepo.findById(id);
		if (opt.isPresent()) {
			produitRepo.deleteById(id);
		} else {
			throw new ProduitException();
		}
	}

	@PutMapping("/{id}")
	@JsonView(JsonViews.ProduitWthFournisseur.class)
	public Produit replace(@Valid @RequestBody Produit produit, BindingResult br, @PathVariable Integer id) {
		if (br.hasErrors()) {
			throw new ProduitException();
		}
		Optional<Produit> opt = produitRepo.findById(id);
		if (opt.isPresent()) {
			produit.setId(id);
			return produitRepo.save(produit);
		}
		throw new ProduitException();
	}

	@PatchMapping("/{id}")
	@JsonView(JsonViews.ProduitWthFournisseur.class)
	public Produit modify(@RequestBody Map<String, Object> fields, @PathVariable Integer id) {
		Optional<Produit> opt = produitRepo.findById(id);
		if (opt.isPresent()) {
			Produit produitEnBase = opt.get();
			fields.forEach((key, value) -> {
				Field field = ReflectionUtils.findField(Produit.class, key);
				ReflectionUtils.makeAccessible(field);
				ReflectionUtils.setField(field, produitEnBase, value);
			});
			return produitRepo.save(produitEnBase);
		}
		throw new ProduitException();
	}

}
