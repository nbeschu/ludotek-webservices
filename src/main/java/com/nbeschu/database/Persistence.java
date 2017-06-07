package com.nbeschu.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Persistence {
	private String DBPath = "src/main/resources/test.db";
    private Connection connection = null;
    private Statement statement = null;
 
    public Persistence(String dBPath) {
        DBPath = dBPath;
    }
    
    public Persistence() {
    }
 
    public void connect() {
        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:" + DBPath);
            statement = connection.createStatement();
            System.out.println("Connexion a " + DBPath + " avec succès");
        } catch (ClassNotFoundException notFoundException) {
            notFoundException.printStackTrace();
            System.out.println("Erreur de connexion");
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
            System.out.println("Erreur de connexion");
        }
    }
 
    public void close() {
        try {
            connection.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public static void main( String args[] )
    {
    	Persistence connexion = new Persistence();
    	connexion.connect();
    	System.out.println("Opened database successfully");
    }
}
