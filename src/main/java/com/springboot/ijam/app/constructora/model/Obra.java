package com.springboot.ijam.app.constructora.model;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "Entidad Obra")
@Entity
@Table(name = "obras")
public class Obra {

	@ApiModelProperty(hidden = true)
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idObra;

	@ApiModelProperty(notes = "Nombre debe tener minimo 5 caracteres", dataType = "String", example = "Proyecto Las Palmas", position = 1)
	@Size(min = 5, message = "Nombre debe tener minimo 5 caracteres")
	@Column(name = "nombre", nullable = false, length = 70)
	private String nombre;

	@ApiModelProperty(notes = "Direccion debe tener minimo 10 caracteres", dataType = "String", example = "Av. Direccion 1234", position = 2)
	@Size(min = 10, max = 150, message = "Direccion debe tener minimo 10 caracteres")
	@Column(name = "direccion", nullable = false, length = 150)
	private String direccion;

	@ApiModelProperty(notes = "Duracion del trabajo debe tener minimo 2 caracteres", dataType = "String", example = "2s", position = 3)
	@Size(min = 2, message = "Duracion del trabajo debe tener minimo 5 caracteres")
	@Column(name = "duracion", nullable = false, length = 5)
	private String duracion;

	@ApiModelProperty(hidden = true)
	@Column(name = "fecha_ingreso")
	@CreationTimestamp
	private LocalDateTime fechaIngreso;

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "id_cliente", nullable = false, foreignKey = @ForeignKey(name = "FK_cliente_obra"))
	private Cliente cliente;

	@ApiModelProperty(value = "Lista de los trabajadores asociados a la obra", position = 4)
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "obras_trabajadores", joinColumns = @JoinColumn(name = "id_obra", referencedColumnName = "idObra"), inverseJoinColumns = @JoinColumn(name = "id_trabajador", referencedColumnName = "idTrabajador"))
	private List<Trabajador> trabajadores;

	public Integer getIdObra() {
		return idObra;
	}

	public void setIdObra(Integer idObra) {
		this.idObra = idObra;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getDuracion() {
		return duracion;
	}

	public void setDuracion(String duracion) {
		this.duracion = duracion;
	}

	public LocalDateTime getFechaIngreso() {
		return fechaIngreso;
	}

	public void setFechaIngreso(LocalDateTime fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<Trabajador> getTrabajadores() {
		return trabajadores;
	}

	public void setTrabajadores(List<Trabajador> trabajadores) {
		this.trabajadores = trabajadores;
	}

}
