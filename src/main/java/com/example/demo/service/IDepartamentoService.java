package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.Departamento;

public interface IDepartamentoService {
	
	//Metodos del CRUD
			public List<Departamento> listarDepartamentos(); //Listar All 
			
			public Departamento guardarDepartamento(Departamento departamento);	//Guarda un Departamento CREATE
			
			public Departamento departamentoXID(Long id); //Leer datos de un Departamento READ
			
			public Departamento actualizarDepartamento(Departamento departamento); //Actualiza datos del Departamento UPDATE
			
			public void eliminarDepartamento(Long id);// Elimina el Departamento DELETE

}
