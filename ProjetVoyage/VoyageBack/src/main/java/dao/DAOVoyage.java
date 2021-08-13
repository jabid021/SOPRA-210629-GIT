package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import metier.Compte;
import metier.Trajet;
import metier.Transport;
import metier.Voyage;

public class DAOVoyage  implements IDAO<Voyage,Integer> {

	@Override
	public Voyage findById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Voyage> findAll() {
		DAOTrajet daoTrajet = new DAOTrajet();
		List<Voyage> voyages=new ArrayList();
		try {

			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(urlBDD,loginBDD,passwordBDD);

			PreparedStatement ps = conn.prepareStatement("SELECT * from voyage join transport on voyage.id_transport=transport.id");

			ResultSet rs = ps.executeQuery();

			while(rs.next()) 
			{
				
				Trajet t = daoTrajet.findById(rs.getInt("id_trajet"));
				Voyage v = new Voyage(rs.getInt("id"), t, Transport.valueOf(rs.getString("transport.nom")), rs.getInt("duree"));
				voyages.add(v);
			}

			rs.close();
			ps.close();
			conn.close();
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		return voyages;
	}

	@Override
	public Voyage insert(Voyage v) {
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(urlBDD,loginBDD,passwordBDD);
			PreparedStatement ps = conn.prepareStatement("INSERT into voyage (id_trajet,id_transport,duree) VALUES (?,?,?)");

			ps.setInt(1, v.getTrajet().getId());
			ps.setInt(2, v.getTransport().getId());
			ps.setInt(3, v.getDuree());
			ps.executeUpdate();

			ps.close();
			conn.close();
		}
		catch(Exception e) {e.printStackTrace();}
		return v;
	}

	@Override
	public Voyage update(Voyage o) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		
	}
	
	public void addAchat(Voyage v, Compte client) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(urlBDD,loginBDD,passwordBDD);
			PreparedStatement ps = conn.prepareStatement("INSERT into achat (id_voyage,id_client) VALUES (?,?)");

			ps.setInt(1, v.getId());
			ps.setInt(2, client.getId());
			ps.executeUpdate();

			ps.close();
			conn.close();
		}
		catch(Exception e) {e.printStackTrace();}
	}

}
