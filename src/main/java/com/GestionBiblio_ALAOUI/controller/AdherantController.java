package com.GestionBiblio_ALAOUI.controller;

import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.GestionBiblio_ALAOUI.model.Adherant;
import com.GestionBiblio_ALAOUI.service.AdherantService;

@Controller
@RequestMapping("/adherant")
public class AdherantController {
	@Autowired
	protected AdherantService adherantService;
	
	@GetMapping({"","/index"})
	public String index(Model model) {
		model.addAttribute("adherants", adherantService.getAllAdherants());
		return "adherant/index";
	}
	
	@GetMapping("/ajouter")
	public String ajouter_get(Adherant adherant) {
		return "adherant/ajouter";
	}
	
	@GetMapping("/modifier")
	public String modifier_get(int id, Model model) {
		model.addAttribute("adherant", 
			adherantService.getAdherantById(Integer.valueOf(id)).get());
		return "adherant/modifier";
	}
	
	@PostMapping({"/ajouter","/modifier"})
	public String ajouter_modifier_post(Adherant adherant) {
		adherantService.saveorupdate(adherant);
		return "redirect:/adherant/index";
	}
	
	@GetMapping("/supprimer")
	public String supprimer(int id) {
		adherantService.delete(id);
		return "redirect:/adherant/index";
	}
	
	@GetMapping("/rechercher")
	public String recherche(Model model, String search, String searchType) {
		if(search.equals(""))
			return "redirect:/adherant/index";
		try {
			switch(searchType) {
			case "id":
				model.addAttribute("adherants", 
					adherantService.getAdherantById(Integer.valueOf(search)).get());
				break;
				
			case "nom":
				model.addAttribute("adherants", 
					adherantService.getAdherantByNom(search));
				break;
			case "prenom":
				model.addAttribute("adherants", 
					adherantService.getAdherantByPrenom(search));
				break;
			case "adresse":
				model.addAttribute("adherants", 
					adherantService.getAdherantByAdresse(search));
				break;
			case "cin":
				model.addAttribute("adherants", 
					adherantService.getAdherantByCin(search));
				break;
			case "date":
				model.addAttribute("adherants", 
						adherantService.getAdherantByDate(Date.valueOf(search)));
					break;
				
			}
			
		}
		catch (java.util.NoSuchElementException 
				| java.lang.NumberFormatException e) {
			model.addAttribute("adherants", new Adherant());
		}
			return "adherant/index";
	}
	
}
