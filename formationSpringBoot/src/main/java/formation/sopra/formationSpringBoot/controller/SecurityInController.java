package formation.sopra.formationSpringBoot.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import formation.sopra.formationSpringBoot.model.UtilisateurSpring;

@Controller
@RequestMapping("/controller")
public class SecurityInController {

	public static Logger LOG = LoggerFactory.getLogger(SecurityInController.class);

	@PreAuthorize("hasAnyRole('ADMIN')")
	@GetMapping("")
//	public String home(Authentication authentication) {
//		LOG.info(authentication.getPrincipal().toString());
//		UtilisateurSpring uS = (UtilisateurSpring) authentication.getPrincipal();
//		//uS.getUtilisateur()
//		return "controller/home";
//	}
	public String home(@AuthenticationPrincipal UtilisateurSpring utilisateurSpring) {
		LOG.info(utilisateurSpring.toString());
		return "controller/home";
	}
}
