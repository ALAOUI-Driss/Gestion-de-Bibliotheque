package com.GestionBiblio_ALAOUI.model;
import javax.persistence.*;

@Entity
@Table
public class Livre extends Document{
	protected String	auteur;
	protected int		nbrpages;
	
	public Livre() {
		super();
	}
	public Livre(int id, int prix, int dispo) {
		super(id, prix, dispo);
	}
	public Livre(String auteur, int nbrpages) {
		super();
		this.auteur = auteur;
		this.nbrpages = nbrpages;
	}
	public Livre(int id, int prix, int dispo, String auteur, int nbrpages) {
		super(id, prix, dispo);
		this.auteur = auteur;
		this.nbrpages = nbrpages;
	}
	public String getAuteur() {
		return auteur;
	}
	public int getNbrpages() {
		return nbrpages;
	}
	public void setAuteur(String auteur) {
		this.auteur = auteur;
	}
	public void setNbrpages(int nbrpages) {
		this.nbrpages = nbrpages;
	}
}
