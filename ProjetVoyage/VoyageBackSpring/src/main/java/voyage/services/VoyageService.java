package voyage.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import voyage.metier.Voyage;
import voyage.repositories.VilleRepository;
import voyage.repositories.VoyageRepository;

@Service
public class VoyageService {

	@Autowired
	private VoyageRepository voyageRepo;
	@Autowired
	private VilleRepository villeRepo;

	List<Voyage> filter(String filtre) {
		// controle avant execution de la requete
		return voyageRepo.filterVoyage("%" + filtre + "%");
	}
}
