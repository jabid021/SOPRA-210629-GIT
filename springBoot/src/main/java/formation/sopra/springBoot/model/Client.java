package formation.sopra.springBoot.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.Past;

import org.springframework.format.annotation.DateTimeFormat;

import formation.sopra.springBoot.validators.Majeur;

@Entity
public class Client extends Personne {

	private int age;
	@Column(name = "date_naissance")
	@Past
	@Majeur
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate dateNaissance;

	@OneToMany(mappedBy = "client")
	private List<Achat> achats;

	@OneToOne
	@JoinColumn(name = "id_login", foreignKey = @ForeignKey(name = "client_id_login_fk"))
	private Login login;

	public Client() {
		super();
	}

	public Client(String nom, String prenom, int age, LocalDate naissance) {
		super(nom, prenom);
		this.age = age;
		this.dateNaissance = naissance;
	}

	public int getAge() {
		return age;
	}

	public List<Achat> getAchats() {
		return achats;
	}

	public void setAchats(List<Achat> achats) {
		this.achats = achats;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public LocalDate getDateNaissance() {
		return dateNaissance;
	}

	public void setDateNaissance(LocalDate dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	@Override
	public String toString() {
		return "Client [age=" + age + ", dateNaissance=" + dateNaissance + "]";
	}

}
