package com.uce.edu.repository;

import java.util.List;

import com.uce.edu.repository.modelo.Matricula;
import com.uce.edu.repository.modelo.dto.MatriculaDto;

public interface IMatriculaRepository {

	public void insertar(Matricula matricula);

	public List<MatriculaDto> seleccionarDto();

}
