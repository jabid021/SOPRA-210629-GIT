package test;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import model.Cuisinier;
import model.Ingredient;
import model.Plat;
import model.Recette;
import model.Unite;
import util.Context;

public class Test {
	
	
	public static Recette findById(int id) 
	{
		EntityManager em = Context.getInstance().getEmf().createEntityManager();
		Recette r = em.find(Recette.class,id);
		em.close();
		return r;
	}
	
	public static List<Recette> findAll()
	{
		
		EntityManager em = Context.getInstance().getEmf().createEntityManager();
		//Query query= em.createQuery("from Recette",Recette.class);
		//List<Recette> recettes = query.getResultList();
		List<Recette> recettes = em.createQuery("from Recette",Recette.class).getResultList();
		em.close();
		return recettes;
	}
	
	
	public static List<Ingredient> findByLibelleLike(String libelle)
	{
		EntityManager em = Context.getInstance().getEmf().createEntityManager();
		Query query= em.createQuery("from Ingredient i where i.nom like :lib",Ingredient.class);
		query.setParameter("lib", "%"+libelle+"%");
		List<Ingredient> ingredients = query.getResultList();
		em.close();
		return ingredients;
	}
	
	public static Ingredient findByLibelle(String libelle)
	{
		EntityManager em = Context.getInstance().getEmf().createEntityManager();
		Query query= em.createQuery("from Ingredient i where i.nom = :lib",Ingredient.class);
		query.setParameter("lib", libelle);
		Ingredient ingredient = (Ingredient) query.getSingleResult();
		em.close();
		return ingredient;
	}
	
	public static Recette insert(Recette r) 
	{
		EntityManager em = Context.getInstance().getEmf().createEntityManager();
		
		em.getTransaction().begin();
		em.persist(r);
		em.getTransaction().commit();
		em.close();
		return r;
	}
	
	public static Recette update(Recette nonManaged) 
	{
		EntityManager em = Context.getInstance().getEmf().createEntityManager();
		em.getTransaction().begin();
		Recette managed=em.merge(nonManaged);
		em.getTransaction().commit();
		em.close();
		return managed;
	}
	
	public static void delete(int id) 
	{
		EntityManager em = Context.getInstance().getEmf().createEntityManager();
		Recette r = em.find(Recette.class,id);
		em.getTransaction().begin();
		em.remove(r);
		em.getTransaction().commit();
		em.close();
	}
	
	public static void delete(Recette r) 
	{
		
		EntityManager em = Context.getInstance().getEmf().createEntityManager();
		em.getTransaction().begin();
		r=em.merge(r);
		em.remove(r);
		em.getTransaction().commit();
		em.close();
	}
	
	
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
		
		
		r= insert(r);
		
		
		System.out.println("Ingredients avec un 'e' : ");
		System.out.println(findByLibelleLike("e"));
		
		System.out.println("\nIngredient lait : ");
		System.out.println(findByLibelle("lait"));
		
		//System.out.println(re.getPlat());
		//System.out.println("Recette des : "+re.getPlat().getNom());
		//System.out.println("Liste des ingredients : ");
	
		//System.out.println(re.getIngredients());
	
		
		Context.getInstance().closeEmf();
	
		//em.persist(test) => test est managed
		//test=em.find() => test est managed
		//test2 = em.merge(test) => test n'est pas managed par contre test2 l'est !
		//em.remove(test) => test est removed
	}

}
