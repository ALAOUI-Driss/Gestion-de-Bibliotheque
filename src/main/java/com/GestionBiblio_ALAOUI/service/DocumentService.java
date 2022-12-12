package com.GestionBiblio_ALAOUI.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.GestionBiblio_ALAOUI.model.Document;
import com.GestionBiblio_ALAOUI.repository.Document_repository;

@Service
public class DocumentService {
	@Autowired
	Document_repository document_repository;
	
	public List<Document> getAllDocuments() {
		return (List<Document>) document_repository.findAll();
	}

	public Optional<Document> getDocumentById(int id) {
		return document_repository.findById(id);
	}
}
