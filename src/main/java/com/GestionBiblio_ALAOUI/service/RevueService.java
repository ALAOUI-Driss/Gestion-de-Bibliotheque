package com.GestionBiblio_ALAOUI.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.GestionBiblio_ALAOUI.model.Revue;
import com.GestionBiblio_ALAOUI.repository.Revue_repository;

@Service
public class RevueService {
	@Autowired
	Revue_repository revue_repository;
	
	public List<Revue> getAllRevues(){
		return (List<Revue>) revue_repository.findAll();
	}
	public void saveorupdate(Revue revue) {
		revue_repository.save(revue);
	}
	public void delete(int id) {
		revue_repository.deleteById(id);
	}
	public Optional<Revue> getRevueById(int id) {
		return revue_repository.findById(id);
	}
	public List<Revue> getRevueByAnnee(int annee){
		return revue_repository.findByAnnee(annee);
	}
}
