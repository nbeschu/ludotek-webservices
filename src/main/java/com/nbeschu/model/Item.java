package com.nbeschu.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "item")
@XmlRootElement
public class Item {

	/////////////////////
	// champs de classes
	/////////////////////

	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	
	private String name;

	private String description;
	
	private String lienHypertexte;
	
	private ItemTag tag;
	
	/////////////////////
	// constructeurs
	/////////////////////
	
	public Item(int id, String name, String description, String lienHypertexte, ItemTag tag) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.lienHypertexte = lienHypertexte;
		this.tag = tag;
	}
	
	public Item(String name, String description, String lienHypertexte, ItemTag tag) {
		this.id = null;
		this.name = name;
		this.description = description;
		this.lienHypertexte = lienHypertexte;
		this.tag = tag;
	}
	
	public Item() {
		
	}

	/////////////////////
	// getters / setters
	/////////////////////
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
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

	public String getLienHypertexte() {
		return lienHypertexte;
	}

	public void setLienHypertexte(String lienHypertexte) {
		this.lienHypertexte = lienHypertexte;
	}

	public ItemTag getTag() {
		return tag;
	}

	public void setTag(ItemTag tag) {
		this.tag = tag;
	}
}
