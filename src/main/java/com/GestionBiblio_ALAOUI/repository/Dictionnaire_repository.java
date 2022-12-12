package com.GestionBiblio_ALAOUI.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.GestionBiblio_ALAOUI.model.Dictionnaire;

public interface Dictionnaire_repository extends CrudRepository<Dictionnaire, Integer>{
	public List<Dictionnaire> findByLangue(String langue);
}
