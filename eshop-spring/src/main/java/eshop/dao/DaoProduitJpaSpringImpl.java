package eshop.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import eshop.model.Produit;

@Repository
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class DaoProduitJpaSpringImpl implements DaoProduit {

	@PersistenceContext
	private EntityManager em;

	@Override
	public Produit findById(Integer id) {
		return em.find(Produit.class, id);
	}

	@Override
	public List<Produit> findAll() {
		return em.createQuery("from Produit p", Produit.class).getResultList();
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void insert(Produit o) {
		em.persist(o);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public Produit update(Produit o) {
		return em.merge(o);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void deleteByKey(Integer id) {
		delete(findById(id));
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void delete(Produit o) {
		em.remove(em.merge(o));
	}

}
