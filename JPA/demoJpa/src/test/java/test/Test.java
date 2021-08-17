package test;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Cuisinier;
import model.Ingredient;
import model.Plat;
import model.Recette;
import model.Unite;

public class Test {
	
	public static void testHeritage() 
	{
		/*Lion a = new Lion("simba",1.20,false);
		Chien a2 = new Chien("Clifford",1.40,true);
		Linux linux = new Linux("Asus","Ubuntu");
		Mac mac = new Mac("Apple",2500);
		Voiture v = new Voiture("Rouge",180);
		Bateau b = new Bateau("Merry",200);
		*/
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("toto");
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		
		/*em.persist(a);
		em.persist(a2);
		em.persist(linux);
		em.persist(mac);
		em.persist(v);
		em.persist(b);
		*/
		em.getTransaction().commit();
		
		
		/*Query requete = em.createQuery("from Animal",Animal.class);
		List<Animal> zoo = requete.getResultList();
		System.out.println(zoo);
		
		
		requete = em.createQuery("from Ordinateur",Ordinateur.class);
		List<Ordinateur> parc = requete.getResultList();
		System.out.println(parc);
		
		
		requete = em.createQuery("from Vehicule",Vehicule.class);
		List<Vehicule> vehi = requete.getResultList();
		System.out.println(vehi);
*/
		em.close();
		emf.close();
	}
	public static void main(String[] args) {
	
		
		Cuisinier sanji = new Cuisinier("Vinsmoke","Sanji");
		Ingredient i1 = new Ingredient("farine",Unite.g,250);
		Ingredient i2 = new Ingredient("lait",Unite.L,0.5);
		Ingredient i3 = new Ingredient("sucre",Unite.cs,2);
		Ingredient i4 = new Ingredient("oeuf",null,4);
		Ingredient i5 = new Ingredient("sel",Unite.pincee,1);
		Ingredient i6 = new Ingredient("beurre",Unite.g,50);
		List<Ingredient> ingredients = new ArrayList();
		ingredients.add(i1);
		ingredients.add(i2);
		ingredients.add(i3);
		ingredients.add(i4);
		ingredients.add(i5);
		ingredients.add(i6);
		
		Plat p = new Plat("crepes",sanji);
		
		Recette r = new Recette(p,ingredients);
	
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("toto");
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		
		em.persist(i1);
		em.persist(i2);
	
		em.getTransaction().commit();
		
	
		System.out.println(em.find(Ingredient.class, 1));
		System.out.println(em.find(Ingredient.class, 2));
		
		em.close();
		emf.close();
		

	}

}
