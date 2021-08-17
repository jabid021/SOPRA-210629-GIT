package model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Client extends Personne{

	protected int age;
	@Column(name="date_naissance")
	protected LocalDate dateNaissance;
	
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
		return "Client [age=" + age + ", dateNaissance=" + dateNaissance + ", id=" + id + ", nom=" + nom + ", prenom="
				+ prenom + "]";
	}
	
	
	
	
	
	
	
}
