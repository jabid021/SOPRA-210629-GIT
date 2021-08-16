package dao;

import java.util.List;

import metier.Compte;

public interface IDAOCompte extends IDAO<Compte,Integer> {
	
	public List<Compte> filterCompte(String mot);
	public Compte seConnecter(String login,String password);

}
