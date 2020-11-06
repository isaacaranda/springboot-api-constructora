package com.springboot.ijam.app.constructora.service;

import java.util.List;

import com.springboot.ijam.app.constructora.dto.FiltroObraDTO;
import com.springboot.ijam.app.constructora.model.Obra;

public interface IObraService extends ICRUD<Obra>{
	
	List<Obra> findByRutByNombreCompleto(FiltroObraDTO dto);
	
	List<Obra> findDate(FiltroObraDTO dto);
	
}