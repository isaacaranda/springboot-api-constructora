package com.springboot.ijam.app.constructora.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.ijam.app.constructora.model.Trabajador;

public interface ITrabajadorRepo extends JpaRepository<Trabajador, Integer> {
	
}
