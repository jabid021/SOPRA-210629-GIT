package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import metier.Trajet;
import metier.Ville;

public class DAOTrajet implements IDAO<Trajet,Integer>{

	@Override
	public Trajet findById(Integer id) {
		DAOVille daoVille = new DAOVille();
		Trajet trajet=null;
		try {

			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(urlBDD,loginBDD,passwordBDD);
			PreparedStatement ps = conn.prepareStatement("SELECT * from trajet where id=?");
			ps.setInt(1, id);

			ResultSet rs = ps.executeQuery();

			while(rs.next()) 
			{
				Ville depart = daoVille.findById(rs.getInt("id_depart"));
				Ville destination = daoVille.findById(rs.getInt("id_destination"));
				trajet = new Trajet(rs.getInt("id"),depart,destination,rs.getDouble("distance"));
			}

			rs.close();
			ps.close();
			conn.close();
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		return trajet;
	}

	@Override
	public List<Trajet> findAll() {
		DAOVille daoVille = new DAOVille();
		List<Trajet> trajets=new ArrayList();
		try {

			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(urlBDD,loginBDD,passwordBDD);
			PreparedStatement ps = conn.prepareStatement("SELECT * from trajet");

			ResultSet rs = ps.executeQuery();

			while(rs.next()) 
			{
				Ville depart = daoVille.findById(rs.getInt("id_depart"));
				Ville destination = daoVille.findById(rs.getInt("id_destination"));
				Trajet v = new Trajet(rs.getInt("id"),depart,destination,rs.getDouble("distance"));
				trajets.add(v);
			}

			rs.close();
			ps.close();
			conn.close();
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		return trajets;
	}

	@Override
	public Trajet insert(Trajet t) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(urlBDD,loginBDD,passwordBDD);
			PreparedStatement ps = conn.prepareStatement("INSERT into trajet (distance,id_depart,id_destination) VALUES (?,?,?)");

			ps.setDouble(1, t.getDistance());
			ps.setInt(2, t.getDepart().getId());
			ps.setInt(3, t.getDestination().getId());
			ps.executeUpdate();

			ps.close();
			conn.close();
		}
		catch(Exception e) {e.printStackTrace();}
		return t;
	}

	@Override
	public Trajet update(Trajet o) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		
	}

}
