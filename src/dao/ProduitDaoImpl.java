package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import connection.SingletonConnection;
import metier.entities.Produit;

public class ProduitDaoImpl implements IProduitDAO {

	@Override
	public Produit save(Produit p) {
	Connection connection = SingletonConnection.getConnection();
	try {
		PreparedStatement ps = connection.prepareStatement("INSERT INTO PRODUITS (DESIGNATION,PRIX,QUANTITE) VALUES (?,?,?)");
		ps.setString(1,p.getDesignation() );
		ps.setDouble(2, p.getPrix());
		ps.setInt(3, p.getQuantite());
		ps.executeUpdate();
		PreparedStatement ps2 = connection.prepareStatement("SELECT MAX(ID) as MAXID FROM PRODUITS");
		ResultSet rs = ps2.executeQuery();
		if(rs.next()) {
			p.setId(rs.getLong("MAXID"));
		}
		ps.close();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return p;
	}

	@Override
	public List<Produit> findAllByKeyword(String keyword) {
		List<Produit> produits = new ArrayList<Produit>();
		Connection connection = SingletonConnection.getConnection();
		try {
			PreparedStatement ps = connection.prepareStatement("SELECT * FROM PRODUITS WHERE DESIGNATION LIKE ?");
			ps.setString(1, keyword);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				produits.add(new Produit(rs.getLong("ID"),rs.getString("DESIGNATION"),rs.getDouble("PRIX"),rs.getInt("QUANTITE")));
				
				
				
			}
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return produits;
	}

	@Override
	public void delete(Long id) {
		Connection connection = SingletonConnection.getConnection();
		try {
			PreparedStatement ps = connection.prepareStatement("DELETE FROM PRODUITS WHERE ID = ?");
			ps.setLong(1, id);
			ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	@Override
	public Produit findOne(Long id) {
		Produit p = null;
		Connection connection = SingletonConnection.getConnection();
		try {
			PreparedStatement ps = connection.prepareStatement("SELECT * FROM PRODUITS WHERE ID = ?");
			ps.setLong(1, id);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				p = new Produit(rs.getLong("ID"),rs.getString("DESIGNATION")  ,rs.getDouble("PRIX")   ,rs.getInt("QUANTITE"));
				
			}
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return p;
	}

	@Override
	public Produit update(Produit p) {
		Connection connection=SingletonConnection.getConnection();
		try {
			PreparedStatement ps = connection.prepareStatement("UPDATE PRODUITS SET DESIGNATION=? , PRIX=?  , QUANTITE=? WHERE ID=?");
			ps.setString(1, p.getDesignation());
			ps.setDouble(2, p.getPrix());
			ps.setInt(3, p.getQuantite());
			ps.setLong(4, p.getId());
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return p;
		
		
	}

}
