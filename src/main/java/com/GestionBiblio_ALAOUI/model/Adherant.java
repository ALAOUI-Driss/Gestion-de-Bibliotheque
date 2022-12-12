package com.GestionBiblio_ALAOUI.model;

import javax.persistence.*;

import java.sql.Date;
import java.text.SimpleDateFormat;

@Entity
@Table
public class Adherant {
	@Id		@GeneratedValue
	protected	int		id;
	protected	String	nom;
	protected	String	prenom;
	protected	String	adresse;
	protected	String	cin;
	protected	Date	date;
	
	public Adherant() {
		super();
	}
	public Adherant(int id, String nom, String prenom, String adresse, String cin, Date date) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.adresse = adresse;
		this.cin = cin;
		this.date = date;
	}
	public int getId() {
		return id;
	}
	public String getNom() {
		return nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public String getAdresse() {
		return adresse;
	}
	public String getCin() {
		return cin;
	}
	public Date getDate() {
		return date;
	}
	public String getSimpleDate() {
		return  new SimpleDateFormat("yyyy-MM-dd").format(this.date);
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public void setCin(String cin) {
		this.cin = cin;
	}
	public void setDate(Date date) {
		this.date = date;
	}
}
