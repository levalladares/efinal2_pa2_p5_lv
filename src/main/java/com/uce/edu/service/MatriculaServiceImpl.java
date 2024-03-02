package com.uce.edu.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.repository.IEstudianteRepository;
import com.uce.edu.repository.IMateriaRepository;
import com.uce.edu.repository.IMatriculaRepository;
import com.uce.edu.repository.modelo.Estudiante;
import com.uce.edu.repository.modelo.Materia;
import com.uce.edu.repository.modelo.Matricula;
import com.uce.edu.repository.modelo.dto.MatriculaDto;

import jakarta.transaction.Transactional;
import jakarta.transaction.Transactional.TxType;

@Service
public class MatriculaServiceImpl implements IMatriculaService {

	@Autowired
	private IEstudianteRepository estudianteRepository;
	@Autowired
	private IMateriaRepository iMateriaRepository;
	@Autowired
	private IMatriculaRepository iMatriculaRepository;

	@Override
	@Transactional(value = TxType.REQUIRES_NEW)
	public void matriculaParalela(MatriculaTO matriculaTO) {
		Matricula m1 = new Matricula();
		m1.setFecha(LocalDate.now());
		Materia ma1 = new Materia();
		ma1.setCodigo(matriculaTO.getCod1());
		m1.setMateria(ma1);
		Matricula m2 = new Matricula();
		m2.setFecha(LocalDate.now());
		Materia ma2 = new Materia();
		ma2.setCodigo(matriculaTO.getCod2());
		m2.setMateria(ma2);
		Matricula m3 = new Matricula();
		m3.setFecha(LocalDate.now());
		Materia ma3 = new Materia();
		ma3.setCodigo(matriculaTO.getCod3());
		m3.setMateria(ma3);
		Matricula m4 = new Matricula();
		Materia ma4 = new Materia();
		ma4.setCodigo(matriculaTO.getCod4());
		m4.setMateria(ma4);

		List<Matricula> matriculas = new ArrayList<>();
		matriculas.add(m1);
		matriculas.add(m2);
		matriculas.add(m3);
		matriculas.add(m4);

		matriculas.parallelStream().forEach(matricula -> {
			String hilo = Thread.currentThread().getName();
			matricula.setHilo(hilo);
			this.matricularConCedulaCodigo(matriculaTO.getCedulaEstudiante(), matricula.getMateria().getCodigo(),
					matricula);
		});
	}

	@Override
	@Transactional(value = TxType.REQUIRES_NEW)
	public void matricularConCedulaCodigo(String cedula, String codigo, Matricula matricula) {
		Estudiante est = this.estudianteRepository.seleccionarPorCedula(cedula);
		Materia mat = this.iMateriaRepository.seleccionarPorCodigo(codigo);
		matricula.setEstudiante(est);
		matricula.setMateria(mat);
		matricula.setFecha(LocalDate.now());
		this.iMatriculaRepository.insertar(matricula);
	}

	@Override
	@Transactional(value = TxType.REQUIRES_NEW)
	public List<MatriculaDto> buscarDto() {
		// TODO Auto-generated method stub
		return this.iMatriculaRepository.seleccionarDto();
	}

}
