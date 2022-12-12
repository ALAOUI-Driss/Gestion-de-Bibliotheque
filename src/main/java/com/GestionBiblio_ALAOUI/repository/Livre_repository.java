package com.GestionBiblio_ALAOUI.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.GestionBiblio_ALAOUI.model.Livre;

@Repository
public interface Livre_repository extends CrudRepository<Livre, Integer> {
	public List<Livre> findByPrix(int prix);
	public List<Livre> findByAuteur(String auteur);
	public List<Livre> findByNbrpages(int nbrpages);
}
