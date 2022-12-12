package com.GestionBiblio_ALAOUI.repository;

import java.sql.Date;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.GestionBiblio_ALAOUI.model.Adherant;

@Repository
public interface Adherant_repository extends CrudRepository<Adherant, Integer>{
	
	public List<Adherant> findByNom(String nom);
	public List<Adherant> findByPrenom(String prenom);
	public List<Adherant> findByAdresse(String adresse);
	public List<Adherant> findByCin(String cin);
	public List<Adherant> findByDate(Date date);
}
