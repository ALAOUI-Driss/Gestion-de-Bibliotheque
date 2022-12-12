package com.GestionBiblio_ALAOUI.model;
import java.sql.Date;

import javax.persistence.*;

@Entity
@Table
public class Emprunt {
	@Id		@GeneratedValue
	protected int id;
	protected Date dateEmprunt;
	protected Date dateRetour;
	
	@OneToOne
	protected Adherant adherant;
	
	@OneToOne
	protected Document document;
	
	public Emprunt() {
		super();
	}

	public Emprunt(int id, Date dateEmprunt, Date dateRetour, Adherant adherant, Document document) {
		super();
		this.id = id;
		this.dateEmprunt = dateEmprunt;
		this.dateRetour = dateRetour;
		this.adherant = adherant;
		this.document = document;
	}

	public int getId() {
		return id;
	}

	public Date getDateEmprunt() {
		return dateEmprunt;
	}

	public Date getDateRetour() {
		return dateRetour;
	}

	public Adherant getAdherant() {
		return adherant;
	}

	public Document getDocument() {
		return document;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setDateEmprunt(Date dateEmprunt) {
		this.dateEmprunt = dateEmprunt;
	}

	public void setDateRetour(Date dateRetour) {
		this.dateRetour = dateRetour;
	}

	public void setAdherant(Adherant adherant) {
		this.adherant = adherant;
	}

	public void setDocument(Document document) {
		this.document = document;
	}
}
