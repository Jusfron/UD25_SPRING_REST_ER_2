package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.Empleado;
import com.example.demo.service.EmpleadoServiceImpl;

@RestController
@RequestMapping("/api")
public class EmpleadoController {

	@Autowired
	EmpleadoServiceImpl empleadoServiceImpl;

	@GetMapping("/empleados")
	public List<Empleado> listarEmpleados() {
		return empleadoServiceImpl.listarEmpleados();
	}

	@PostMapping("/empleados")
	public Empleado salvarEmpleado(@RequestBody Empleado empleado) {

		return empleadoServiceImpl.guardarEmpleado(empleado);
	}

	@GetMapping("/empleados/{id}")
	public Empleado empleadoXID(@PathVariable(name = "id") Long id) {

		Empleado empleado_xid = new Empleado();

		empleado_xid = empleadoServiceImpl.empleadoXID(id);

		System.out.println("Empleado XID: " + empleado_xid);

		return empleado_xid;
	}

	@PutMapping("/empleados/{id}")
	public Empleado actualizarEmpleado(@PathVariable(name = "id") Long id, @RequestBody Empleado empleado) {

		Empleado empleado_seleccionado = new Empleado();
		Empleado empleado_actualizado = new Empleado();

		empleado_seleccionado = empleadoServiceImpl.empleadoXID(id);

		empleado_seleccionado.setNombre(empleado.getNombre());
		empleado_seleccionado.setApellidos(empleado.getApellidos());
		empleado_seleccionado.setDepartamento(empleado.getDepartamento());

		empleado_actualizado = empleadoServiceImpl.actualizarEmpleado(empleado_seleccionado);

		System.out.println("El empleado actualizado es: " + empleado_actualizado);

		return empleado_actualizado;
	}

	@DeleteMapping("/empleados/{id}")
	public String eliminarEmpleado(@PathVariable(name = "id") Long id) {
	try {
		empleadoServiceImpl.eliminarEmpleado(id);
		return "Empleado borrado";
	} catch (Exception e) {
		return e.getMessage();
	}
	}
}
