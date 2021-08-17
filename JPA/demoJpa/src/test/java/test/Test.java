package test;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import model.joined.Linux;
import model.joined.Mac;
import model.joined.Ordinateur;
import model.perClass.Bateau;
import model.perClass.Vehicule;
import model.perClass.Voiture;
import model.single.Animal;
import model.single.Chien;
import model.single.Lion;

public class Test {
	
	public static void main(String[] args) {
	
		Lion a = new Lion("simba",1.20,false);
		Chien a2 = new Chien("Clifford",1.40,true);
		Linux linux = new Linux("Asus","Ubuntu");
		Mac mac = new Mac("Apple",2500);
		Voiture v = new Voiture("Rouge",180);
		Bateau b = new Bateau("Merry",200);
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("toto");
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		
		em.persist(a);
		em.persist(a2);
		em.persist(linux);
		em.persist(mac);
		em.persist(v);
		em.persist(b);
		
		em.getTransaction().commit();
		
		
		Query requete = em.createQuery("from Animal",Animal.class);
		List<Animal> zoo = requete.getResultList();
		System.out.println(zoo);
		
		
		requete = em.createQuery("from Ordinateur",Ordinateur.class);
		List<Ordinateur> parc = requete.getResultList();
		System.out.println(parc);
		
		
		requete = em.createQuery("from Vehicule",Vehicule.class);
		List<Vehicule> vehi = requete.getResultList();
		System.out.println(vehi);

		em.close();
		emf.close();
		

	}

}
