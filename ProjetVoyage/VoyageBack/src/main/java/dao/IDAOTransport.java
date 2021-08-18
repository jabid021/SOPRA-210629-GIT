package dao;

import metier.Transport;

public interface IDAOTransport extends IDAO<Transport,Integer> {
	public Transport findByLibelle(String libelle);
	

}
