package com.GestionBiblio_ALAOUI.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.GestionBiblio_ALAOUI.model.Dictionnaire;
import com.GestionBiblio_ALAOUI.service.DictionnaireService;

@Controller
@RequestMapping("/document/dictionnaire")
public class DictionnaireController {
	@Autowired
	protected DictionnaireService dictionnaireservice;
	
	@GetMapping({"","/index"})
	public String home(Model model) {
		model.addAttribute("dictionnaires", dictionnaireservice.getAllDictionnaires());
		return "/document/dictionnaire/index";
	}
	
	@GetMapping("/ajouter")
	public String ajouter_get(Dictionnaire dictionnaire) {
		return "/document/dictionnaire/ajouter";
	}
	
	@GetMapping("/modifier")
	public String modifier_get(int id, Model model) {
		model.addAttribute("dictionnaire", 
			dictionnaireservice.getDictionnaireById(Integer.valueOf(id)).get());
		return "/document/dictionnaire/modifier";
	}
	
	@PostMapping({"/ajouter","/modifier"})
	public String ajouter_modifier_post(Dictionnaire dictionnaire) {
		dictionnaireservice.saveorupdate(dictionnaire);
		return "redirect:/document/dictionnaire/index";
	}
	
	@GetMapping("/supprimer")
	public String supprimer(int id) {
		dictionnaireservice.delete(id);
		return "redirect:/document/dictionnaire/index";
	}
	
	@GetMapping("/rechercher")
	public String recherche(Model model, String search, String searchType) {
		if(search.equals(""))
			return "redirect:/adherant/index";
		try {
			switch(searchType) {
			case "id":
				model.addAttribute("dictionnaires", 
					dictionnaireservice.getDictionnaireById(Integer.valueOf(search)).get());
				break;
				
			case "langue":
				model.addAttribute("dictionnaires", dictionnaireservice.getDictionnaireByLangue(search));
				break;
			}
			
		}
		catch (java.util.NoSuchElementException 
				| java.lang.NumberFormatException e) {
			model.addAttribute("dictionnaires", new Dictionnaire());
		}
			return "/document/dictionnaire/index";
	}
}


