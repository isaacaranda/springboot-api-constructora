package com.springboot.ijam.app.constructora.service;

import com.springboot.ijam.app.constructora.model.Usuario;

public interface ILoginService {
	Usuario verifyUsername(String usuario) throws Exception;
	int changePassword(String clave, String nombre) throws Exception;
}
