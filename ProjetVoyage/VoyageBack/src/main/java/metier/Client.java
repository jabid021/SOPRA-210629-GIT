package metier;

import java.util.ArrayList;
import java.util.List;

public class Client extends Compte {

	
	private List<Voyage> achats = new ArrayList();
	
	public Client() {}
	
	
	public Client(String login, String password) {
		super(login, password);
	}
	
	public Client(int id,String login, String password) {
		super(id,login, password);
	}
	

	public List<Voyage> getVoyages() {
		return achats;
	}


	public void setVoyages(List<Voyage> achats) {
		this.achats = achats;
	}


	@Override
	public String toString() {
		return "Client [achats=" + achats + ", id=" + id + ", login=" + login + ", password=" + password + "]";
	}



	
	
	
	
	
}
