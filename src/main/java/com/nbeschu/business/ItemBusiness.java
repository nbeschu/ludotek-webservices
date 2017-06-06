package com.nbeschu.business;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.json.JSONObject;

import com.nbeschu.model.Item;

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
 * Classe business de récupère de la ludothèque
 * @author nbeschu
 *
 */
@Path("ressource")
public class ItemBusiness {
	
	/**
	 * retourne l'ensemble des ressources
	 * @return en JSON
	 */
	@GET
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public List<Item> getItem() {
		
		List<Item> result = new ArrayList<>();
		
		Item item1 = new Item ("toto", "je suis l'item toto");
		Item item2 = new Item ("tata", "je suis l'item tata");

		result.add(item1);
		result.add(item2);
		
		return result;
	}
}
