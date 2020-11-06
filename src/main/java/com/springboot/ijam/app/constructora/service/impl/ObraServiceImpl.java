package com.springboot.ijam.app.constructora.service.impl;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.ijam.app.constructora.dto.FiltroObraDTO;
import com.springboot.ijam.app.constructora.model.Obra;
import com.springboot.ijam.app.constructora.repo.IObraRepo;
import com.springboot.ijam.app.constructora.service.IObraService;

@Service
public class ObraServiceImpl implements IObraService {
	
	@Autowired
	private IObraRepo obraRepo;
	
	@Override
	public Obra save(Obra obj) {
		return obraRepo.save(obj);
	}

	@Override
	public Obra update(Obra obj) {
		return obraRepo.save(obj);
	}

	@Override
	public List<Obra> all() {
		return obraRepo.findAll();
	}

	@Override
	public Obra findById(Integer id) {
		return obraRepo.findById(id).orElse(new Obra());
	}

	@Override
	public boolean deleteById(Integer id) {
		obraRepo.deleteById(id);
		return true;
	}

	@Override
	public List<Obra> findByRutByNombreCompleto(FiltroObraDTO dto) {
		return obraRepo.findByRutByNombreCompleto(dto.getRut(), dto.getNombreCompleto());
	}

	@Override
	public List<Obra> findDate(FiltroObraDTO dto) {
		LocalDateTime fechaSiguiente = dto.getFecha().plusDays(1);
		return obraRepo.findDate(dto.getFecha(), fechaSiguiente);
	}

}
