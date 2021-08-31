package exoMvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import eshop.repositories.ProduitRepository;

@Controller
public class ProduitController {

	@Autowired
	ProduitRepository produitRepo;

	@GetMapping("/produit")
	public String produit(@RequestParam int id, Model model) {
		model.addAttribute("id", id);
		return "produit";
	}
}
