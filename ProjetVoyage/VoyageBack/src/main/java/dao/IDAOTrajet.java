package dao;

import java.util.List;

import metier.Trajet;

public interface IDAOTrajet extends IDAO<Trajet,Integer> {
	public List<Trajet> filterTrajet(String mot);
}
