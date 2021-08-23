package test;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import metier.Ville;
import metier.Voyage;
import util.Context;

public class TestLazyList {

	
	//Acces aux trajet avant le em.close(); 
	//impossible de filtrer sur des données trajets
	public static void showLazyJoin() 
	{
		EntityManager em = Context.getInstance().getEmf().createEntityManager();

		Query q = em.createQuery("select v from Ville v",Ville.class);
		List<Ville> villes= q.getResultList();

		for(Ville v : villes) 
		{
			System.out.println("--------------------");
			System.out.println("Infos ville : "+v);
			System.out.println("Liste des trajets depart "+v.getTrajetsDepart());
		}

		em.close();
		Context.getInstance().closeEmf();
	}

	//Acces aux trajet avant le em.close(); 
	//uniquement les villes avec un/des trajet(s)
	//possible de filtrer sur des données trajets
	//doublons sur les villes
	public static void showJoin() 
	{
		EntityManager em = Context.getInstance().getEmf().createEntityManager();
		Query q = em.createQuery("select v from Ville v join v.trajetsDepart t",Ville.class);
		List<Ville> villes= q.getResultList();

		for(Ville v : villes) 
		{
			System.out.println("--------------------");
			System.out.println("Infos ville : "+v);
			System.out.println("Liste des trajets depart "+v.getTrajetsDepart());
		}
		em.close();
		Context.getInstance().closeEmf();
	} 
	
	//Acces aux trajet avant le em.close(); 
	//possible de filtrer sur des données trajets
	//doublons sur les villes
	public static void showLeftJoin() 
	{
		EntityManager em = Context.getInstance().getEmf().createEntityManager();
		Query q = em.createQuery("select v from Ville v left join v.trajetsDepart t",Ville.class);
		List<Ville> villes= q.getResultList();

		for(Ville v : villes) 
		{
			System.out.println("--------------------");
			System.out.println("Infos ville : "+v);
			System.out.println("Liste des trajets depart "+v.getTrajetsDepart());
		}
		em.close();
		Context.getInstance().closeEmf();
	}

	//Acces aux trajet apres le em.close(); 
	//uniquement les villes avec un/des trajet(s) (left si on veut les villes sans trajet)
	//doublons sur les villes
	public static void showJoinFetch() 
	{
		EntityManager em = Context.getInstance().getEmf().createEntityManager();
		Query q = em.createQuery("select v from Ville v  join fetch v.trajetsDepart t",Ville.class);
		List<Ville> villes= q.getResultList();
		for(Ville v : villes) 
		{
			System.out.println("--------------------");
			System.out.println("Infos ville : "+v);
			System.out.println("Liste des trajets depart "+v.getTrajetsDepart());
		}
		
		em.close();
		
		Context.getInstance().closeEmf();
	}


	//Acces aux trajet apres le em.close(); 
	//uniquement les villes avec un/des trajet(s)
	//pas de doublons sur les villes
	public static void showRealJoinFetch() 
	{
		EntityManager em = Context.getInstance().getEmf().createEntityManager();
		Query q = em.createQuery("select distinct v from Ville v join fetch v.trajetsDepart t",Ville.class);
		List<Ville> villes= q.getResultList();

		for(Ville v : villes) 
		{
			System.out.println("--------------------");
			System.out.println("Infos ville : "+v);
			System.out.println("Liste des trajets depart "+v.getTrajetsDepart());
		}
		em.close();
		Context.getInstance().closeEmf();
	}
	
	public static void showRealJoinFetchWithFullTrajetNotWorking() 
	{
		EntityManager em = Context.getInstance().getEmf().createEntityManager();
		Query q = em.createQuery("select distinct v from Ville v join fetch v.trajetsDepart t join fetch v.trajetsDestination d",Ville.class);
		List<Ville> villes= q.getResultList();

		for(Ville v : villes) 
		{
			System.out.println("--------------------");
			System.out.println("Infos ville : "+v);
			System.out.println("Liste des trajets depart "+v.getTrajetsDepart());
			System.out.println("Liste des trajets destination "+v.getTrajetsDestination());
			
		}
		em.close();
		Context.getInstance().closeEmf();
	}

	
	public static void showRealJoinFetchWithFullTrajetWORKING() 
	{
		EntityManager em = Context.getInstance().getEmf().createEntityManager();
		Query q = em.createQuery("select distinct v from Ville v join fetch v.trajetsDepart t",Ville.class);
		List<Ville> villes= q.getResultList();
		q = em.createQuery("select distinct v from Ville v join fetch v.trajetsDestination",Ville.class);
		villes= q.getResultList();

		for(Ville v : villes) 
		{
			System.out.println("--------------------");
			System.out.println("Infos ville : "+v);
			System.out.println("Liste des trajets depart "+v.getTrajetsDepart());
			System.out.println("Liste des trajets destination "+v.getTrajetsDestination());
		}
		em.close();
		Context.getInstance().closeEmf();
	}


	public static void main(String[] args) {
		showRealJoinFetchWithFullTrajetWORKING();
	}

}
