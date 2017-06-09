package com.nbeschu.business;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.nbeschu.database.ItemDaoFactory;
import com.nbeschu.model.Item;
import com.nbeschu.model.ItemTag;

/**
 * Business pour la gestion de la ludothèque
 * syntaxe de l'URL : http://host:port/nomDuComposant/servlet-mapping/path
 * nomDuComposant = nom du composant déployer sur le serveur d'app
 * servlet-mapping : URL mappé via le web.xml
 * path : URL vers le service REST
 * 
 * exemple : http://localhost:8080/ludotek-webservices/ludotek/ressource
 *
 */

/**
 * Classe business de récupèration de la ludothèque
 * @author nbeschu
 *
 */
@Path("ressource")
public class ItemBusiness 
{
	/**
	 * Le logger
	 */
	private static final Logger logger = LogManager.getLogger(ItemBusiness.class.getName());
	
	/**
	 * récupère l'ensemble des items de la ludothèque
	 * @return l'ensemble des items de la ludothèque
	 */
	@GET
	@Produces({MediaType.APPLICATION_JSON})
	public List<Item> getItem() 
	{
		logger.traceEntry();
		
		List<Item> result = ItemDaoFactory.getItems();
		
		logger.traceExit();
		
		return result;
	}
	
	/**
	 * récupère l'ensemble des items de la ludothèque en fonction du tag cherché
	 * @param tag : le tag des items à rechercher
	 * @return l'ensemble des items de la ludothèque du tag cherché
	 */
	@Path("{tag}")
	@GET
	@Produces({MediaType.APPLICATION_JSON})
	public List<Item> getItem(@PathParam("tag") ItemTag tag) 
	{		
		logger.traceEntry();
		
		List<Item> result = ItemDaoFactory.getItemsByTag(tag);
		
		logger.traceExit();
		
		return result;
	}
	
	/**
	 * Ajoute un nouvel item à la ludothèque
	 * @param tag : l'item à ajouter
	 * @return l'item ajouté
	 */
	@POST
	@Produces({MediaType.APPLICATION_JSON})
	public Item AddItem(Item item) 
	{		
		logger.traceEntry();
		
		Item result = ItemDaoFactory.insertItem(item);
		
		logger.traceExit();
        return result;
	}
}
