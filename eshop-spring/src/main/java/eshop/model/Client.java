package eshop.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import eshop.validators.Majeur;

@Entity
public class Client extends Personne {

	private int age;
	@Column(name = "date_naissance")
	@Majeur
	private LocalDate dateNaissance;

	@OneToMany(mappedBy = "client")
	private List<Achat> achats;

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
