package test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import dao.jdbc.DAOCompteJDBC;
import dao.jdbc.DAODepartementJDBC;
import dao.jdbc.DAOTrajetJDBC;
import dao.jdbc.DAOVilleJDBC;
import dao.jdbc.DAOVoyageJDBC;
import metier.Admin;
import metier.Client;
import metier.Compte;
import metier.Departement;
import metier.OldTransport;
import metier.Region;
import metier.Trajet;
import metier.Transport;
import metier.Ville;
import metier.Voyage;
import util.Context;

public class App {

	static Compte connected=null;
	static List<Voyage> panier = new ArrayList();
	static DAODepartementJDBC daoD = new DAODepartementJDBC();
	static DAOCompteJDBC daoC = new DAOCompteJDBC();
	static DAOTrajetJDBC daoT = new DAOTrajetJDBC();
	static DAOVilleJDBC daoVi = new DAOVilleJDBC();
	static DAOVoyageJDBC daoVo = new DAOVoyageJDBC();


	public static int saisieInt(String msg) 
	{
		Scanner sc = new Scanner(System.in);
		System.out.println(msg);
		return sc.nextInt();

	}
	public static double saisieDouble(String msg) 
	{
		Scanner sc = new Scanner(System.in);
		System.out.println(msg);
		return sc.nextDouble();
	}
	public static String saisieString(String msg) 
	{
		Scanner sc = new Scanner(System.in);
		System.out.println(msg);
		return sc.nextLine();
	}

	public static void main(String[] args) {
	
		Context.getInstance().getEmf();
		Context.getInstance().closeEmf();
		menuPrincipal();
	}

	public static void menuPrincipal() {

		System.out.println("\nAppli Voyage");
		System.out.println("1- Se connecter");
		System.out.println("2- Fermer l'appli");
		int choix = saisieInt("Choisir un menu");
		switch(choix) 
		{
		case 1 : seConnecter();break;
		case 2 : System.exit(0);break;
		}
		menuPrincipal();

	}
	public static void seConnecter() {
		String login = saisieString("\nSaisir login");
		String password = saisieString("Saisir password");
		connected=daoC.seConnecter(login, password);

		if(connected instanceof Admin) 
		{
			menuAdmin();
		}
		else if(connected instanceof Client) 
		{
			menuClient();
		}
		else {
			System.out.println("Identifiants invalides !");
		}

	}

	public static void menuClient() {
		System.out.println("\nMenu Client");
		System.out.println("1- Afficher les voyages");
		System.out.println("2- Ajouter un voyage dans le panier");
		System.out.println("3- Sauvegarder le panier");
		System.out.println("4- Charger le panier");
		System.out.println("5- Consulter mon panier");
		System.out.println("6- Acheter un voyage");
		System.out.println("7- Se deconnecter");
		int choix = saisieInt("Choisir un menu");

		switch(choix) 
		{
		case 1 : showVoyages();break;
		case 2 : addPanier();break;
		case 3 : savePanier();break;
		case 4 : loadPanier();break;
		case 5 : consulterPanier();break;
		case 6 : achatVoyage();break;
		case 7 : connected=null;menuPrincipal();break;
		}
		menuClient();


	}

	public static void consulterPanier() {
		System.out.println("Voici votre panier : ");
		System.out.println(panier);

	}
	public static void achatVoyage() {

		for(Voyage v : panier) 
		{
			daoVo.addAchat(v,connected);
		}

	}

	public static void loadPanier() {

		File monFichier = new File("panier.txt");		
		try(FileInputStream fis = new FileInputStream(monFichier);
				ObjectInputStream ois = new ObjectInputStream(fis);) 
		{
			panier= (List<Voyage>) ois.readObject();
		}
		catch(Exception e) 
		{
			e.printStackTrace();
		}
	}
	public static void savePanier() {

		File monFichier = new File("panier.txt");		

		try(FileOutputStream fos = new FileOutputStream(monFichier);
				ObjectOutputStream oos = new ObjectOutputStream(fos);) 
		{
			oos.writeObject(panier);
		}
		catch(Exception e) 
		{
			e.printStackTrace();
		}
	}
	public static void addPanier() {
		showVoyages();
		int id = saisieInt("Saisir l'id du voyage");
		Voyage v = new Voyage(id);
		panier.add(v);	
	}

	public static void menuAdmin() {
		System.out.println("\nMenu Admin");
		System.out.println("1- Ajouter un département");
		System.out.println("2- Ajouter une Ville");
		System.out.println("3- Ajouter un Trajet");
		System.out.println("4- Ajouter un Voyage");
		System.out.println("5- Lister les voyages");
		System.out.println("6- Se deconnecter");

		int choix = saisieInt("Choisir un menu");

		switch(choix) 
		{
		case 1 : addDepartement();break;
		case 2: addVille();break;
		case 3 : addTrajet();break;
		case 4 : addVoyage();break;
		case 5 : showVoyages();break;
		case 6 : connected=null;menuPrincipal();break;
		}

		menuAdmin();

	}
	public static void showVoyages() {
		List<Voyage> voyages = daoVo.findAll();
		System.out.println(voyages);	
	}

	public static void addVoyage() {

		int duree = saisieInt("Saisir la duree du voyage");
		System.out.println(Arrays.toString(OldTransport.values()));
		String choixTransport=saisieString("Choix du transport");
		System.out.println(daoT.findAll());
		int id = saisieInt("Saisir l'id du trajet");

		Trajet t = new Trajet(id);
		Transport transport = new Transport(1,"Avion",500);
		Voyage v = new Voyage(t,transport,duree);

		daoVo.insert(v);

	}


	public static void addTrajet() {

		System.out.println(daoVi.findAll());
		int id1 = saisieInt("Choisir l'id de la ville de départ");
		Ville depart = new Ville(id1);
		int id2 = saisieInt("Choisir l'id de la ville de destination");
		Ville destination = new Ville(id2);
		double distance = saisieDouble("Saisir la distance pour ce trajet");

		Trajet t = new Trajet(depart,destination,distance);

		daoT.insert(t);

	}


	public static void addVille() {

		String nom = saisieString("Saisir le nom de la ville");
		String carac = saisieString("Saisir caracs");
		
		List<Departement> depts = daoD.findAll();
		
		for(Departement d : depts) 
		{
			System.out.println(d.getNom()+"("+d.getId()+")");
		}
		
		int idDepartement = saisieInt("Saisir l'id d'un departement");
		Departement d = new Departement(idDepartement);
		Ville v = new Ville(nom, carac, d);
		daoVi.insert(v);	
	}


	public static void addDepartement() {

		String nom = saisieString("Nom du Département");
		String numero = saisieString("Saisir le numero");

		System.out.println(Arrays.toString(Region.values()));
		String choixRegion= saisieString("Choisir une région");
		try {
			Departement d = new Departement(nom, numero, Region.valueOf(choixRegion));
			daoD.insert(d);
			
		}
		catch(Exception e) 
		{
			System.out.println("Cette région n'existe pas, ajout impossible");
		}
	}

}
