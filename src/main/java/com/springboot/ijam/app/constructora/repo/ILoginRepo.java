package com.springboot.ijam.app.constructora.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.springboot.ijam.app.constructora.model.Usuario;

public interface ILoginRepo extends JpaRepository<Usuario, Integer>{
	
	@Query("FROM Usuario u WHERE u.username = :usuario")
	Usuario verifyUsername(@Param("usuario") String usuario) throws Exception;
	
	@Transactional
	@Modifying
	@Query("UPDATE Usuario u SET u.password = :clave WHERE u.username = :nombre")
	void changePassword(@Param("clave") String clave, @Param("nombre") String nombre) throws Exception;
}
