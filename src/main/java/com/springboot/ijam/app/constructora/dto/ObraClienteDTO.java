package com.springboot.ijam.app.constructora.dto;

import com.springboot.ijam.app.constructora.model.Obra;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "Informacion de una obra asociado a un cliente")
public class ObraClienteDTO {

	@ApiModelProperty(value = "Rut Cliente", dataType = "String", example = "11111111-1", position = 1)
	private String rutCliente;
	
	@ApiModelProperty(position = 2)
	private Obra obra;

	public String getRutCliente() {
		return rutCliente;
	}

	public void setRutCliente(String rutCliente) {
		this.rutCliente = rutCliente;
	}

	public Obra getObra() {
		return obra;
	}

	public void setObra(Obra obra) {
		this.obra = obra;
	}

}