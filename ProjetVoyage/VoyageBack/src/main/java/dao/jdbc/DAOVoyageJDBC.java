package dao.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import dao.IDAOVoyage;
import metier.Compte;
import metier.Trajet;
import metier.Transport;
import metier.Voyage;

public class DAOVoyageJDBC  implements IDAOVoyage {

	@Override
	public Voyage findById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Voyage> findAll() {
		DAOTrajetJDBC daoTrajet = new DAOTrajetJDBC();
		List<Voyage> voyages=new ArrayList();
		try {

			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(urlBDD,loginBDD,passwordBDD);

			PreparedStatement ps = conn.prepareStatement("SELECT * from voyage join transport on voyage.id_transport=transport.id");

			ResultSet rs = ps.executeQuery();

			while(rs.next()) 
			{
				
				Trajet t = daoTrajet.findById(rs.getInt("id_trajet"));
				Transport transport = new Transport(rs.getInt("transport.id"),rs.getString("transport.nom"),rs.getInt("transport.vitesse"));
				Voyage v = new Voyage(rs.getInt("id"), t,transport, rs.getInt("duree"));
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

	public void delete(Integer id) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection(urlBDD,loginBDD,passwordBDD);

            PreparedStatement ps = conn.prepareStatement("DELETE from voyage where id=?");
            ps.setInt(1, id);
            ps.executeUpdate();

            ps.close();
            conn.close();
        }
        catch(Exception e) {e.printStackTrace();}
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
	public List<Voyage> filterVoyage(String mot) {
        List<Voyage> voyages=new ArrayList();
        DAOTrajetJDBC daoTrajet = new DAOTrajetJDBC();

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection(urlBDD,loginBDD,passwordBDD);
 
            PreparedStatement ps = conn.prepareStatement("SELECT * from voyage join transport on voyage.id_transport=transport.id join trajet on voyage.id_trajet=trajet.id join ville dep on trajet.id_depart=dep.id join ville dest on trajet.id_destination=dest.id where dep.nom like ? or dest.nom like ? or transport.nom like ?");
            ps.setString(1, "%"+mot+"%");
            ps.setString(2, "%"+mot+"%");
            ps.setString(3, "%"+mot+"%");
            ResultSet rs = ps.executeQuery();

            while(rs.next()) 
            {

                Trajet t = daoTrajet.findById(rs.getInt("id_trajet"));
                Transport transport = new Transport(rs.getInt("transport.id"),rs.getString("transport.nom"),rs.getInt("transport.vitesse"));
				Voyage v = new Voyage(rs.getInt("id"), t,transport, rs.getInt("duree"));
				voyages.add(v);
            }

            conn.close();
        } 
        catch (Exception e) {
            e.printStackTrace();
        }
        return voyages;
    }

}
