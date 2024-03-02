package com.uce.edu.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.uce.edu.repository.modelo.Matricula;
import com.uce.edu.repository.modelo.dto.MatriculaDto;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import jakarta.transaction.Transactional.TxType;

@Transactional
@Repository
public class MatriculaRepositoryImpl implements IMatriculaRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	@Transactional(value = TxType.REQUIRED)
	public void insertar(Matricula matricula) {
		// TODO Auto-generated method stub
		this.entityManager.persist(matricula);
	}

	@Override
	@Transactional(value = TxType.NOT_SUPPORTED)
	public List<MatriculaDto> seleccionarDto() {
		// TODO Auto-generated method stub
		TypedQuery<MatriculaDto> query = this.entityManager.createQuery(
				"Select New com.uce.edu.repository.modelo.dto.MatriculaDto(e.cedula,ma.codigo,m.fecha,m.hilo)"
						+ "   From Matricula m " + "  JOIN m.estudiante e " + "  JOIN m.materia ma",
				MatriculaDto.class);
		return query.getResultList();
	}

}
