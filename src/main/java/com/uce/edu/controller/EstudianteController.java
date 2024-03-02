package com.uce.edu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.uce.edu.repository.modelo.Estudiante;
import com.uce.edu.service.IEstudianteService;

@Controller
@RequestMapping("estudiantes")
public class EstudianteController {

	@Autowired
	private IEstudianteService estudianteService;

	@PostMapping("/insertar")
	public String insertar(Estudiante estudiante) {
		this.estudianteService.guardar(estudiante);
		return "redirect:/estudiantes/nuevoEstudiante";

	}

	// http://localhost:8080/estudiantes/nuevoEstudiante
	@GetMapping("/nuevoEstudiante")
	public String mostrarNuevaPersona(Model modelo, Estudiante estudiante) {
		modelo.addAttribute("estudiante", estudiante);
		return "vistaNuevoEstudiante";
	}

}
