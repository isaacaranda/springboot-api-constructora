package com.springboot.ijam.app.constructora.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;

import org.hibernate.annotations.CreationTimestamp;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "Entidad Trabajador")
@Entity
@Table(name = "trabajadores")
public class Trabajador {

	@ApiModelProperty(value = "Identificador", dataType = "Integer")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idTrabajador;
	
	@ApiModelProperty(notes = "Nombres debe tener minimo 5 caracteres", dataType = "String", example = "Juan Pablo", position = 1)
	@Column(name = "nombres", nullable = false, length = 70)
	private String nombres;
	
	@ApiModelProperty(notes = "Apellidos debe tener minimo 5 caracteres", dataType = "String", example = "Correa Vazques", position = 2)
	@Column(name = "apellidos", nullable = false, length = 70)
	private String apellidos;
	
	@ApiModelProperty(notes = "RUT debe tener min 9 caracteres" , dataType = "String", example = "11111111-1", position = 3)
	@Column(name = "rut", nullable = false, length = 10, unique = true)
	private String rut;
	
	@ApiModelProperty(value = "Correo del Cliente", dataType = "String", example = "email@host.ex", position = 4)
	@Email
	@Column(name = "email", nullable = true, length = 50)
	private String email;
	
	@ApiModelProperty(hidden = true)
	@Column(name = "fecha_ingreso")
	@CreationTimestamp
	private LocalDateTime fechaIngreso;

	public Integer getIdTrabajador() {
		return idTrabajador;
	}

	public void setIdTrabajador(Integer idTrabajador) {
		this.idTrabajador = idTrabajador;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getRut() {
		return rut;
	}

	public void setRut(String rut) {
		this.rut = rut;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public LocalDateTime getFechaIngreso() {
		return fechaIngreso;
	}

	public void setFechaIngreso(LocalDateTime fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}
	
}