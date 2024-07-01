/**
 * @author Nicolas Camacho Lesmes
 * ANALISIS Y DESARROLLO DE SOFTWARE FICHA 2721538
 */

package com.nico.petsprodshop.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.nico.petsprodshop.models.Persona;
import com.nico.petsprodshop.models.PersonaDto;
import com.nico.petsprodshop.services.PersonaRepository;

import jakarta.validation.Valid;

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
	public String showCrearPersona(Model model) {
		PersonaDto personadto = new PersonaDto();
		model.addAttribute("personadto", personadto);
		return "personas/CreatePersona";
	}
	
	//Crear persona
	@PostMapping("/create")
	public String crearPersona(@Valid @ModelAttribute("personadto")
			PersonaDto personadto, BindingResult result) {
		if(result.hasErrors()) {
			return "personas/CreatePersona";
		}
		
		Persona persona = new Persona();
		persona.setCiudad(personadto.getCiudad());
		persona.setCorreo_electronico(personadto.getCorreo_electronico());
		persona.setDireccion(personadto.getDireccion());
		persona.setIdentificacion(personadto.getIdentificacion());
		persona.setNombre(personadto.getNombre());
		persona.setTelefono(personadto.getTelefono());
		
		repo.save(persona);
		
		return "redirect:/personas";
	}
	
	//Actualizar persona
	@GetMapping("/edit")
	public String showPaginaEditar(Model model, @RequestParam int id) {
		try {
			Persona persona = repo.findById(id).get();
			model.addAttribute("persona",persona);
			
			PersonaDto personadto = new PersonaDto();
			personadto.setCiudad(persona.getCiudad());
			personadto.setCorreo_electronico(persona.getCorreo_electronico());
			personadto.setDireccion(persona.getDireccion());
			personadto.setIdentificacion(persona.getIdentificacion());
			personadto.setNombre(persona.getNombre());
			personadto.setTelefono(persona.getTelefono());
			
			model.addAttribute("personadto",personadto);
			
			
			
		} catch (Exception e) {
			System.out.println("Exception: " +e.getMessage());
			return "redirect:/personas";
		}
		return "personas/EditarPersona";
	}
	
	//Metodo para actualizar la informacion de la persona
	@PostMapping("/edit")
	public String actualizarPersona(Model model, @RequestParam int id, 
			@Valid @ModelAttribute("personadto") PersonaDto personadto, 
			BindingResult result) {
		
		try {
			Persona persona = repo.findById(id).get();
			model.addAttribute("persona",persona);
			
			if(result.hasErrors()) {
				return "personas/EditarPersona";
			}
			persona.setCiudad(personadto.getCiudad());
			persona.setCorreo_electronico(personadto.getCorreo_electronico());
			persona.setDireccion(personadto.getDireccion());
			persona.setIdentificacion(personadto.getIdentificacion());
			persona.setNombre(personadto.getNombre());
			persona.setTelefono(personadto.getTelefono());
			
			repo.save(persona);
			
		} catch (Exception e) {
			System.out.println("Exception: " +e.getMessage());
		}
		
		return "redirect:/personas";
	}
	
	//Metodo para borrar persona por ID
	@GetMapping("/delete")
	public String eliminarPersona(@RequestParam int id) {
		try {
			Persona persona = repo.findById(id).get();
			
			repo.delete(persona);
			
		} catch (Exception e) {
			System.out.println("Exception: "+e.getMessage());
		}
		
		return "redirect:/personas";
	}
	
}
