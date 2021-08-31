package formationSpringMvc.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import formationSpringMvc.model.User;

@Controller
@RequestMapping("/demo")
public class HelloController {

	@RequestMapping({ "/hello", "/he" })
	public String hello() {
		return "hello";
	}

	@RequestMapping(path = "/bonjour", method = RequestMethod.GET)
	public String bis() {
		return "hello";
	}

	// @PostMapping()
	// @PutMapping()
	@GetMapping("/get")
	public String methodeEnGet() {
		return "hello";
	}

	@GetMapping("/param")
	public String parametre(
			@RequestParam(name = "prenom", required = false, defaultValue = "world") String prenom,
			@RequestParam String nom, 
			Model model, 
			HttpSession session) {
		model.addAttribute("prenom", prenom);
		model.addAttribute("nom", nom);
		model.addAttribute("user", new User(prenom, nom));
		return "param";
	}
}
