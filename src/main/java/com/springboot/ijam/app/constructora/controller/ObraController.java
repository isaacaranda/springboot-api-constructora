package com.springboot.ijam.app.constructora.controller;

import java.net.URI;
import java.util.ArrayList;
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

import com.springboot.ijam.app.constructora.dto.FiltroObraDTO;
import com.springboot.ijam.app.constructora.dto.ObraClienteDTO;
import com.springboot.ijam.app.constructora.exception.ModeloNotFoundException;
import com.springboot.ijam.app.constructora.model.Cliente;
import com.springboot.ijam.app.constructora.model.Obra;
import com.springboot.ijam.app.constructora.service.IClienteService;
import com.springboot.ijam.app.constructora.service.IObraService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;

@Api(value = "ObraController", description = "API REST relacionada a la entidad Obra", tags = "Obra")
@RestController
@RequestMapping("/obras")
public class ObraController {

	@Autowired
	private IObraService obraService;
	
	@Autowired
	private IClienteService clienteService;
	
	@ApiOperation(value = "Obtener lista de Obras")
	@ApiResponse(code = HttpServletResponse.SC_OK, message = "OK")
	@PreAuthorize("@authServiceImpl.hasAccess('all')")
	@GetMapping
	public ResponseEntity<List<Obra>> all(){
		return new ResponseEntity<List<Obra>>(obraService.all(), HttpStatus.OK);
	}
	
	@ApiOperation(value = "Buscar obra por su ID")
	@PreAuthorize("@authServiceImpl.hasAccess('find')")
	@GetMapping("/{id}")
	public ResponseEntity<Obra> findById(@PathVariable("id") Integer id){
		Obra obra = obraService.findById(id);
		if (obra.getIdObra() == null) {
			throw new ModeloNotFoundException(String.format("ID %s de la obra, no encontrado.", id));
		}
		return new ResponseEntity<Obra>(obra, HttpStatus.OK);
	}
	
	@ApiOperation(value = "Guardar obra asociado a un Cliente por su RUT")
	@PreAuthorize("@authserviceImpl.hasAccess('save')")
	@PostMapping
	public ResponseEntity<Object> save(@Valid @RequestBody ObraClienteDTO obra){
		Cliente cli = clienteService.findByRut(obra.getRutCliente());
		if (cli.getIdCliente() == null) {
			throw new ModeloNotFoundException(String.format("Cliente con rut %s no encontrado", obra.getRutCliente()));
		}
		obra.getObra().setCliente(cli);
		Obra ob = obraService.save(obra.getObra());
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(ob.getIdObra()).toUri();
		return ResponseEntity.created(location).build();
	}
	
	@ApiOperation(value = "Obtener lista de Obras filtrando por fecha, nombre completo o RUT")
	@PreAuthorize("@authServiceImpl.hasAccess('find')")
	@PostMapping("/buscar")
	public ResponseEntity<List<Obra>> find(@RequestBody FiltroObraDTO dto){
		List<Obra> obras = new ArrayList<>();
		if (dto != null) {
			if (dto.getFecha() != null) {
				obras = obraService.findDate(dto);
			} else {
				obras = obraService.findByRutByNombreCompleto(dto);
			}
		}
		return new ResponseEntity<List<Obra>>(obras, HttpStatus.OK);
	}
	
	@ApiOperation(value = "Actualizar Obra")
	@PreAuthorize("@authServiceImpl.hasAccess('update')")
	@PutMapping
	public ResponseEntity<Obra> update(@Valid @RequestBody Obra obra){
		return new ResponseEntity<Obra>(obraService.update(obra), HttpStatus.OK);
	}
	
	@ApiOperation(value = "Eliminar Obra por el ID")
	@PreAuthorize("@authServiceImpl.hasAccess('delete')")
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> delete(@PathVariable("id") Integer id){
		Obra obra = obraService.findById(id);
		if (obra.getIdObra() == null) {
			throw new ModeloNotFoundException(String.format("ID %s de la obra, no encontrado", id));
		}
		obraService.deleteById(id);
		return new ResponseEntity<Object>(HttpStatus.OK);
	}
}