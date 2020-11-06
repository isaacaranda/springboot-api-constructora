package com.springboot.ijam.app.constructora.repo;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.springboot.ijam.app.constructora.model.Obra;

public interface IObraRepo extends JpaRepository<Obra, Integer>{
	
	@Query("from Obra o where o.cliente.rut =:rut or LOWER(o.cliente.nombres) like %:nombreCompleto% or LOWER(o.cliente.apellidos) like %:nombreCompleto%")
	List<Obra> findByRutByNombreCompleto(@Param("rut") String rut, @Param("nombreCompleto") String nombreCompleto);
	
	@Query("from Obra o where o.fechaIngreso between :fechaConsulta and :fechaSiguiente")
	List<Obra> findDate(@Param("fechaConsulta") LocalDateTime fechaConsulta, @Param("fechaSiguiente") LocalDateTime fechaSiguiente);
	
}
