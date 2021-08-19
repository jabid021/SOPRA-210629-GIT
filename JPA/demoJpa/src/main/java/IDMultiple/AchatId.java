package IDMultiple;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.GeneratedValue;

@Embeddable
public class AchatId implements Serializable {

	private int idClient;
	private int idVoyage;
	
	
	
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idClient;
		result = prime * result + idVoyage;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AchatId other = (AchatId) obj;
		if (idClient != other.idClient)
			return false;
		if (idVoyage != other.idVoyage)
			return false;
		return true;
	}
	
	
	
	
	
}
