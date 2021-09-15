package formation.sopra.springBoot.restController;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClientException;

import com.fasterxml.jackson.annotation.JsonView;

import formation.sopra.springBoot.model.Client;
import formation.sopra.springBoot.model.JsonViews;
import formation.sopra.springBoot.model.Role;
import formation.sopra.springBoot.repositories.ClientRepository;
import formation.sopra.springBoot.repositories.LoginRepository;

@RestController
@RequestMapping("/api/client")
@CrossOrigin(origins = "*")
public class ClientRestController {
	@Autowired
	private ClientRepository clientRepo;
	@Autowired
	private LoginRepository loginRepo;
	@Autowired
	private PasswordEncoder passwordEncoder;

	@PostMapping("/inscription")
	@JsonView(JsonViews.ClientWithLogin.class)
	public Client create(@Valid @RequestBody Client client, BindingResult br) {
		if (br.hasErrors()) {
			throw new RestClientException("erreur client");
		}
		client.getLogin().setRole(Role.ROLE_USER);
		client.getLogin().setPassword(passwordEncoder.encode(client.getLogin().getPassword()));
		loginRepo.save(client.getLogin());
		clientRepo.save(client);
		
		return client;
	}
}
