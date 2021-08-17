package model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Client extends Personne{

	private int age;
	@Column(name="date_naissance")
	private LocalDate dateNaissance;
	
	@ManyToMany
	@JoinTable(
			name="achat",
			joinColumns = @JoinColumn(name="client"),
			inverseJoinColumns = @JoinColumn(name="produit")
		)
	private List<Produit> produits=new ArrayList();
	
	public Client() {
		super();
	}

	public Client(String nom, String prenom,int age,LocalDate naissance) {
		super(nom, prenom);
		this.age=age;
		this.dateNaissance=naissance;
	}

	public int getAge() {
		return age;
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
		return "Client [age=" + age + ", dateNaissance=" + dateNaissance + ", produits=" + produits + "]";
	}

	
	
	
	
	
	
	
}
