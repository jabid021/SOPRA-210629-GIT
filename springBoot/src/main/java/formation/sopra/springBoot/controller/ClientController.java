package formation.sopra.springBoot.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import formation.sopra.springBoot.model.Civilite;
import formation.sopra.springBoot.model.Client;
import formation.sopra.springBoot.model.Login;
import formation.sopra.springBoot.model.Role;
import formation.sopra.springBoot.repositories.ClientRepository;
import formation.sopra.springBoot.repositories.LoginRepository;

@Controller
@RequestMapping("/client")
public class ClientController {

	@Autowired
	private ClientRepository clientRepo;
	@Autowired
	private LoginRepository loginRepo;
	@Autowired
	private PasswordEncoder passwordEncoder;

	@GetMapping("")
	public ModelAndView list() {
		ModelAndView modelAndView = new ModelAndView("client/list");
		modelAndView.addObject("clients", clientRepo.findAll());
		return modelAndView;
	}

	@GetMapping("/delete/{id}")
	public ModelAndView delete(@PathVariable Integer id) {
		clientRepo.deleteById(id);
		return new ModelAndView("redirect:/client");
	}

	@GetMapping({ "/inscription" })
	public ModelAndView add() {
		Client c = new Client();
		c.setLogin(new Login());
		return goEdit(c);
	}

	@GetMapping("/edit/{id}")
	public ModelAndView edit(@PathVariable Integer id) {
		return goEdit(clientRepo.findById(id).get());
	}

	private ModelAndView goEdit(Client client) {
		ModelAndView modelAndView = new ModelAndView("client/edit");
		modelAndView.addObject("client", client);
		modelAndView.addObject("civilites", Civilite.values());
		return modelAndView;
	}

	@PostMapping("/save")
	public ModelAndView save(@Valid @ModelAttribute Client client, BindingResult br) {
		if (br.hasErrors()) {
			return goEdit(client);
		}
		boolean inscription = false;
		if (client.getId() == null) {
			inscription = true;
		}
		client.getLogin().setRole(Role.ROLE_USER);

		client.getLogin().setPassword(passwordEncoder.encode(client.getLogin().getPassword()));
		loginRepo.save(client.getLogin());
		clientRepo.save(client);
		if (inscription) {
			return new ModelAndView("redirect:/achat/recap");
		}
		return new ModelAndView("redirect:/client");
	}
}
