package dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import dao.IDAOVille;
import metier.Ville;
import util.Context;

public class DAOVilleJPA implements IDAOVille{

	@Override
	public Ville findById(Integer id) {
		EntityManager em = Context.getInstance().getEmf().createEntityManager();
		Ville v = em.find(Ville.class,id);
		em.close();
		return v;
	}

	@Override
	public List<Ville> findAll() {
		EntityManager em = Context.getInstance().getEmf().createEntityManager();
		List<Ville> villes = em.createQuery("from Ville",Ville.class).getResultList();
		em.close();
		return villes;
	}

	@Override
	public Ville insert(Ville v) {
		EntityManager em = Context.getInstance().getEmf().createEntityManager();
		em.getTransaction().begin();
		em.persist(v);
		em.getTransaction().commit();
		em.close();
		return v;
	}

	@Override
	public Ville update(Ville o) {
		EntityManager em = Context.getInstance().getEmf().createEntityManager();
		em.getTransaction().begin();
		Ville v=em.merge(o);
		em.getTransaction().commit();
		em.close();
		return v;
	}

	@Override
	public void delete(Integer id) {
		EntityManager em = Context.getInstance().getEmf().createEntityManager();
		Ville v = em.find(Ville.class,id);
		em.getTransaction().begin();
		em.remove(v);
		em.getTransaction().commit();
		em.close();		
	}

	@Override
	public List<Ville> filterVille(String mot) {
		List<Ville> villes = null;
		try {
			EntityManager em = Context.getInstance().getEmf().createEntityManager();
			Query query= em.createQuery("from Ville v where v.nom like :lib",Ville.class);
			query.setParameter("lib", "%"+mot+"%");
			villes = query.getResultList();
			em.close();
		}
		catch(Exception e) {}
		return villes;
	}

}
