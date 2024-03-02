package com.uce.edu.repository.modelo.dto;

import java.time.LocalDate;

public class MatriculaDto {

	private String cedulaEstudiante;
	private String codigoMateria;
	private LocalDate fechaMatricula;
	private String nombreHilo;
	
	public MatriculaDto() {
		// TODO Auto-generated constructor stub
	}

	public MatriculaDto(String cedulaEstudiante, String codigoMateria, LocalDate fechaMatricula, String nombreHilo) {
		super();
		this.cedulaEstudiante = cedulaEstudiante;
		this.codigoMateria = codigoMateria;
		this.fechaMatricula = fechaMatricula;
		this.nombreHilo = nombreHilo;
	}
	
	//get y set
	public String getCedulaEstudiante() {
		return cedulaEstudiante;
	}

	public void setCedulaEstudiante(String cedulaEstudiante) {
		this.cedulaEstudiante = cedulaEstudiante;
	}

	public String getCodigoMateria() {
		return codigoMateria;
	}

	public void setCodigoMateria(String codigoMateria) {
		this.codigoMateria = codigoMateria;
	}

	public LocalDate getFechaMatricula() {
		return fechaMatricula;
	}

	public void setFechaMatricula(LocalDate fechaMatricula) {
		this.fechaMatricula = fechaMatricula;
	}

	public String getNombreHilo() {
		return nombreHilo;
	}

	public void setNombreHilo(String nombreHilo) {
		this.nombreHilo = nombreHilo;
	}
	
	

	
}
