package dao.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import dao.IDAOVille;
import metier.Departement;
import metier.Region;
import metier.Ville;

public class DAOVilleJDBC  implements IDAOVille {

	@Override
	public Ville findById(Integer id) {
		Ville v=null;
		try {

			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(urlBDD,loginBDD,passwordBDD);
			PreparedStatement ps = conn.prepareStatement("SELECT * from ville join departement on ville.id_departement=departement.id where ville.id=?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();

			while(rs.next()) 
			{
				Departement d = new Departement(rs.getInt("departement.id"),rs.getString("departement.nom"),rs.getString("departement.numero"),Region.valueOf(rs.getString("region")));
				v = new Ville(rs.getInt("ville.id"),rs.getString("ville.nom"),rs.getString("carac"),d);
			}

			rs.close();
			ps.close();
			conn.close();
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		return v;
	}

	@Override
	public List<Ville> findAll() {
		List<Ville> villes=new ArrayList();
		try {

			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(urlBDD,loginBDD,passwordBDD);
			PreparedStatement ps = conn.prepareStatement("SELECT * from ville join departement on ville.id_departement=departement.id");

			ResultSet rs = ps.executeQuery();

			while(rs.next()) 
			{
				Departement d = new Departement(rs.getInt("departement.id"),rs.getString("departement.nom"),rs.getString("departement.numero"),Region.valueOf(rs.getString("region")));
				Ville v = new Ville(rs.getInt("ville.id"),rs.getString("ville.nom"),rs.getString("carac"),d);
				villes.add(v);
			}

			rs.close();
			ps.close();
			conn.close();
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		return villes;
	}

	@Override
	public Ville insert(Ville v) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(urlBDD,loginBDD,passwordBDD);
			PreparedStatement ps = conn.prepareStatement("INSERT into ville (nom,carac,id_departement) VALUES (?,?,?)");

			ps.setString(1, v.getNom());
			ps.setString(2, v.getCarac());
			ps.setInt(3, v.getDepartement().getId());
			ps.executeUpdate();
			ps.close();
			conn.close();
		}
		catch(Exception e) {e.printStackTrace();}
		return v;
	}

	@Override
	public Ville update(Ville v) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(urlBDD,loginBDD,passwordBDD);
			PreparedStatement ps = conn.prepareStatement("UPDATE ville set nom=?,carac=?,id_departement=? where id=?");

			ps.setString(1, v.getNom());
			ps.setString(2, v.getCarac());
			ps.setInt(3, v.getDepartement().getId());
			ps.setInt(4, v.getId());
			ps.executeUpdate();

			ps.close();
			conn.close();
		}
		catch(Exception e) {e.printStackTrace();}
		return v;
	}

	@Override
	public void delete(Integer id) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(urlBDD,loginBDD,passwordBDD);
			PreparedStatement ps = conn.prepareStatement("DELETE from ville where id=?");

			ps.setInt(1, id);
			ps.executeUpdate();

			ps.close();
			conn.close();
		}
		catch(Exception e) {e.printStackTrace();}
	}
	

	public List<Ville> filterVille(String mot) {
		List<Ville> villes=new ArrayList();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(urlBDD,loginBDD,passwordBDD);
 
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM ville join departement on ville.id_departement=departement.id where ville.nom like ? OR departement.nom like ?");
			ps.setString(1, "%"+mot+"%");
			ps.setString(2, "%"+mot+"%");
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) 
			{
				Departement d = new Departement(rs.getInt("departement.id"),rs.getString("departement.nom"),rs.getString("departement.numero"),Region.valueOf(rs.getString("region")));
				Ville v = new Ville(rs.getInt("ville.id"),rs.getString("ville.nom"),rs.getString("carac"),d);
				villes.add(v);
			}
			
			conn.close();
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		return villes;
	}

}
