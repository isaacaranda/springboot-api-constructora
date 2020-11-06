package com.springboot.ijam.app.constructora.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.springboot.ijam.app.constructora.model.Cliente;

public interface IClienteService extends ICRUD<Cliente>{
	Page<Cliente> allPageable(Pageable pageable);
	Cliente findByRut(String rut);
}
