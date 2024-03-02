package com.uce.edu.service;

public class MatriculaTO {
	
	private String cedulaEstudiante;
	private String cod1;
	private String cod2;
	private String cod3;
	private String cod4;

	public MatriculaTO() {
		// TODO Auto-generated constructor stub
	}

	public MatriculaTO(String cedulaEstudiante, String cod1, String cod2, String cod3, String cod4) {
		super();
		this.cedulaEstudiante = cedulaEstudiante;
		this.cod1 = cod1;
		this.cod2 = cod2;
		this.cod3 = cod3;
		this.cod4 = cod4;
	}
	
	//get y set
	public String getCedulaEstudiante() {
		return cedulaEstudiante;
	}

	public void setCedulaEstudiante(String cedulaEstudiante) {
		this.cedulaEstudiante = cedulaEstudiante;
	}

	public String getCod1() {
		return cod1;
	}

	public void setCod1(String cod1) {
		this.cod1 = cod1;
	}

	public String getCod2() {
		return cod2;
	}

	public void setCod2(String cod2) {
		this.cod2 = cod2;
	}

	public String getCod3() {
		return cod3;
	}

	public void setCod3(String cod3) {
		this.cod3 = cod3;
	}

	public String getCod4() {
		return cod4;
	}

	public void setCod4(String cod4) {
		this.cod4 = cod4;
	}
	
	
	

}
