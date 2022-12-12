package com.GestionBiblio_ALAOUI.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.GestionBiblio_ALAOUI.model.Livre;
import com.GestionBiblio_ALAOUI.service.LivreService;

@Controller
@RequestMapping("/document/livre")
public class LivreController {
	@Autowired
	protected LivreService livreservice;
	
	@GetMapping({"","/index"})
	public String home(Model model) {
		model.addAttribute("livres", livreservice.getAllLivres());
		return "/document/livre/index";
	}
	
	@GetMapping("/ajouter")
	public String ajouter_get(Livre livre) {
		return "/document/livre/ajouter";
	}
	
	@GetMapping("/modifier")
	public String modifier_get(int id, Model model) {
		model.addAttribute("livre", 
			livreservice.getLivreById(Integer.valueOf(id)).get());
		return "/document/livre/modifier";
	}
	
	@PostMapping({"/ajouter","/modifier"})
	public String ajouter_modifier_post(Livre livre) {
		livreservice.saveorupdate(livre);
		return "redirect:/document/livre/index";
	}
	
	@GetMapping("/supprimer")
	public String supprimer(int id) {
		livreservice.delete(id);
		return "redirect:/document/livre/index";
	}
	
	@GetMapping("/rechercher")
	public String recherche(Model model, String search, String searchType) {
		if(search.equals(""))
			return "redirect:/adherant/index";
		try {
			switch(searchType) {
			case "id":
				model.addAttribute("livres", 
					livreservice.getLivreById(Integer.valueOf(search)).get());
				break;
				
			case "auteur":
				model.addAttribute("livres", livreservice.getLivreByAuteur(search));
				break;
			case "prix":
				model.addAttribute("livres", 
					livreservice.getLivreByPrix(Integer.valueOf(search)));
				break;
			}
			
		}
		catch (java.util.NoSuchElementException 
				| java.lang.NumberFormatException e) {
			model.addAttribute("livres", new Livre());
		}
			return "/document/livre/index";
	}
}


