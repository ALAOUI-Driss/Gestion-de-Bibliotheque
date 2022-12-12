package com.GestionBiblio_ALAOUI.service;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.GestionBiblio_ALAOUI.model.Adherant;
import com.GestionBiblio_ALAOUI.repository.Adherant_repository;

@Service
public class AdherantService {
	@Autowired
	Adherant_repository adherant_repository;
	
	public List<Adherant> getAllAdherants(){
		return (List<Adherant>) adherant_repository.findAll();
	}
	public void saveorupdate(Adherant adherant) {
		adherant_repository.save(adherant);
	}
	public void delete(int id) {
		adherant_repository.deleteById(id);
	}
	public Optional<Adherant> getAdherantById(int id) {
		return adherant_repository.findById(id);
	}
	public List<Adherant> getAdherantByNom(String nom){
		return adherant_repository.findByNom(nom);
	}
	
	public List<Adherant> getAdherantByPrenom(String prenom) {
		return adherant_repository.findByPrenom(prenom);
	}
	
	public List<Adherant> getAdherantByAdresse(String adresse) {
		return adherant_repository.findByAdresse(adresse);
	}
	public List<Adherant> getAdherantByCin(String cin) {
		return adherant_repository.findByCin(cin);
	}
	public List<Adherant> getAdherantByDate(Date date) {
		return adherant_repository.findByDate(date);
	}
}
