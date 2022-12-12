package com.GestionBiblio_ALAOUI.model;
import javax.persistence.*;

@Entity
@Table
public class Dictionnaire extends Document {
	protected String langue;

	public Dictionnaire() {
		super();
	}

	public Dictionnaire(int id, int prix, int dispo) {
		super(id, prix, dispo);
	}

	public Dictionnaire(String langue) {
		super();
		this.langue = langue;
	}

	public Dictionnaire(int id, int prix, int dispo, String langue) {
		super(id, prix, dispo);
		this.langue = langue;
	}

	public String getLangue() {
		return langue;
	}

	public void setLangue(String langue) {
		this.langue = langue;
	}
}
