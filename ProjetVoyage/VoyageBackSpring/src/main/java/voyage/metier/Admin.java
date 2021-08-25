package voyage.metier;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("admin")
public class Admin extends Compte{

	public Admin() {super();}
	public Admin(String login, String password) {
		super(login, password);
	}

	public Admin(int id,String login, String password) {
		super(id,login, password);
	}
	@Override
	public String toString() {
		return "Admin [id=" + id + ", login=" + login + ", password=" + password + "]";
	}

	

	
	
}
