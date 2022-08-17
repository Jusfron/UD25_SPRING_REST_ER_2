package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.IDepartamentoDAO;
import com.example.demo.dto.Departamento;

@Service
public class DepartamentoServiceImpl implements IDepartamentoService{
	
	@Autowired
	IDepartamentoDAO iDepartamentoDAO;

	@Override
	public List<Departamento> listarDepartamentos() {
		// TODO Auto-generated method stub
		return iDepartamentoDAO.findAll();
	}

	@Override
	public Departamento guardarDepartamento(Departamento departamento) {
		// TODO Auto-generated method stub
		return iDepartamentoDAO.save(departamento);
	}

	@Override
	public Departamento departamentoXID(Long id) {
		// TODO Auto-generated method stub
		return iDepartamentoDAO.findById(id).get();
	}

	@Override
	public Departamento actualizarDepartamento(Departamento departamento) {
		// TODO Auto-generated method stub
		return iDepartamentoDAO.save(departamento);
	}

	@Override
	public void eliminarDepartamento(Long id) {
		// TODO Auto-generated method stub
		iDepartamentoDAO.deleteById(id);
	}

}
