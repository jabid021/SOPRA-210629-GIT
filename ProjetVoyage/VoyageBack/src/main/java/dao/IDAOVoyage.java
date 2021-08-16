package dao;

import java.util.List;

import metier.Compte;
import metier.Voyage;

public interface IDAOVoyage extends IDAO<Voyage,Integer> {
	public void addAchat(Voyage v, Compte client);
	public List<Voyage> filterVoyage(String mot);

}
