package IDMultiple;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
public class Achat {
	
@EmbeddedId private AchatId id;
}
