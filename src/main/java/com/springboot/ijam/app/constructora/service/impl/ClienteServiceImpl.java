package com.springboot.ijam.app.constructora.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.springboot.ijam.app.constructora.model.Cliente;
import com.springboot.ijam.app.constructora.repo.IClienteRepo;
import com.springboot.ijam.app.constructora.service.IClienteService;

@Service
public class ClienteServiceImpl implements IClienteService{
	
	@Autowired
	private IClienteRepo clienteRepo;

	@Override
	public Cliente save(Cliente obj) {
		return clienteRepo.save(obj);
	}

	@Override
	public Cliente update(Cliente obj) {
		return clienteRepo.save(obj);
	}

	@Override
	public List<Cliente> all() {
		return clienteRepo.findAll();
	}

	@Override
	public Cliente findById(Integer id) {
		return clienteRepo.findById(id).orElse(new Cliente());
	}

	@Override
	public boolean deleteById(Integer id) {
		clienteRepo.deleteById(id);
		return true;
	}

	@Override
	public Page<Cliente> allPageable(Pageable pageable) {
		return clienteRepo.findAll(pageable);
	}

	@Override
	public Cliente findByRut(String rut) {
		return clienteRepo.findByRut(rut);
	}
}
