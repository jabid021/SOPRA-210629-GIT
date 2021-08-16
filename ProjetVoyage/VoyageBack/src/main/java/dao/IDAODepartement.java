package dao;

import java.util.List;

import metier.Departement;

public interface IDAODepartement extends IDAO<Departement,Integer> {
	public Departement findByNomLike(String nom);
	public List<Departement> filterDepartement(String mot);
}
