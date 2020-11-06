package com.springboot.ijam.app.constructora.exception;

public class ModeloNotFoundException extends RuntimeException {
	
	public ModeloNotFoundException(String mensaje) {
		super(mensaje);
	}
}