package dao.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import dao.IDAO;
import dao.IDAOCompte;
import metier.Admin;
import metier.Client;
import metier.Compte;

public class DAOCompteJDBC implements IDAOCompte{

	@Override
	public Compte findById(Integer id) {
		return null;
	}

	@Override
	public List<Compte> findAll() {
		List<Compte> comptes=new ArrayList();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(urlBDD,loginBDD,passwordBDD);
 
			PreparedStatement ps = conn.prepareStatement("SELECT * from compte");
			
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) 
			{
				Compte c = null;
				if(rs.getString("type_compte").equals("admin")) 
				{
					 c = new Admin(rs.getInt("id"), rs.getString("login"),rs.getString("password"));
				}
				else if(rs.getString("type_compte").equals("client"))
				{
					 c = new Client(rs.getInt("id"), rs.getString("login"),rs.getString("password"));
				}
				comptes.add(c);
			}
			
			conn.close();
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		return comptes;
	}

	@Override
	public Compte insert(Compte c) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(urlBDD,loginBDD,passwordBDD);
			
			PreparedStatement ps = conn.prepareStatement("INSERT into compte (login,password,type_compte) VALUES (?,?,?)");

			ps.setString(1, c.getLogin());
			ps.setString(2, c.getPassword());
			ps.setString(3, c.getClass().getSimpleName());
			ps.executeUpdate();

			ps.close();
			conn.close();
		}
		catch(Exception e) {e.printStackTrace();}
		
		return c;
	}

	@Override
	public Compte update(Compte c) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(urlBDD,loginBDD,passwordBDD);
			
			PreparedStatement ps = conn.prepareStatement("UPDATE compte set login=?,password=?,type_compte=? where id=?");

			ps.setString(1, c.getLogin());
			ps.setString(2, c.getPassword());
			ps.setString(3, c.getClass().getSimpleName());
			ps.setInt(4,c.getId());
			ps.executeUpdate();

			ps.close();
			conn.close();
		}
		catch(Exception e) {e.printStackTrace();}
		
		return c;
	}

	@Override
	public void delete(Integer id) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(urlBDD,loginBDD,passwordBDD);
			
			PreparedStatement ps = conn.prepareStatement("DELETE from compte where id=?");

			ps.setInt(1,id);
			ps.executeUpdate();

			ps.close();
			conn.close();
		}
		catch(Exception e) {e.printStackTrace();}
	}
	
	public Compte seConnecter(String login,String password) 
	{
		Compte c=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(urlBDD,loginBDD,passwordBDD);
 
			PreparedStatement ps = conn.prepareStatement("SELECT * from compte where login=? and password=?");
			ps.setString(1, login);
			ps.setString(2, password);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) 
			{
				if(rs.getString("type_compte").equals("admin")) 
				{
					 c = new Admin(rs.getInt("id"), rs.getString("login"),rs.getString("password"));
				}
				else if(rs.getString("type_compte").equals("client"))
				{
					 c = new Client(rs.getInt("id"), rs.getString("login"),rs.getString("password"));
				}
			}
			
			conn.close();
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		return c;
	}

	public List<Compte> filterCompte(String mot) {
		List<Compte> comptes=new ArrayList();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(urlBDD,loginBDD,passwordBDD);
 
			PreparedStatement ps = conn.prepareStatement("SELECT * from compte where login like ? or password like ?");
			ps.setString(1, "%"+mot+"%");
			ps.setString(2, "%"+mot+"%");
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) 
			{
				Compte c = null;
				if(rs.getString("type_compte").equals("admin")) 
				{
					 c = new Admin(rs.getInt("id"), rs.getString("login"),rs.getString("password"));
				}
				else if(rs.getString("type_compte").equals("client"))
				{
					 c = new Client(rs.getInt("id"), rs.getString("login"),rs.getString("password"));
				}
				comptes.add(c);
			}
			
			conn.close();
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		return comptes;
	}

}
