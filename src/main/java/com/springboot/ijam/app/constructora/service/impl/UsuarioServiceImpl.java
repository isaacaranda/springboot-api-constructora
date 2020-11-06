package com.springboot.ijam.app.constructora.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.springboot.ijam.app.constructora.model.Usuario;
import com.springboot.ijam.app.constructora.repo.IUsuarioRepo;

@Service
public class UsuarioServiceImpl implements UserDetailsService {

	@Autowired
	private IUsuarioRepo usuarioRepo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Usuario usuario = usuarioRepo.findOneByUsername(username);
		
		if (usuario == null) {
			throw new UsernameNotFoundException(String.format("Usuario %s no existe", username));
		}
		
		List<GrantedAuthority> roles = new ArrayList<>();
		
		usuario.getRoles().forEach(rol -> {
			roles.add(new SimpleGrantedAuthority(rol.getNombre()));
		});
		
		UserDetails ud = new User(usuario.getUsername(), usuario.getPassword(), roles);
		return ud;
	}

}
