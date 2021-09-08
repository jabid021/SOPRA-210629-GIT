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

import formation.sopra.springBoot.exceptions.FournisseurException;
import formation.sopra.springBoot.model.Civilite;
import formation.sopra.springBoot.model.Fournisseur;
import formation.sopra.springBoot.model.JsonViews;
import formation.sopra.springBoot.repositories.FournisseurRepository;

@RestController
@RequestMapping("/api/fournisseur")
@CrossOrigin(origins = "*")
public class FournisseurRestController {

	@Autowired
	private FournisseurRepository fournisseurRepo;

	@GetMapping("")
	@JsonView(JsonViews.Common.class)
	public List<Fournisseur> getAllFournisseur() {
		return getAll();
	}

	@GetMapping("/produit")
	@JsonView(JsonViews.FournisseurWithProduits.class)
	public List<Fournisseur> getAllFournisseurWithProduits() {
		return getAll();
	}

	private List<Fournisseur> getAll() {
		return fournisseurRepo.findAll();
	}

	@PostMapping("")
	@JsonView(JsonViews.Common.class)
	@ResponseStatus(HttpStatus.CREATED)
	public Fournisseur create(@Valid @RequestBody Fournisseur fournisseur, BindingResult br) {
		if (br.hasErrors()) {
			throw new FournisseurException();
		}
		return fournisseurRepo.save(fournisseur);
	}

	@GetMapping("/{id}")
	@JsonView(JsonViews.Common.class)
	public Fournisseur getById(@PathVariable Integer id) {
		return findById(id);
	}

	@GetMapping("/{id}/produit")
	@JsonView(JsonViews.FournisseurWithProduits.class)
	public Fournisseur getByIdWithProduit(@PathVariable Integer id) {
		return findById(id);
	}

	private Fournisseur findById(Integer id) throws FournisseurException {
		Optional<Fournisseur> opt = fournisseurRepo.findById(id);
		if (opt.isPresent()) {
			return opt.get();
		}
		throw new FournisseurException();
	}

	@PutMapping("/{id}")
	@JsonView(JsonViews.Common.class)
	public Fournisseur put(@Valid @RequestBody Fournisseur fournisseur, BindingResult br, @PathVariable Integer id) {
		return fournisseurRepo.save(fournisseur);
	}

	@PatchMapping("/{id}")
	@JsonView(JsonViews.Common.class)
	public Fournisseur patch(@RequestBody Map<String, Object> fields, @PathVariable Integer id) {
		Optional<Fournisseur> opt = fournisseurRepo.findById(id);
		if (opt.isPresent()) {
			Fournisseur fournisseur = opt.get();
			fields.forEach((key, value) -> {
				Field field = ReflectionUtils.findField(Fournisseur.class, key);
				ReflectionUtils.makeAccessible(field);
				if (key.equals("civilite")) {
					value = Civilite.valueOf(value.toString());
				}
				ReflectionUtils.setField(field, fournisseur, value);
			});
			return fournisseurRepo.save(fournisseur);
		}
		throw new FournisseurException();
	}

}
