package com.uce.edu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.uce.edu.repository.modelo.Materia;
import com.uce.edu.service.IMateriaService;

@Controller
@RequestMapping("materias")
public class MateriaController {

	@Autowired
	private IMateriaService iMateriaService;

	@PostMapping("/insertar")
	public String insertar(Materia materia) {
		this.iMateriaService.guardar(materia);
		return "redirect:/materias/nuevaMateria";

	}

	// http://localhost:8080/materias/nuevaMateria
	@GetMapping("/nuevaMateria")
	public String mostrarNuevaPersona(Model modelo, Materia materia) {
		modelo.addAttribute("materia", materia);
		return "vistaNuevaMateria";
	}
}
