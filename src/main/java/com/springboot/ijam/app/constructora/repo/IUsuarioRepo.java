package com.springboot.ijam.app.constructora.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.ijam.app.constructora.model.Usuario;

public interface IUsuarioRepo extends JpaRepository<Usuario, Integer>{
	Usuario findOneByUsername(String username);
}
