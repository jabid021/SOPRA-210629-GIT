package util;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import dao.IDAOCompte;
import dao.IDAODepartement;
import dao.IDAOTrajet;
import dao.IDAOTransport;
import dao.IDAOVille;
import dao.IDAOVoyage;
import dao.jdbc.*;
import dao.jpa.*;
import metier.Compte;
import metier.Voyage;

//Ma classe singleton
public class Context {

	private Compte connected=null;
	private List<Voyage> panier = new ArrayList();
	private IDAODepartement daoD = new DAODepartementJPA();
	private IDAOTrajet daoT = new DAOTrajetJPA();
	private IDAOCompte daoC = new DAOCompteJPA();
	private IDAOVille daoVi = new DAOVilleJPA();
	private IDAOVoyage daoVo = new DAOVoyageJPA();
	private IDAOTransport daoTransport = new DAOTransportJDBC();

	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("voyage-persistence");

	//Represente l'objet singleton
	private static Context _instance=null;



	private Context() {}



	public static Context getInstance() 
	{
		if(_instance==null) {
			_instance=new Context();
		}
		return _instance;
	}

	public Compte getConnected() {
		return connected;
	}

	public void setConnected(Compte connected) {
		this.connected = connected;
	}

	public List<Voyage> getPanier() {
		return panier;
	}

	public void setPanier(List<Voyage> panier) {
		this.panier = panier;
	}

	public IDAODepartement getDaoD() {
		return daoD;
	}

	public IDAOCompte getDaoC() {
		return daoC;
	}

	public IDAOTrajet getDaoT() {
		return daoT;
	}

	public IDAOVille getDaoVi() {
		return daoVi;
	}

	public IDAOVoyage getDaoVo() {
		return daoVo;
	}

	public IDAOTransport getDaoTransport() {
		return daoTransport;
	}



	public void setDaoTransport(IDAOTransport daoTransport) {
		this.daoTransport = daoTransport;
	}



	public EntityManagerFactory getEmf() {
		return emf;
	}


	public void closeEmf() 
	{
		emf.close();
	}

}
