package com.GestionBiblio_ALAOUI.controller;

import java.sql.Date;
//import java.text.SimpleDateFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.GestionBiblio_ALAOUI.model.Emprunt;
import com.GestionBiblio_ALAOUI.service.AdherantService;
import com.GestionBiblio_ALAOUI.service.DocumentService;
import com.GestionBiblio_ALAOUI.service.EmpruntService;

@Controller
@RequestMapping("/emprunt")
public class EmpruntController {
	@Autowired
	protected EmpruntService empruntService;
	@Autowired
	protected AdherantService adherantService;
	@Autowired
	protected DocumentService documentService;
	
	
	@GetMapping({"","/index"})
	public String index(Model model) {
		model.addAttribute("emprunts", empruntService.getAllEmprunts());
		model.addAttribute("adherants", adherantService.getAllAdherants());
		model.addAttribute("documents", documentService.getAllDocuments());
		return "emprunt/index";
	}
	
	@GetMapping("/ajouter")
	public String ajouter_get(Emprunt emprunt, Model model, String erreur) {
		model.addAttribute("adherants", adherantService.getAllAdherants());
		model.addAttribute("documents", documentService.getAllDocuments());
		System.out.println(erreur);
		model.addAttribute("erreur", erreur);
		return "emprunt/ajouter";
	}
	
	@GetMapping("/modifier")
	public String modifier_get(int id, Model model) {
		model.addAttribute("emprunt", 
			empruntService.getEmpruntById(Integer.valueOf(id)).get());
		return "emprunt/modifier";
	}
	
	@PostMapping({"/ajouter","/modifier"})
	public String ajouter_modifier_post(Emprunt emprunt, Model model) {
		if(emprunt.getDateRetour().compareTo(emprunt.getDateEmprunt())<0) {
			model.addAttribute("erreur", "erreur_date");
			return "/emprunt/ajouter";
		}
		empruntService.saveorupdate(emprunt);
		return "redirect:/emprunt/index";
	}
	
	@GetMapping("/supprimer")
	public String supprimer(int id) {
		empruntService.delete(id);
		return "redirect:/emprunt/index";
	}
	

	
	@GetMapping("/rechercher")
	public String recherche(Model model, String search, String searchType) {
		model.addAttribute("emprunts", empruntService.getAllEmprunts());
		model.addAttribute("adherants", adherantService.getAllAdherants());
		model.addAttribute("documents", documentService.getAllDocuments());
		System.out.println(searchType);
		if(search.equals(""))
			return "redirect:/emprunt/index";
		try {
			switch(searchType) {
			case "id":
				model.addAttribute("emprunts", 
					empruntService.getEmpruntById(Integer.valueOf(search)).get());
				break;
			case "adherant":
				model.addAttribute("emprunts", 
					empruntService.getEmpruntByAdherant(
					adherantService.getAdherantById(Integer.valueOf(search)).get()));
				break;
			case "document":
				model.addAttribute("emprunts", 
					empruntService.getEmpruntByDocument(
					documentService.getDocumentById(Integer.valueOf(search)).get()));
				break;
			case "dateEmprunt":
				model.addAttribute("emprunts", 
					empruntService.getEmpruntByDateEmprunt(Date.valueOf(search)));
				break;
			case "dateRetour":
				model.addAttribute("emprunts", 
					empruntService.getEmpruntByDateRetour(Date.valueOf(search)));
				break;
			}
			
		}
		catch (java.util.NoSuchElementException 
				| java.lang.NumberFormatException e) {
			model.addAttribute("emprunt", new Emprunt());
		}
			return "emprunt/index";
	}
}
