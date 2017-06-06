package com.nbeschu.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Item {

	/////////////////////
	// champs de classes
	/////////////////////

	private String name;

	private String description;
	
	/////////////////////
	// constructeurs
	/////////////////////
	
	public Item(String name, String description) {
		this.name = name;
		this.description = description;
	}
	
	public Item() {
		this.name = "";
		this.description = "";
	}

	/////////////////////
	// getters / setters
	/////////////////////
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
