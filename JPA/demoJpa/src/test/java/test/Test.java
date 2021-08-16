package test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Animal;

public class Test {
	
	public static void main(String[] args) {
	
		Animal a = new Animal("simba",1.20);
		Animal a2 = new Animal("tigrou",1.40);
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("toto");
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		
		em.persist(a);
		em.persist(a2);
		
		
		em.getTransaction().commit();
		
		
		a = em.find(Animal.class, 1);
		
		System.out.println(a);

		em.close();
		emf.close();
		

	}

}
