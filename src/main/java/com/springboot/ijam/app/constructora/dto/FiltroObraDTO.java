package com.springboot.ijam.app.constructora.dto;

import java.time.LocalDateTime;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "Obtiene una lista de obras las cuales se pueden filtrar por RUT, nombre completo o fecha")
public class FiltroObraDTO {
	
	@ApiModelProperty(value = "Rut del Cliente", dataType = "String", example = "11111111-1", position = 1)
	private String rut;
	
	@ApiModelProperty(value = "Nombre completo", dataType = "String", example = "Juan Pablo Correa Vazques", position = 2)
	private String nombreCompleto;
	
	@ApiModelProperty(value = "Fecha de busqueda", dataType = "LocalDateTime", position = 3)
	private LocalDateTime fecha;

	public String getRut() {
		return rut;
	}

	public void setRut(String rut) {
		this.rut = rut;
	}

	public String getNombreCompleto() {
		return nombreCompleto;
	}

	public void setNombreCompleto(String nombreCompleto) {
		this.nombreCompleto = nombreCompleto;
	}

	public LocalDateTime getFecha() {
		return fecha;
	}

	public void setFecha(LocalDateTime fecha) {
		this.fecha = fecha;
	}

}
