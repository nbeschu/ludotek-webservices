package com.nbeschu.database;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nbeschu.model.Item;

public class ItemDaoFactory {
	
	private static Session session;
	
	/**
	 * Ajoute un item en BDD
	 * @param item : l'item à ajouter en BDD
	 */
	public static void insertItem(Item item) {
	    Transaction tx = null;
	   
	    try {
	    	session = DaoFactory.getSessionFactory().openSession();
	        tx = session.beginTransaction();
	         
	        // Saving to the database
	        session.save(item);
	         
	        // Committing the change in the database.
	        session.flush();
	        tx.commit();
	         
	    } catch (Exception ex) {
	        ex.printStackTrace();
	         
	        // Rolling back the changes to make the data consistent in case of any failure 
	        // in between multiple database write operations.
	        tx.rollback();
	    } finally{
	        if(session != null) {
	            session.close();
	        }
	    }
	}
	
	public static List<Item> getItems(){
		List<Item> itemList = null;
		
		try {
	    	session = DaoFactory.getSessionFactory().openSession();
	         
	    	// Fetching saved data
	        itemList = session.createQuery("from Item").list();
	        
	        if (itemList == null) {
	        	itemList = new ArrayList<Item>();
	        }
	        
//	        for (Item item : itemList) {
//          System.out.println("Id: " + contact.getId() + " | Name:"  + contact.getName() + " | Email:" + contact.getEmail());
//      }
	         
	    } catch (Exception ex) {
	        ex.printStackTrace();
	    } finally{
	        if(session != null) {
	            session.close();
	        }
	    }
        
        return itemList;
	}
	
	public static void deleteAllItems(){
		Transaction tx = null;
		
		try {
	    	session = DaoFactory.getSessionFactory().openSession();
	    	tx = session.beginTransaction();
	         
	    	// Fetching saved data
	    	List<Item> itemList = session.createQuery("from Item").list();
	        
	        if (itemList != null) {
	        	for (Item item : itemList) {
	        		session.delete(item);
	        	}
	        }
	        
	        // Committing the change in the database.
	        session.flush();
	        tx.commit();
	         
	    } catch (Exception ex) {
	        ex.printStackTrace();
	        
	        // Rolling back the changes to make the data consistent in case of any failure 
	        // in between multiple database write operations.
	        tx.rollback();
	    } finally{
	        if(session != null) {
	            session.close();
	        }
	    }
	}
	
	public static void deleteItem(Item item){
		Transaction tx = null;
		
		try {
	    	session = DaoFactory.getSessionFactory().openSession();
	    	tx = session.beginTransaction();
	         
    		session.delete(item);
	        
	        // Committing the change in the database.
	        session.flush();
	        tx.commit();
	         
	    } catch (Exception ex) {
	        ex.printStackTrace();
	        
	        // Rolling back the changes to make the data consistent in case of any failure 
	        // in between multiple database write operations.
	        tx.rollback();
	    } finally{
	        if(session != null) {
	            session.close();
	        }
	    }
	}
}
