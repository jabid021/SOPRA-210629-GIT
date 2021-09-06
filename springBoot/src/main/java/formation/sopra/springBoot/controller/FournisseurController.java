package formation.sopra.springBoot.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import formation.sopra.springBoot.model.Civilite;
import formation.sopra.springBoot.model.Fournisseur;
import formation.sopra.springBoot.repositories.FournisseurRepository;
import formation.sopra.springBoot.repositories.ProduitRepository;

@Controller
@RequestMapping("/fournisseur")
public class FournisseurController {

	@Autowired
	private FournisseurRepository fournisseurRepo;
	@Autowired
	private ProduitRepository produitRepo;

	@GetMapping("")
	public ModelAndView list() {
		ModelAndView modelAndView = new ModelAndView("fournisseur/list");
		modelAndView.addObject("fournisseurs", fournisseurRepo.findAll());
		return modelAndView;
	}

	@GetMapping("/delete/{id}")
	public ModelAndView delete(@PathVariable Integer id) {
		produitRepo.setFournisseurNullByFournisseur(fournisseurRepo.findById(id).get());
		fournisseurRepo.deleteById(id);
		return new ModelAndView("redirect:/fournisseur");
	}

	@GetMapping("/add")
	public ModelAndView add() {
		return goEdit(new Fournisseur());
	}

	@GetMapping("/edit/{id}")
	public ModelAndView edit(@PathVariable Integer id) {
		return goEdit(fournisseurRepo.findById(id).get());
	}

	private ModelAndView goEdit(Fournisseur fournisseur) {
		ModelAndView modelAndView = new ModelAndView("fournisseur/edit");
		modelAndView.addObject("fournisseur", fournisseur);
		modelAndView.addObject("civilites", Civilite.values());
		return modelAndView;
	}

	@PostMapping("/save")
	public ModelAndView save(@Valid @ModelAttribute Fournisseur fournisseur, BindingResult br) {
		if (br.hasErrors()) {
			return goEdit(fournisseur);
		}
		fournisseurRepo.save(fournisseur);
		return new ModelAndView("redirect:/fournisseur");
	}
}
