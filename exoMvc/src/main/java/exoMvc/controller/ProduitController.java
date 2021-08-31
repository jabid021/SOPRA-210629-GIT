package exoMvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ProduitController {
	@GetMapping("/produit")
	public String produit(@RequestParam int id, Model model) {
		model.addAttribute("id", id);
		return "produit";
	}
}
