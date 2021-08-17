import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Client;
import model.Fournisseur;

public class Test {

	public static void main(String[] args) {
		
		Client c = new Client("Courtade","Andy",25,LocalDate.parse("1996-05-01"));
		Fournisseur f = new Fournisseur("Abid","Jordan","AJC");
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("eshop-model");
		EntityManager em = emf.createEntityManager();
		
		
		em.getTransaction().begin();
		em.persist(c);
		em.persist(f);
		
		em.getTransaction().commit();
		
		System.out.println(em.find(Client.class, 1));
		System.out.println(em.find(Fournisseur.class, 2));
		
		em.close();
		emf.close();

	}

}
