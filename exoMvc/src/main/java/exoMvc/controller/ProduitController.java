package exoMvc.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import eshop.model.Produit;
import eshop.repositories.FournisseurRepository;
import eshop.repositories.ProduitRepository;

@Controller
@RequestMapping("/produit")
public class ProduitController {

	@Autowired
	ProduitRepository produitRepo;
	@Autowired
	FournisseurRepository fournisseurRepo;

	@GetMapping("")
	public String list(Model model) {
		model.addAttribute("produits", produitRepo.findAll());
		return "produit/list";
	}

	@GetMapping("/delete")
	public String delete(@RequestParam Integer id) {
		produitRepo.deleteById(id);
		return "redirect:/produit/";
	}

	@GetMapping("/edit")
	public String edit(@RequestParam Integer id, Model model) {
		return goEdit(produitRepo.findById(id).get(), model);
	}

	@GetMapping("/add")
	public String add(Model model) {
		return goEdit(new Produit(), model);
	}

	private String goEdit(Produit produit, Model model) {
		model.addAttribute("fournisseurs", fournisseurRepo.findAll());
		model.addAttribute("produit", produit);
		return "produit/edit";
	}

//	@PostMapping("/save")
//	private String save(@RequestParam String libelle, @RequestParam double prix,
//			@RequestParam(name = "id", required = false) Integer id) {
//		Produit produit = new Produit(id, libelle, prix, null);
//		produitRepo.save(produit);
//		return "redirect:/produit/";
//	}
	@PostMapping("/save")
	public String save(@Valid @ModelAttribute("produit") Produit produit, BindingResult br, Model model) {
		if (produit.getFournisseur().getId() == null) {
			produit.setFournisseur(null);
		}
		if (br.hasErrors()) {
			return goEdit(produit, model);
		}
		produitRepo.save(produit);
		return "redirect:/produit/";
	}
}
