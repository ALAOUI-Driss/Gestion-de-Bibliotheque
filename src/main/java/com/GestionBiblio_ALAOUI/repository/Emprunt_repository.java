package com.GestionBiblio_ALAOUI.repository;

import java.sql.Date;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.GestionBiblio_ALAOUI.model.Adherant;
import com.GestionBiblio_ALAOUI.model.Document;
import com.GestionBiblio_ALAOUI.model.Emprunt;

public interface Emprunt_repository extends CrudRepository<Emprunt, Integer>{
	public List<Emprunt> findByDateEmprunt(Date dateEmprunt);
	public List<Emprunt> findByDateRetour(Date dateRetour);;
	public List<Emprunt> findByAdherant(Adherant adherant);
	public List<Emprunt> findByDocument(Document document);
}
