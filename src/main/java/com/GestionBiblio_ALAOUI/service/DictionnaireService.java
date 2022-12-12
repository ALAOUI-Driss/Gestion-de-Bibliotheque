package com.GestionBiblio_ALAOUI.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.GestionBiblio_ALAOUI.model.Dictionnaire;
import com.GestionBiblio_ALAOUI.repository.Dictionnaire_repository;

@Service
public class DictionnaireService {
	@Autowired
	Dictionnaire_repository dictionnaire_repository;
	
	public List<Dictionnaire> getAllDictionnaires(){
		return (List<Dictionnaire>) dictionnaire_repository.findAll();
	}
	public void saveorupdate(Dictionnaire dictionnaire) {
		dictionnaire_repository.save(dictionnaire);
	}
	public void delete(int id) {
		dictionnaire_repository.deleteById(id);
	}
	public Optional<Dictionnaire> getDictionnaireById(int id) {
		return dictionnaire_repository.findById(id);
	}
	public List<Dictionnaire> getDictionnaireByLangue(String langue) {
		return dictionnaire_repository.findByLangue(langue);
	}
}
