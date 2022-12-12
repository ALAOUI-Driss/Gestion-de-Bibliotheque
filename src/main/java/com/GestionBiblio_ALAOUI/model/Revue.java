package com.GestionBiblio_ALAOUI.model;
import javax.persistence.*;

@Entity
@Table
public class Revue extends Document{
	protected int	annee;
	public Revue() {
		super();
	}
	
	public Revue(int id, int prix, int dispo) {
		super(id, prix, dispo);
	}
	
	public Revue(int annee) {
		super();
		this.annee = annee;
	}
	
	public Revue(int id, int prix, int dispo, int annee) {
		super(id, prix, dispo);
		this.annee = annee;
	}
	
	public int getAnnee() {
		return annee;
	}
	public void setAnnee(int annee) {
		this.annee = annee;
	}
}
