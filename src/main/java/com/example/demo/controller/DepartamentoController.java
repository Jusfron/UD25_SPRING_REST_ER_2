package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.dto.Departamento;
import com.example.demo.service.DepartamentoServiceImpl;

@RestController
@RequestMapping("/api")
public class DepartamentoController {
	
	@Autowired
	DepartamentoServiceImpl departamentoServiceImpl;
	
	@GetMapping("/departamentos")
	public List<Departamento> listarDepartamentos() {
		return departamentoServiceImpl.listarDepartamentos();
	}
	
	@PostMapping("/departamentos")
	public Departamento salvarDepartamento(@RequestBody Departamento departamento) {
		return departamentoServiceImpl.guardarDepartamento(departamento);
	}

	@GetMapping("/departamentos/{id}")
	public Departamento departamentoXID(@PathVariable(name="id") Long id) {
		
		Departamento departamento_xid= new Departamento();
		
		departamento_xid=departamentoServiceImpl.departamentoXID(id);
		
		System.out.println("Departamento XID: "+departamento_xid);
		
		return departamento_xid;
	}
	
	@PutMapping("/departamentos/{id}")
	public Departamento actualizarDepartamento(@PathVariable(name="id")Long id,@RequestBody Departamento departamento) {
		
		Departamento departamento_seleccionado= new Departamento();
		Departamento departamento_actualizado= new Departamento();
		
		departamento_seleccionado= departamentoServiceImpl.departamentoXID(id);
		
		departamento_seleccionado.setNombre(departamento.getNombre());
		departamento_seleccionado.setPresupuesto(departamento.getPresupuesto());
		
		departamento_actualizado = departamentoServiceImpl.actualizarDepartamento(departamento_seleccionado);
		
		System.out.println("El departamento actualizado es: "+ departamento_actualizado);
		
		return departamento_actualizado;
	}
	
	@DeleteMapping("/departamentos/{id}")
	public String eliminarDepartamento(@PathVariable(name = "id") Long id) {
		try {
			departamentoServiceImpl.eliminarDepartamento(id);
			return "Departamento eliminado";
		} catch (Exception e) {
			return e.getMessage();
		}
	}
	
}
