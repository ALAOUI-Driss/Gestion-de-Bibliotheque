package com.GestionBiblio_ALAOUI.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.GestionBiblio_ALAOUI.model.Revue;

@Repository
public interface Revue_repository extends CrudRepository<Revue, Integer>{
	public List<Revue> findByAnnee(int annee);
}
