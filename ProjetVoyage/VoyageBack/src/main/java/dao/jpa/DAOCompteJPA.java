package dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import dao.IDAOCompte;
import metier.Compte;
import util.Context;

public class DAOCompteJPA implements IDAOCompte{

	@Override
	public Compte findById(Integer id) {
		EntityManager em = Context.getInstance().getEmf().createEntityManager();
		Compte c = em.find(Compte.class,id);
		em.close();
		return c;
	}

	@Override
	public List<Compte> findAll() {
		EntityManager em = Context.getInstance().getEmf().createEntityManager();
		List<Compte> comptes = em.createQuery("from Compte",Compte.class).getResultList();
		em.close();
		return comptes;
	}

	@Override
	public Compte insert(Compte c) {
		EntityManager em = Context.getInstance().getEmf().createEntityManager();

		em.getTransaction().begin();
		em.persist(c);
		em.getTransaction().commit();
		em.close();
		return c;
	}

	@Override
	public Compte update(Compte c) {
		EntityManager em = Context.getInstance().getEmf().createEntityManager();
		em.getTransaction().begin();
		c=em.merge(c);
		em.getTransaction().commit();
		em.close();
		return c;
	}

	@Override
	public void delete(Integer id) {
		EntityManager em = Context.getInstance().getEmf().createEntityManager();
		Compte c = em.find(Compte.class,id);
		em.getTransaction().begin();
		em.remove(c);
		em.getTransaction().commit();
		em.close();
	}

	@Override
	public List<Compte> filterCompte(String mot) {
		EntityManager em = Context.getInstance().getEmf().createEntityManager();
		Query query= em.createQuery("from Compte c where c.login like :lib or c.password like :lib",Compte.class);
		query.setParameter("lib", "%"+mot+"%");
		List<Compte> comptes = query.getResultList();
		em.close();
		return comptes;
	}

	@Override
	public Compte seConnecter(String login, String password) {
		Compte c = null;
		try{
			EntityManager em = Context.getInstance().getEmf().createEntityManager();
			Query query= em.createQuery("from Compte c where c.login = :login and c.password=:password",Compte.class);
			query.setParameter("login", login);
			query.setParameter("password", password);
			c = (Compte) query.getSingleResult();
			em.close();
		}
		catch(Exception e) {}
		return c;
	}

}
