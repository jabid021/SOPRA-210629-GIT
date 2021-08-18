package dao.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import dao.IDAODepartement;
import metier.Departement;
import metier.Region;

public class DAODepartementJDBC implements IDAODepartement {

	@Override
	public Departement findById(Integer id) {
		Departement d=null;
		try {

			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(urlBDD,loginBDD,passwordBDD);

			PreparedStatement ps = conn.prepareStatement("SELECT * from departement where id=?");
			ps.setInt(1, id);

			ResultSet rs = ps.executeQuery();

			while(rs.next()) 
			{
				 d = new Departement(rs.getInt("id"),rs.getString("nom"),rs.getString("numero"),Region.valueOf(rs.getString("region")));
			}

			rs.close();
			ps.close();
			conn.close();
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		return d;
	}

	@Override
	public List<Departement> findAll() {
		List<Departement> departements=new ArrayList();
		try {

			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(urlBDD,loginBDD,passwordBDD);

			PreparedStatement ps = conn.prepareStatement("SELECT * from departement");

			ResultSet rs = ps.executeQuery();

			while(rs.next()) 
			{
				Departement d = new Departement(rs.getInt("id"),rs.getString("nom"),rs.getString("numero"),Region.valueOf(rs.getString("region")));
				departements.add(d);
			}

			rs.close();
			ps.close();
			conn.close();
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		return departements;
	}

	@Override
	public Departement insert(Departement d) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(urlBDD,loginBDD,passwordBDD);
			
			PreparedStatement ps = conn.prepareStatement("INSERT into departement (nom,numero,region) VALUES (?,?,?)");

			ps.setString(1, d.getNom());
			ps.setString(2, d.getNumero());
			ps.setString(3, d.getRegion().toString());
			ps.executeUpdate();

			ps.close();
			conn.close();
		}
		catch(Exception e) {e.printStackTrace();}
		
		//Y ajouter l'id ?
		return d;
	}

	@Override
	public Departement update(Departement d) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(urlBDD,loginBDD,passwordBDD);

			PreparedStatement ps = conn.prepareStatement("UPDATE departement set nom=?,numero=?,region=? where id=?");

			ps.setString(1, d.getNom());
			ps.setString(2, d.getNumero());
			ps.setString(3, d.getRegion().toString());
			ps.setInt(4, d.getId());
			ps.executeUpdate();

			ps.close();
			conn.close();
		}
		catch(Exception e) {e.printStackTrace();}
		return d;
	}

	@Override
	public void delete(Integer id) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(urlBDD,loginBDD,passwordBDD);

			PreparedStatement ps = conn.prepareStatement("DELETE from departement where id=?");
			ps.setInt(1, id);
			ps.executeUpdate();

			ps.close();
			conn.close();
		}
		catch(Exception e) {e.printStackTrace();}
	}
	
	public List<Departement> findByNomLike(String nom) 
	{
		Departement d=null;
		List<Departement> departements = new ArrayList<>();
		try {

			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(urlBDD,loginBDD,passwordBDD);

			PreparedStatement ps = conn.prepareStatement("SELECT * from departement where nom like ?");
			ps.setString(1, "%"+nom+"%");

			ResultSet rs = ps.executeQuery();

			while(rs.next()) 
			{
				 d = new Departement(rs.getInt("id"),rs.getString("nom"),rs.getString("numero"),Region.valueOf(rs.getString("region")));
				 departements.add(d);
			}

			rs.close();
			ps.close();
			conn.close();
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		return departements;
	}

	public List<Departement> filterDepartement(String mot) {
		List<Departement> departements=new ArrayList();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(urlBDD,loginBDD,passwordBDD);
 
			PreparedStatement ps = conn.prepareStatement("SELECT * from departement where nom like ? or numero like ? or region like ?");
			ps.setString(1, "%"+mot+"%");
			ps.setString(2, "%"+mot+"%");
			ps.setString(3, "%"+mot+"%");
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) 
			{
				String nomRegion=rs.getString("region");
				Region region=Region.valueOf(nomRegion);
				Departement d = new Departement(rs.getInt("id"), rs.getString("nom"),rs.getString("numero"),region);
				departements.add(d);
			}
			
			conn.close();
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		return departements;
	}
	
}
