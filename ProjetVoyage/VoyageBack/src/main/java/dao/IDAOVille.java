package dao;

import java.util.List;

import metier.Ville;

public interface IDAOVille extends IDAO<Ville,Integer> {
	public List<Ville> filterVille(String mot);
}
