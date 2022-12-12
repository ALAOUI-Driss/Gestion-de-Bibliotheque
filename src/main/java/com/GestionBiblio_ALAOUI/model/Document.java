package com.GestionBiblio_ALAOUI.model;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Document {
	@Id		@GeneratedValue
	protected int id;
	protected int prix;
	protected int dispo;
	public Document() {
		super();
	}
	public Document(int id, int prix, int dispo) {
		super();
		this.id = id;
		this.prix = prix;
		this.dispo = dispo;
	}
	public int getId() {
		return id;
	}
	public int getPrix() {
		return prix;
	}
	public int getDispo() {
		return dispo;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setPrix(int prix) {
		this.prix = prix;
	}
	public void setDispo(int dispo) {
		this.dispo = dispo;
	}
}
