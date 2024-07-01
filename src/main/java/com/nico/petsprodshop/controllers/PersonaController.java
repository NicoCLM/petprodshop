/**
 * @author Nicolas Camacho Lesmes
 * ANALISIS Y DESARROLLO DE SOFTWARE FICHA 2721538
 */

package com.nico.petsprodshop.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nico.petsprodshop.models.Persona;
import com.nico.petsprodshop.models.PersonaDto;
import com.nico.petsprodshop.services.PersonaRepository;

@Controller
@RequestMapping("/personas")
public class PersonaController {

	@Autowired
	private PersonaRepository repo;
	
	@GetMapping({"","/"})
	public String listarPersonas(Model model) {
		List<Persona> personas = repo.findAll();
		model.addAttribute("personas", personas);
		return "personas/index";
	}
	
	@GetMapping("/create")
	public String crearPersona(Model model) {
		PersonaDto personadto = new PersonaDto();
		model.addAttribute("personadto", personadto);
		return "personas/CreatePersona";
	}
}
