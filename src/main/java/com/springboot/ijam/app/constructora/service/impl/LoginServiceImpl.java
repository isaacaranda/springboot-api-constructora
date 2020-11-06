package com.springboot.ijam.app.constructora.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.ijam.app.constructora.model.Usuario;
import com.springboot.ijam.app.constructora.repo.ILoginRepo;
import com.springboot.ijam.app.constructora.service.ILoginService;

@Service
public class LoginServiceImpl implements ILoginService {
	
	@Autowired
	private ILoginRepo loginRepo;

	@Override
	public Usuario verifyUsername(String usuario) throws Exception {
		Usuario user = null;
		try {
			user = loginRepo.verifyUsername(usuario);
			user = user != null ? user : new Usuario();
		} catch (Exception e) {
			user = new Usuario();
		}
		return user;
	}

	@Override
	public int changePassword(String clave, String nombre) throws Exception {
		int rpta = 0;
		try {
			loginRepo.changePassword(clave, nombre);
			rpta = 1;
		} catch (Exception e) {
			rpta = 0;
		}
		return rpta;
	}

}
