package com.GestionBiblio_ALAOUI.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.GestionBiblio_ALAOUI.model.Document;

@Repository
public interface Document_repository extends CrudRepository<Document, Integer> {

}
