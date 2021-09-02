package exoMvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/achat")
public class AchatController {

	@GetMapping("")
	public ModelAndView achat() {
		return new ModelAndView("achat/achat");
	}
}
