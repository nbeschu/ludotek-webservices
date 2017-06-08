package com.nbeschu.business;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

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
public class ItemBusiness {
	
	/**
	 * récupère l'ensemble des items de la ludothèque
	 * @return l'ensemble des items de la ludothèque
	 */
	@GET
	@Produces({MediaType.APPLICATION_JSON})
	public List<Item> getItem() {
		
		List<Item> result = ItemDaoFactory.getItems();
		
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
	public List<Item> getItem(@PathParam("tag") ItemTag tag) {		
		List<Item> result = new ArrayList<>();
		
		Item item1 = new Item ("toto", "je suis l'item toto de tag " + tag, "", tag);
		Item item2 = new Item ("tata", "je suis l'item tata de tag " + tag, "", tag);

		result.add(item1);
		result.add(item2);
     
		//Appel au DAO pour sauver en BDD
        ItemDaoFactory.insertItem(item1);
        ItemDaoFactory.insertItem(item2);
		
		return result;
	}
}
