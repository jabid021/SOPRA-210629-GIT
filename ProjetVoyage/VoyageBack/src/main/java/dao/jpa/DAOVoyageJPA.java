package dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import dao.IDAOVoyage;
import metier.Compte;
import metier.Voyage;
import util.Context;

public class DAOVoyageJPA implements IDAOVoyage {

	@Override
	public Voyage findById(Integer id) {
		EntityManager em = Context.getInstance().getEmf().createEntityManager();
		Voyage v = em.find(Voyage.class,id);
		em.close();
		return v;

	}

	@Override
	public List<Voyage> findAll() {
		EntityManager em = Context.getInstance().getEmf().createEntityManager();
        List<Voyage> voyages = em.createQuery("from Voyage", Voyage.class).getResultList();
        em.close();
        return voyages;
	}

	@Override
	public Voyage insert(Voyage v) {
		 EntityManager em = Context.getInstance().getEmf().createEntityManager();

	        em.getTransaction().begin();
	        em.persist(v);
	        em.getTransaction().commit();
	        em.close();
	        return v;
	}

	@Override
	public Voyage update(Voyage v) {
		  EntityManager em = Context.getInstance().getEmf().createEntityManager();
	        em.getTransaction().begin();
	        v=em.merge(v);
	        em.getTransaction().commit();
	        em.close();
	        return v;
	}

	@Override
	public void delete(Integer id) {
		 EntityManager em = Context.getInstance().getEmf().createEntityManager();
	        Voyage v = em.find(Voyage.class,id);
	        em.getTransaction().begin();
	        em.remove(v);
	        em.getTransaction().commit();
	        em.close();
		
	}

	@Override
	public void addAchat(Voyage v, Compte client) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Voyage> filterVoyage(String mot) {
		EntityManager em = Context.getInstance().getEmf().createEntityManager();
        Query query= em.createQuery("from voyage v where v.trajet.depart.nom like :lib or v.trajet.destination.nom like :lib or v.transport.nom like :lib",Voyage.class);
        query.setParameter("lib", "%"+mot+"%");
        List<Voyage> voyages= query.getResultList();
        em.close();
        return voyages;
	}

}
