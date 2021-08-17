package model.joined;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(name = "id_ordi")
public class Linux extends Ordinateur {

	private String distrib;
	
	public Linux() {
		super();
	}
	
	public Linux(String marque,String distrib) {
		super(marque);
		this.distrib=distrib;
	}

	public String getDistrib() {
		return distrib;
	}

	public void setDistrib(String distrib) {
		this.distrib = distrib;
	}

	@Override
	public String toString() {
		return "Linux [distrib=" + distrib + ", id=" + id + ", marque=" + marque + "]";
	}
	
	
	
}
