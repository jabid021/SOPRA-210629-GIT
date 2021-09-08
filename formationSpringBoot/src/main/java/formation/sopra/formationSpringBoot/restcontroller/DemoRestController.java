package formation.sopra.formationSpringBoot.restcontroller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import formation.sopra.formationSpringBoot.model.Categorie;
import formation.sopra.formationSpringBoot.model.Produit;

@RestController
public class DemoRestController {

	@GetMapping("/api/hello")
	public ResponseEntity<String> sayHelloWorld() {
		return new ResponseEntity<String>("hello world du restController", HttpStatus.OK);
	}

	@GetMapping("/api/hello/v2")
	@ResponseStatus(HttpStatus.OK)
	public String sayHelloV2() {
		return "hello world v2";
	}

	@GetMapping("/api/produit")
	public Produit getProduit() {
		return new Produit("velo", 200, new Categorie("sport"));
	}
}
