package com.springboot.ijam.app.constructora.controller;

import java.net.URI;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.springboot.ijam.app.constructora.exception.ModeloNotFoundException;
import com.springboot.ijam.app.constructora.model.Trabajador;
import com.springboot.ijam.app.constructora.service.ITrabajadorService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;

@Api(value = "TrabajadorController", description = "API Rest relacionado a la entidad Trabajador", tags = "Trabajador")
@RestController
@RequestMapping("/trabajadores")
public class TrabajadorController {

	@Autowired
	private ITrabajadorService trabajadorService;
	
	@ApiOperation(value = "Obtener lista de Trabajadores")
	@ApiResponse(code = HttpServletResponse.SC_OK, message = "OK")
	@PreAuthorize("@authServiceImpl.hasAccess('all')")
	@GetMapping
	public ResponseEntity<List<Trabajador>> all(){
		return new ResponseEntity<List<Trabajador>>(trabajadorService.all(), HttpStatus.OK);
	}
	
	@ApiOperation(value = "Buscar trabajador por su ID")
	@PreAuthorize("@authServiceImpl.hasAccess('find')")
	@GetMapping("/{id}")
	public ResponseEntity<Trabajador> findById(@PathVariable("id") Integer id){
		Trabajador trabajador = trabajadorService.findById(id);
		if (trabajador.getIdTrabajador() == null) {
			throw new ModeloNotFoundException(String.format("ID %s trabajador no encontrado", id));
		}
		return new ResponseEntity<Trabajador>(trabajador, HttpStatus.OK);
	}
	
	@ApiOperation(value = "Guardar Trabajador")
	@PreAuthorize("@authServiceImpl.hasAccess('save')")
	@PostMapping
	public ResponseEntity<Object> save(@Valid @RequestBody Trabajador trabajador){
		Trabajador tra = trabajadorService.save(trabajador);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(tra.getIdTrabajador()).toUri();
		return ResponseEntity.created(location).build();
	}
	
	@ApiOperation(value = "Actualizar Trabajador")
	@PreAuthorize("@authServiceImpl.hasAccess('update')")
	@PutMapping
	public ResponseEntity<Trabajador> update(@Valid @RequestBody Trabajador trabajador){
		return new ResponseEntity<Trabajador>(trabajadorService.update(trabajador), HttpStatus.OK);
	}
	
	@ApiOperation(value = "Eliminar Trabajador por el ID")
	@PreAuthorize("@authServiceImpl.hasAccess('delete')")
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> delete(@PathVariable("id") Integer id){
		Trabajador trabajador = trabajadorService.findById(id);
		if (trabajador.getIdTrabajador() == null) {
			throw new ModeloNotFoundException(String.format("ID %s del trabajador, no encontrado", id));
		}
		trabajadorService.deleteById(id);
		return new ResponseEntity<Object>(HttpStatus.OK);
	}
	
}
