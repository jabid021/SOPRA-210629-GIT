package dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import dao.IDAODepartement;
import metier.Departement;
import metier.Region;
import util.Context;

public class DAODepartementJPA implements IDAODepartement {

	@Override
	public Departement findById(Integer id) {
		EntityManager em = Context.getInstance().getEmf().createEntityManager();
		Departement d = em.find(Departement.class,id);
		em.close();
		return d;
	}

	@Override
	public List<Departement> findAll() {
		EntityManager em = Context.getInstance().getEmf().createEntityManager();
		List<Departement> departements = em.createQuery("from Departement",Departement.class).getResultList();
		em.close();
		return departements;
	}
	
	public static Departement findByNom(String nom)
	{
		EntityManager em = Context.getInstance().getEmf().createEntityManager();
		Query query= em.createQuery("from departement d where d.nom = :lib",Departement.class);
		query.setParameter("lib", nom);
		Departement departement = (Departement) query.getSingleResult();
		em.close();
		return departement;
	}

	public static Departement findByNumero(String numero)
	{
		EntityManager em = Context.getInstance().getEmf().createEntityManager();
		Query query= em.createQuery("from Departement d where d.numero = :lib",Departement.class);
		query.setParameter("lib", numero);
		Departement departement = (Departement) query.getSingleResult();
		em.close();
		return departement;
	}

	public static List<Departement> findByRegion(Region region)
	{
		EntityManager em = Context.getInstance().getEmf().createEntityManager();
		Query query= em.createQuery("from Departement d where d.region = :lib",Departement.class);
		query.setParameter("lib", region.name());
		List<Departement> departements = query.getResultList();
		em.close();
		return departements;
	}

	/*public static List<Departement> findByLibelleLike(String libelle)
	{
		EntityManager em = Context.getInstance().getEmf().createEntityManager();
		Query query= em.createQuery("from departement d where d.nom like :lib ",Departement.class);
		query.setParameter("lib", "%"+libelle+"%");
		List<Departement> departements = query.getResultList();
		em.close();
		return departements;
	}*/

	@Override
	public Departement insert(Departement o) {
		EntityManager em = Context.getInstance().getEmf().createEntityManager();
		em.getTransaction().begin();
		em.persist(o);
		em.getTransaction().commit();
		em.close();
		return o;
	}

	@Override
	public Departement update(Departement o) {
		EntityManager em = Context.getInstance().getEmf().createEntityManager();
		em.getTransaction().begin();
		Departement managed=em.merge(o);
		em.getTransaction().commit();
		em.close();
		return managed;
	}

	@Override
	public void delete(Integer id) {
		EntityManager em = Context.getInstance().getEmf().createEntityManager();
		Departement d = em.find(Departement.class,id);
		em.getTransaction().begin();
		em.remove(d);
		em.getTransaction().commit();
		em.close();
	}

	@Override
	public List<Departement> findByNomLike(String nom) {
		EntityManager em = Context.getInstance().getEmf().createEntityManager();
		Query query= em.createQuery("from Departement d where d.nom like :lib ",Departement.class);
		query.setParameter("lib", "%"+nom+"%");
		List<Departement> departements = query.getResultList();
		em.close();
		return departements;
	}

	@Override
	public List<Departement> filterDepartement(String mot) {
		EntityManager em = Context.getInstance().getEmf().createEntityManager();
		Query query= em.createQuery("from Departement d where d.nom like :lib or d.numero like :lib or d.region like :lib",Departement.class);
		query.setParameter("lib", "%"+mot+"%");
		List<Departement> departements = query.getResultList();
		em.close();
		return departements;
	}

}
