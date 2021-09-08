package formation.sopra.springBoot.restController;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;

import formation.sopra.springBoot.model.Achat;
import formation.sopra.springBoot.model.Client;
import formation.sopra.springBoot.model.DataAchat;
import formation.sopra.springBoot.model.ElementAchat;
import formation.sopra.springBoot.model.ElementAchatKey;
import formation.sopra.springBoot.model.JsonViews;
import formation.sopra.springBoot.model.LoginUserDetails;
import formation.sopra.springBoot.repositories.AchatRepository;
import formation.sopra.springBoot.repositories.ClientRepository;
import formation.sopra.springBoot.repositories.ElementAchatRepository;
import formation.sopra.springBoot.repositories.ProduitRepository;

@RestController
@RequestMapping("/api/achat")
@CrossOrigin(origins = "*")
public class AchatRestController {

	@Autowired
	private ClientRepository clientRepo;
	@Autowired
	private ProduitRepository produitRepo;
	@Autowired
	private AchatRepository achatRepo;
	@Autowired
	private ElementAchatRepository elementAchatRepo;

	@GetMapping("")
	@JsonView(JsonViews.AchatWithClientAndProduit.class)
	public List<Achat> getAll() {
		return achatRepo.findAll();
	}

	@GetMapping("/{id}")
	@JsonView(JsonViews.AchatWithClientAndProduit.class)
	public Achat get(@PathVariable Integer id) {
		return achatRepo.findById(id).get();
	}

	@PostMapping("")
	@JsonView(JsonViews.AchatWithClient.class)
	public Achat achat(@RequestBody List<DataAchat> list, @AuthenticationPrincipal LoginUserDetails lUD) {
		Client client = clientRepo.findByLogin(lUD.getLogin()).get();
		Achat achat = new Achat(LocalDate.now(), client);
		achatRepo.save(achat);
		list.stream().forEach(da -> {
			ElementAchat ea = new ElementAchat(
					new ElementAchatKey(produitRepo.findById(da.getIdProduit()).get(), achat), da.getQuantite());
			elementAchatRepo.save(ea);
		});
		return achat;
	}
}
