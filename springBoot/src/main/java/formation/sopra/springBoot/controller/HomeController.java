package formation.sopra.springBoot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {

	@GetMapping("/home")
	public String home(@RequestParam(name = "username", required = false) String username, Model model) {
		model.addAttribute("username", username);
		return "home";
	}

	@GetMapping({ "/bonjour", "/bonjour/{username}/search" })
	public String bonjout(@PathVariable(name = "username", required = false) String username, Model model) {
		model.addAttribute("username", username);
		return "home";
	}
}
