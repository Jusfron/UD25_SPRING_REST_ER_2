package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.Empleado;

public interface IEmpleadoService {
	
	//Metodos del CRUD
			public List<Empleado> listarEmpleados(); //Listar All 
			
			public Empleado guardarEmpleado(Empleado empleado);	//Guarda un Empleado CREATE
			
			public Empleado empleadoXID(Long id); //Leer datos de un Empleado READ
			
			public Empleado actualizarEmpleado(Empleado empleado); //Actualiza datos del Empleado UPDATE
			
			public void eliminarEmpleado(Long id);// Elimina el Empleado DELETE

}
