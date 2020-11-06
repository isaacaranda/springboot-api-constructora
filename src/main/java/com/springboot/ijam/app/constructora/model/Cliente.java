package com.springboot.ijam.app.constructora.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

import org.hibernate.annotations.CreationTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "Entidad Cliente")
@Entity
@Table(name = "clientes")
public class Cliente {

	@ApiModelProperty(hidden = true)
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idCliente;
	
	@ApiModelProperty(notes = "Nombres debe tener minimo 5 caracteres", dataType = "String", example = "Juan Pablo", position = 1)
	@Size(min = 5, message = "Nombres debe tener minimo 5 caracteres")
	@Column(name = "nombres", nullable = false, length = 70)
	private String nombres;

	@ApiModelProperty(notes = "Apellidos debe tener minimo 5 caracteres", dataType = "String", example = "Correa Vazques", position = 2)
	@Size(min = 5, message = "Apellidos debe tener minimo 5 caracteres")
	@Column(name = "apellidos", nullable = false, length = 70)
	private String apellidos;

	@ApiModelProperty(notes = "RUT debe tener min 9 caracteres" , dataType = "String", example = "11111111-1", position = 3)
	@Size(min = 9, max = 10, message = "RUT debe tener min 9 caracteres")
	@Column(name = "rut", nullable = false, length = 10, unique = true)
	private String rut;

	@ApiModelProperty(notes = "Direccion debe tener minimo 10 caracteres", dataType = "String", example = "Direccion Obra 1234", position = 4)
	@Size(min = 10, max = 150, message = "Direccion debe tener minimo 10 caracteres")
	@Column(name = "direccion", nullable = false, length = 150)
	private String direccion;

	@ApiModelProperty(notes = "Telefono debe tener 9 caracteres", dataType = "String", example = "912345678", position = 5)
	@Size(min = 9, max = 9, message = "Telefono debe tener 9 caracteres")
	@Column(name = "telefono", nullable = false, length = 9)
	private String telefono;

	@ApiModelProperty(value = "Correo del Cliente", dataType = "String", example = "email@host.ex", position = 6)
	@Email
	@Column(name = "email", nullable = true, length = 50)
	private String email;

	@ApiModelProperty(hidden = true)
	@CreationTimestamp
	private LocalDateTime fechaIngreso;

	public Integer getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(Integer idCliente) {
		this.idCliente = idCliente;
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

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
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
