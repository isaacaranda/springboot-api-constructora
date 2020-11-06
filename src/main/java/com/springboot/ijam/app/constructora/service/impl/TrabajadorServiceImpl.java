package com.springboot.ijam.app.constructora.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.ijam.app.constructora.model.Trabajador;
import com.springboot.ijam.app.constructora.repo.ITrabajadorRepo;
import com.springboot.ijam.app.constructora.service.ITrabajadorService;

@Service
public class TrabajadorServiceImpl implements ITrabajadorService{
	
	@Autowired
	private ITrabajadorRepo trabajadorRepo;

	@Override
	public Trabajador save(Trabajador obj) {
		return trabajadorRepo.save(obj);
	}

	@Override
	public Trabajador update(Trabajador obj) {
		return trabajadorRepo.save(obj);
	}

	@Override
	public List<Trabajador> all() {
		return trabajadorRepo.findAll();
	}

	@Override
	public Trabajador findById(Integer id) {
		return trabajadorRepo.findById(id).orElse(new Trabajador());
	}

	@Override
	public boolean deleteById(Integer id) {
		trabajadorRepo.deleteById(id);
		return true;
	}

}
