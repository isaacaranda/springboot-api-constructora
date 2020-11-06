package com.springboot.ijam.app.constructora.service.impl;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl {
	
	public boolean hasAccess(String path) {
		boolean rpta = false;
		String metodoRol = "";
		
		switch (path) {
		case "all":
			metodoRol = "ADMIN,USER,DBA,DEV";
			break;
		case "find":
			metodoRol = "ADMIN,USER,DBA,DEV";
			break;
		case "save":
			metodoRol = "ADMIN,USER,DEV";
			break;
		case "update":
			metodoRol = "ADMIN";
			break;
		case "delete":
			metodoRol = "ADMIN";
			break;
		}
		
		String metodoRoles[] = metodoRol.split(",");
		
		Authentication usuarioLogueado = SecurityContextHolder.getContext().getAuthentication();
		for (GrantedAuthority auth : usuarioLogueado.getAuthorities()) {
			String rolUser = auth.getAuthority();
			for (String rolMet : metodoRoles) {
				if (rolUser.equalsIgnoreCase(rolMet)) {
					rpta = true;
				}
			}
		}
		return rpta;
	}
}
