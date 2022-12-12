package com.GestionBiblio_ALAOUI.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.GestionBiblio_ALAOUI.model.Revue;
import com.GestionBiblio_ALAOUI.service.RevueService;

@Controller
@RequestMapping("/document/revue")
public class RevueController {
	@Autowired
	protected RevueService revueservice;
	
	@GetMapping({"","/index"})
	public String home(Model model) {
		model.addAttribute("revues", revueservice.getAllRevues());
		return "/document/revue/index";
	}
	
	@GetMapping("/ajouter")
	public String ajouter_get(Revue revue) {
		return "/document/revue/ajouter";
	}
	
	@GetMapping("/modifier")
	public String modifier_get(int id, Model model) {
		model.addAttribute("revue", 
			revueservice.getRevueById(Integer.valueOf(id)).get());
		return "/document/revue/modifier";
	}
	
	@PostMapping({"/ajouter","/modifier"})
	public String ajouter_post(Revue revue) {
		revueservice.saveorupdate(revue);
		return "redirect:/document/revue/index";
	}
	
	@GetMapping("/supprimer")
	public String supprimer(int id) {
		revueservice.delete(id);
		return "redirect:/document/revue/index";
	}
	
	@GetMapping("/rechercher")
	public String recherche(Model model, String search, String searchType) {
		if(search.equals(""))
			return "redirect:/adherant/index";
		try {
			switch(searchType) {
			case "id":
				model.addAttribute("revues", 
					revueservice.getRevueById(Integer.valueOf(search)).get());
				break;
			case "annee":
				model.addAttribute("revue", revueservice.getRevueByAnnee(Integer.valueOf(search)));
				break;
			}
			
		}
		catch (java.util.NoSuchElementException 
				| java.lang.NumberFormatException e) {
			model.addAttribute("revues", new Revue());
		}
			return "/document/revue/index";
	}
}


