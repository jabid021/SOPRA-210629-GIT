package voyage.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import voyage.metier.Compte;
import voyage.metier.Transport;

public interface TransportRepository extends JpaRepository<Transport, Integer> {
	List<Transport> findByNom(String nom);
}
