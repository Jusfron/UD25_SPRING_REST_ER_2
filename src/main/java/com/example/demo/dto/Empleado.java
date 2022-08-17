package com.example.demo.dto;

import javax.persistence.*;

@Entity
@Table(name="empleados")//en caso que la tabla sea diferente
public class Empleado {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "nombre")
	private String nombre;
	@Column(name = "apellidos")
	private String apellidos;
	
	@ManyToOne
    @JoinColumn(name="departamento")
	private Departamento departamento;

	public Empleado() {
		super();
	}
	
	public Empleado(Long id, String nombre, String apellidos, Departamento departamento) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.departamento = departamento;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public Departamento getDepartamento() {
		return departamento;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}
	
	

}
