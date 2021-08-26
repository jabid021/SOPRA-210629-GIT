package voyage.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import voyage.exception.DepartementException;
import voyage.metier.Departement;
import voyage.metier.Region;
import voyage.repositories.DepartementRepository;

@Service
public class DepartementService {
	@Autowired
	private DepartementRepository departementRepo;

	private void checkDepartement(Departement d) throws DepartementException {
		if (d == null || d.getNom() == null || d.getNom().isEmpty() || d.getNumero() == null || d.getNumero().isEmpty()
				|| d.getRegion() == null) {
			throw new DepartementException();
		}
	}

	public void save(Departement d) {
		checkDepartement(d);
		departementRepo.save(d);
	}

	public Departement findByNomStrict(String nom) {
		if (nom == null || nom.isEmpty()) {
			throw new DepartementException();
		}
		Optional<Departement> opt = departementRepo.findByNom(nom);
		return opt.isPresent() ? opt.get() : null;
	}

	public Departement findByNumero(String numero) {
		if (numero == null | numero.isEmpty()) {
			throw new DepartementException();
		}
		Optional<Departement> opt = departementRepo.findByNumero(numero);
		return opt.isPresent() ? opt.get() : null;
	}

	public List<Departement> findByRegion(Region region) {
		if (region == null) {
			throw new DepartementException();
		}
		return departementRepo.findByRegion(region);
	}

	public List<Departement> findByNomContaining(String nom) {
		if (nom == null || nom.isEmpty()) {
			throw new DepartementException();
		}
		return departementRepo.findByNomContaining(nom);
	}

	public List<Departement> filter(String filter) {
		if (filter == null) {
			throw new DepartementException();
		}
		return departementRepo.filterDepartement("%" + filter + "%");
	}

}
