package formation.sopra.springBoot.controller;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import formation.sopra.springBoot.model.Achat;
import formation.sopra.springBoot.model.ElementAchat;
import formation.sopra.springBoot.model.ElementAchatKey;
import formation.sopra.springBoot.model.LoginUserDetails;
import formation.sopra.springBoot.model.Produit;
import formation.sopra.springBoot.repositories.AchatRepository;
import formation.sopra.springBoot.repositories.ClientRepository;
import formation.sopra.springBoot.repositories.ElementAchatRepository;
import formation.sopra.springBoot.repositories.ProduitRepository;

@Controller
@RequestMapping("/achat")
public class AchatController {

	@Autowired
	private ProduitRepository produitRepo;
	@Autowired
	private ClientRepository clientRepo;
	@Autowired
	private AchatRepository achatRepo;
	@Autowired
	private ElementAchatRepository eaRepo;

	@GetMapping("")
	public ModelAndView achat(@RequestParam(name = "page", required = false, defaultValue = "0") Integer n) {
		return goList(PageRequest.of(n, 4));
	}

	private ModelAndView goList(Pageable pageable) {
		ModelAndView modelAndView = new ModelAndView("achat/achat");
		modelAndView.addObject("produits", produitRepo.findAll(pageable));
		return modelAndView;
	}

	@PostMapping("/addPanier")
	public ModelAndView addPanier(
			@RequestParam(name = "quantite", required = false, defaultValue = "1") Integer quantite,
			@RequestParam Integer id, HttpSession session) {
		if (session.getAttribute("panier") == null) {
			session.setAttribute("panier", new HashMap<Produit, Integer>());
		}
		Map<Produit, Integer> panier = (Map<Produit, Integer>) session.getAttribute("panier");
		Produit produit = produitRepo.findById(id).get();
		if (panier.containsKey(produit)) {
			panier.put(produit, panier.get(produit) + quantite);
		} else {
			panier.put(produit, quantite);
		}
		return new ModelAndView("redirect:/achat");
	}

	@GetMapping("/recap")
	public ModelAndView recap() {
		ModelAndView modelAndView = new ModelAndView("achat/recap");
		modelAndView.addObject("clients", clientRepo.findAll());
		return modelAndView;
	}

	@PreAuthorize("hasAnyRole('USER')")
	@GetMapping("/valid")
	public ModelAndView valid(@AuthenticationPrincipal LoginUserDetails lUD, HttpSession session) {

		Achat achat = new Achat(LocalDate.now(), clientRepo.findByLogin(lUD.getLogin()).get());
		achatRepo.save(achat);
		Map<Produit, Integer> panier = (Map<Produit, Integer>) session.getAttribute("panier");
		for (Produit produit : panier.keySet()) {
			eaRepo.save(new ElementAchat(new ElementAchatKey(produit, achat), panier.get(produit)));
		}
		session.invalidate();
		ModelAndView modelAndView = new ModelAndView("achat/ok");
		modelAndView.addObject("achat", achat);
		return modelAndView;
	}
}
