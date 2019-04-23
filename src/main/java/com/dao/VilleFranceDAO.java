package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.VilleFrance;
import com.config.DAOConnection;

public class VilleFranceDAO {

	public ArrayList<VilleFrance> trouver(VilleFrance villeFrance) throws SQLException{
		ArrayList<VilleFrance> villes = new ArrayList<VilleFrance>();
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet rset = null;
		
		String codeCommuneINSEE = villeFrance.getCodeCommuneINSEE();
		String nomCommune = villeFrance.getNomCommune();
		String codePostal = villeFrance.getCodePostal();
		String libelleAcheminement = villeFrance.getLibelleAcheminement();
		String ligne5 = villeFrance.getLigne5();
		String latitude = villeFrance.getLatitude();
		String longitude = villeFrance.getLongitude();
		
		try {
			connection = this.getDAOConnection();
			String query = "SELECT * FROM ville_france WHERE "+
			(codeCommuneINSEE == null ? "Code_commune_INSEE IS NOT NULL ":"Code_commune_INSEE = ? ")+
			(nomCommune == null ? "AND Nom_commune IS NOT NULL ":"AND Nom_commune = ? ")+
			(codePostal == null ? "AND Code_postal IS NOT NULL ":"AND Code_postal = ? ")+
			(libelleAcheminement == null ? "AND Libelle_acheminement IS NOT NULL ":"AND Libelle_acheminement = ? ")+
			(ligne5 == null ? "AND Ligne_5 IS NOT NULL ":"AND Ligne_5 = ? ")+
			(latitude == null ? "AND Latitude IS NOT NULL ":"AND Latitude = ? ")+
			(longitude == null ? "AND Longitude IS NOT NULL":"AND Longitude = ? ")
			+";";
			
			preparedStatement = connection.prepareStatement(query);
			int index = 0;
			if(codeCommuneINSEE != null) {
				index++;
				preparedStatement.setString(index, codeCommuneINSEE);
			}
			if(nomCommune != null) {
				index++;
				preparedStatement.setString(index, nomCommune);
			}
			if(codePostal != null) {
				index++;
				preparedStatement.setString(index, codePostal);
			}
			if(libelleAcheminement != null) {
				index++;
				preparedStatement.setString(index, libelleAcheminement);
			}
			if(ligne5 != null) {
				index++;
				preparedStatement.setString(index, ligne5);
			}
			if(latitude != null) {
				index++;
				preparedStatement.setString(index, latitude);
			}
			if(longitude != null) {
				index++;
				preparedStatement.setString(index, longitude);
			}
			
			rset = preparedStatement.executeQuery();
			
			while(rset.next()) {
				villes.add(villeFrance.map(rset.getString("Code_commune_INSEE"), rset.getString("Nom_commune"), 
											rset.getString("Code_postal"), rset.getString("Libelle_acheminement"),
											rset.getString("Ligne_5"), rset.getString("Latitude"), 
											rset.getString("Longitude")));
			}
			
		}catch (SQLException e){
			e.printStackTrace();
		}
		
		return villes;
	}
	
	public void ajouter(VilleFrance ville) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		String codeCommuneINSEE = ville.getCodeCommuneINSEE();
		String nomCommune = ville.getNomCommune();
		String codePostal = ville.getCodePostal();
		String libelleAcheminement = ville.getLibelleAcheminement();
		String ligne5 = ville.getLigne5();
		String latitude = ville.getLatitude();
		String longitude = ville.getLongitude();
		
		try {
			connection = this.getDAOConnection();
			String query = "INSERT INTO ville_france (Code_commune_INSEE,Nom_commune, Code_postal, Libelle_acheminement, "
					+ "Ligne_5, Latitude, Longitude) VALUES(?,?,?,?,?,?,?);";
			preparedStatement = connection.prepareStatement(query);
			
			preparedStatement.setString(1, codeCommuneINSEE);
			preparedStatement.setString(2, nomCommune);
			preparedStatement.setString(3, codePostal);
			preparedStatement.setString(4, libelleAcheminement);
			preparedStatement.setString(5, ligne5);
			preparedStatement.setString(6, latitude);
			preparedStatement.setString(7, longitude);
			
			preparedStatement.executeUpdate();
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void effacer(String code) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		try {
			connection = this.getDAOConnection();
			String query = "DELETE FROM ville_france WHERE Code_commune_INSEE = ? ;";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, code);
			preparedStatement.executeUpdate();
			
			System.out.println(query);
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void modifier(VilleFrance ville) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		String codeCommuneINSEE = ville.getCodeCommuneINSEE();
		String nomCommune = ville.getNomCommune();
		String codePostal = ville.getCodePostal();
		String libelleAcheminement = ville.getLibelleAcheminement();
		String ligne5 = ville.getLigne5();
		String latitude = ville.getLatitude();
		String longitude = ville.getLongitude();
		
		try {
			connection = this.getDAOConnection();
			String query = "UPDATE ville_france SET Nom_commune = ?, Code_postal = ?, "
					+ "Libelle_acheminement = ?, Ligne_5 = ?, Latitude = ?, Longitude = ?"
					+ "WHERE Code_commune_INSEE = ?;";
			preparedStatement = connection.prepareStatement(query);
			
			preparedStatement.setString(1, nomCommune);
			preparedStatement.setString(2, codePostal);
			preparedStatement.setString(3, libelleAcheminement);
			preparedStatement.setString(4, ligne5);
			preparedStatement.setString(5, latitude);
			preparedStatement.setString(6, longitude);
			preparedStatement.setString(7, codeCommuneINSEE);
			
			preparedStatement.executeUpdate();
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	private Connection getDAOConnection(){
		DAOConnection connect = new DAOConnection();
		Connection connection = null;
		try {
			connection = connect.getConnection();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return connection;
	}
}
