package com.nbeschu.database;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nbeschu.model.Item;
import com.nbeschu.model.ItemTag;

public class ItemDaoFactory 
{
	/**
	 * La session Hibernate
	 */
	private static Session session;
	
	/**
	 * Le logger
	 */
	private static final Logger logger = LogManager.getLogger(ItemDaoFactory.class.getName());
	
	/**
	 * Ajoute un item en BDD
	 * @param item : l'item à ajouter en BDD
	 */
	public static Item insertItem(Item item) 
	{
		logger.traceEntry();
	    Transaction tx = null;
	   
	    try 
	    {
	    	session = DaoFactory.getSessionFactory().openSession();
	        tx = session.beginTransaction();
	         
	        // Saving to the database
	        session.save(item);
	         
	        // Committing the change in the database.
	        session.flush();
	        tx.commit();
	         
	    } 
	    catch (Exception ex) 
	    {
	        ex.printStackTrace();
	         
	        // Rolling back the changes to make the data consistent in case of any failure 
	        // in between multiple database write operations.
	        tx.rollback();
	    } 
	    finally
	    {
	        if(session != null) 
	        {
	            session.close();
	        }
	    }
	    
	    logger.traceExit();
	    return item;
	}
	
	/**
	 * Récupère l'ensemble des items de la ludothèque
	 * @return l'ensemble des items de la ludothèque
	 */
	public static List<Item> getItems()
	{
		logger.traceEntry();
		List<Item> itemList = null;
		
		try 
		{
	    	session = DaoFactory.getSessionFactory().openSession();
	         
	    	// Fetching saved data
	        itemList = session.createQuery("from Item").list();
	        
	        if (itemList == null) 
	        {
	        	itemList = new ArrayList<Item>();
	        }
	         
	    } 
		catch (Exception ex) 
		{
	        ex.printStackTrace();
	    } 
		finally
		{
	        if(session != null) 
	        {
	            session.close();
	        }
	    }
        
		logger.traceExit();
        return itemList;
	}
	
	/**
	 * récupère en BDD l'ensemble des items de la ludothèque correspondant au tag voulu
	 * @param tag : tag à rechercher
	 * @return l'ensemble des items de la ludothèque correspondant au tag cherché
	 */
	public static List<Item> getItemsByTag(ItemTag tag)
	{
		logger.traceEntry();
		List<Item> itemList = null;
		
		try 
		{
	    	session = DaoFactory.getSessionFactory().openSession();
	         
	    	// Fetching saved data
	        itemList = session.createQuery("from Item where tag = :tag").setParameter("tag", tag).list();
	        
	        if (itemList == null) 
	        {
	        	itemList = new ArrayList<Item>();
	        }
	         
	    } 
		catch (Exception ex) 
		{
	        ex.printStackTrace();
	    } 
		finally
		{
	        if(session != null) 
	        {
	            session.close();
	        }
	    }
        
		logger.traceExit();
        return itemList;
	}
	
	/**
	 * Supprime un item de la ludothèque
	 * @param item : l'item à supprimer
	 */
	public static boolean deleteItem(Item item)
	{
		logger.traceEntry();
		Transaction tx = null;
		boolean result = true; 
		
		try 
		{
	    	session = DaoFactory.getSessionFactory().openSession();
	    	tx = session.beginTransaction();
	         
    		session.delete(item);
	        
	        // Committing the change in the database.
	        session.flush();
	        tx.commit();
	         
	    } 
		catch (Exception ex) 
		{
	        ex.printStackTrace();
	        
	        // Rolling back the changes to make the data consistent in case of any failure 
	        // in between multiple database write operations.
	        tx.rollback();
	        
	        result = false;
	    } 
		finally
		{
	        if(session != null) 
	        {
	            session.close();
	        }
	    }
		
		logger.traceExit();
		return result;
	}
}
