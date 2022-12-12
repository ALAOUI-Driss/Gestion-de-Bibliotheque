package com.GestionBiblio_ALAOUI.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.GestionBiblio_ALAOUI.model.Livre;
import com.GestionBiblio_ALAOUI.repository.Livre_repository;

@Service
public class LivreService {
	@Autowired
	Livre_repository livre_repository;
	
	public List<Livre> getAllLivres(){
		return (List<Livre>) livre_repository.findAll();
	}
	public void saveorupdate(Livre livre) {
		livre_repository.save(livre);
	}
	public void delete(int id) {
		livre_repository.deleteById(id);
	}
	public Optional<Livre> getLivreById(int id) {
		return livre_repository.findById(id);
	}
	public List<Livre> getLivreByPrix(int prix){
		return livre_repository.findByPrix(prix);
	}
	
	public List<Livre> getLivreByAuteur(String auteur) {
		return livre_repository.findByAuteur(auteur);
	}
	
	public List<Livre> getLivreByNbrpages(int nbrpages) {
		return livre_repository.findByNbrpages(nbrpages);
	}
}
