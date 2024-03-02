package com.uce.edu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.repository.IMateriaRepository;
import com.uce.edu.repository.modelo.Materia;

import jakarta.transaction.Transactional;
import jakarta.transaction.Transactional.TxType;

@Service
public class MateriaServiceImpl implements IMateriaService {

	@Autowired
	private IMateriaRepository iMateriaRepository;
	@Override
	@Transactional(value = TxType.REQUIRES_NEW)
	public void guardar(Materia materia) {
		// TODO Auto-generated method stub
		this.iMateriaRepository.insertar(materia);
	}
	@Override
	@Transactional(value = TxType.REQUIRES_NEW)
	public Materia buscarPorCodigo(String codigo) {
		// TODO Auto-generated method stub
		return this.iMateriaRepository.seleccionarPorCodigo(codigo);
	}

}
