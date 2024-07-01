/**
 * @author Nicolas Camacho Lesmes
 * ANALISIS Y DESARROLLO DE SOFTWARE FICHA 2721538
 */

package com.nico.petsprodshop.services;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nico.petsprodshop.models.Persona;

public interface PersonaRepository extends JpaRepository<Persona, Integer>{

}
