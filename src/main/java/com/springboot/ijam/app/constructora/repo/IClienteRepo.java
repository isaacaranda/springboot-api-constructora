package com.springboot.ijam.app.constructora.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.ijam.app.constructora.model.Cliente;

public interface IClienteRepo extends JpaRepository<Cliente, Integer>{
	Cliente findByRut(String rut);
}
