package com.GestionBiblio_ALAOUI.service;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.GestionBiblio_ALAOUI.model.Adherant;
import com.GestionBiblio_ALAOUI.model.Document;
import com.GestionBiblio_ALAOUI.model.Emprunt;
import com.GestionBiblio_ALAOUI.repository.Emprunt_repository;

@Service
public class EmpruntService {
	@Autowired
	Emprunt_repository emprunt_repository;
	
	public List<Emprunt> getAllEmprunts(){
		return (List<Emprunt>) emprunt_repository.findAll();
	}
	public void saveorupdate(Emprunt emprunt) {
		emprunt_repository.save(emprunt);
	}
	public void delete(int id) {
		emprunt_repository.deleteById(id);
	}
	public Optional<Emprunt> getEmpruntById(int id) {
		return emprunt_repository.findById(id);
	}
	public List<Emprunt> getEmpruntByDateEmprunt(Date dateEmprunt) {
		return emprunt_repository.findByDateEmprunt(dateEmprunt);
	}
	public List<Emprunt> getEmpruntByDateRetour(Date dateRetour) {
		return emprunt_repository.findByDateRetour(dateRetour);
	}
	public List<Emprunt> getEmpruntByAdherant(Adherant adherant) {
		return emprunt_repository.findByAdherant(adherant);
	}
	public List<Emprunt> getEmpruntByDocument(Document document) {
		return emprunt_repository.findByDocument(document);
	}
}