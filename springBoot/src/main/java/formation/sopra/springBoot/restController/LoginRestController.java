package formation.sopra.springBoot.restController;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;

import formation.sopra.springBoot.model.JsonViews;
import formation.sopra.springBoot.model.Login;
import formation.sopra.springBoot.model.LoginUserDetails;
import formation.sopra.springBoot.repositories.LoginRepository;

@RestController
@RequestMapping("/api/login")
@CrossOrigin(origins = "*")
public class LoginRestController {

	@Autowired
	private LoginRepository loginRepo;

	@GetMapping("/isPresent/{login}")
	public boolean isPresent(@PathVariable String login) {
		return loginRepo.findByLogin(login).isPresent();
	}

	@GetMapping("")
	@JsonView(JsonViews.LoginWithRole.class)
	public Login auth(@AuthenticationPrincipal LoginUserDetails lUD) {
		return lUD.getLogin();
	}
}
