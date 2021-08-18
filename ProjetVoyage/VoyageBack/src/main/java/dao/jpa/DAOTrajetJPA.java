package dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import dao.IDAOTrajet;
import metier.Trajet;
import util.Context;

public class DAOTrajetJPA implements IDAOTrajet{

	@Override
	public Trajet findById(Integer id) {
		EntityManager em = Context.getInstance().getEmf().createEntityManager();
		Trajet t = em.find(Trajet.class,id);
		em.close();
		return t;
	}

	@Override
	public List<Trajet> findAll() {
		EntityManager em = Context.getInstance().getEmf().createEntityManager();
		List<Trajet> trajets = em.createQuery("from Trajet",Trajet.class).getResultList();
		em.close();
		return trajets;
	}

	@Override
	public Trajet insert(Trajet t) {
		EntityManager em = Context.getInstance().getEmf().createEntityManager();
		
		em.getTransaction().begin();
		em.persist(t);
		em.getTransaction().commit();
		em.close();
		return t;
	}

	@Override
	public Trajet update(Trajet t) {
		EntityManager em = Context.getInstance().getEmf().createEntityManager();
		em.getTransaction().begin();
		Trajet managed=em.merge(t);
		em.getTransaction().commit();
		em.close();
		return managed;
	}

	@Override
	public void delete(Integer id) {
		EntityManager em = Context.getInstance().getEmf().createEntityManager();
		Trajet r = em.find(Trajet.class,id);
		em.getTransaction().begin();
		em.remove(r);
		em.getTransaction().commit();
		em.close();
	}

	@Override
	public List<Trajet> filterTrajet(String mot) {
		EntityManager em = Context.getInstance().getEmf().createEntityManager();
		Query query= em.createNativeQuery("SELECT DISTINCT trajet.id, trajet.distance, trajet.id_depart, trajet.id_destination from trajet join ville on trajet.id_depart=ville.id or trajet.id_destination=ville.id where ville.nom like :lib",Trajet.class);
		query.setParameter("lib", "%"+mot+"%");
		List<Trajet> trajets = query.getResultList();
		em.close();
		return trajets;
	}

	

}
