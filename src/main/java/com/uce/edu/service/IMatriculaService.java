package com.uce.edu.service;

import java.util.List;

import com.uce.edu.repository.modelo.Matricula;
import com.uce.edu.repository.modelo.dto.MatriculaDto;

public interface IMatriculaService {
	
	//public void guardar(String cedulaEstudiante,String mat1,String mat2,String mat3,String mat4);
	public List<MatriculaDto> buscarDto();
	public void matriculaParalela(MatriculaTO matriculaTO);
	public void matricularConCedulaCodigo(String cedula, String codigo, Matricula matricula);

}
