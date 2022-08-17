package com.example.demo.dto;

import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="departamentos")
public class Departamento {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "nombre")
	private String nombre;
	@Column(name = "presupuesto")
	private int presupuesto;
	
	@OneToMany
    @JoinColumn(name="id")
    private List<Empleado> empleados;

	public Departamento() {
		super();
	}

	public Departamento(Long id, String nombre, int presupuesto, List<Empleado> empleados) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.presupuesto = presupuesto;
		this.empleados = empleados;
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

	public int getPresupuesto() {
		return presupuesto;
	}

	public void setPresupuesto(int presupuesto) {
		this.presupuesto = presupuesto;
	}

	/**
	 * @return the video
	 */
	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "Empleado")
	public List<Empleado> getEmpleados() {
		return empleados;
	}

	public void setEmpleados(List<Empleado> empleados) {
		this.empleados = empleados;
	}

	@Override
	public String toString() {
		return "Fabricante [id=" + id + ", nombre=" + nombre + ", empleados=" + empleados + "]";
	}
	
	
	
}
