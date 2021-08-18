package dao.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import dao.IDAOTransport;
import metier.Transport;

public class DAOTransportJDBC implements IDAOTransport {

	@Override
	public Transport findById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Transport> findAll() {
		List<Transport> transports=new ArrayList();
		try {

			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(urlBDD,loginBDD,passwordBDD);
			PreparedStatement ps = conn.prepareStatement("SELECT * from transport");

			ResultSet rs = ps.executeQuery();

			while(rs.next()) 
			{
				Transport t = new Transport(rs.getInt("id"), rs.getString("nom"), rs.getInt("vitesse"));
				transports.add(t);
			}

			rs.close();
			ps.close();
			conn.close();
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		return transports;
	}

	@Override
	public Transport insert(Transport o) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Transport update(Transport o) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Transport findByLibelle(String libelle) {
		Transport transport=null;
		try {

			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(urlBDD,loginBDD,passwordBDD);
			PreparedStatement ps = conn.prepareStatement("SELECT * from transport where nom=?");
			ps.setString(1, libelle);
			
			ResultSet rs = ps.executeQuery();

			while(rs.next()) 
			{
				 transport = new Transport(rs.getInt("id"), rs.getString("nom"), rs.getInt("vitesse"));

			}

			rs.close();
			ps.close();
			conn.close();
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		return transport;
	}

}
