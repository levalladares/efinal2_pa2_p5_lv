package com.uce.edu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.uce.edu.repository.modelo.Matricula;
import com.uce.edu.repository.modelo.dto.MatriculaDto;
import com.uce.edu.service.IMatriculaService;
import com.uce.edu.service.MatriculaTO;

@Controller
@RequestMapping("matriculas")
public class MatriculaController {

	@Autowired
	private IMatriculaService iMatriculaService;

	@PostMapping(value = "/insertar")
	public String matricular(MatriculaTO matriculaTO) {
		this.iMatriculaService.matriculaParalela(matriculaTO);
		return "redirect:/matriculas/nuevaMatricula";
	}

	// http://localhost:8080/matriculas/nuevaMatricula
	@GetMapping("/nuevaMatricula")
	public String mostrarNuevaPersona(Model modelo,Matricula matricula) {
		modelo.addAttribute("matriculaTO",new MatriculaTO());
		return "vistaNuevaMatricula";
	}

	@GetMapping("/buscarTodos")
	public String buscarTodos(Model modelo) {
		List<MatriculaDto> lista = this.iMatriculaService.buscarDto();
		modelo.addAttribute("matriculas", lista);
		return "vistaListaMatriculas";
	}
}
