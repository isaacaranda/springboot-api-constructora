package com.springboot.ijam.app.constructora.controller;

import java.net.URI;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
import com.springboot.ijam.app.constructora.model.Cliente;
import com.springboot.ijam.app.constructora.service.IClienteService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;

@Api(value = "ClienteController", description = "API REST relacionada a la entidad Cliente", tags = "Cliente")
@RestController
@RequestMapping("/clientes")
public class ClienteController {
	
	@Autowired
	private IClienteService clienteService;
	
	@ApiOperation(value = "Obtener lista de Clientes")
	@ApiResponse(code = HttpServletResponse.SC_OK, message = "OK")
	@PreAuthorize("@authServiceImpl.hasAccess('all')")
	@GetMapping
	public ResponseEntity<List<Cliente>> clientes(){
		return new ResponseEntity<List<Cliente>>(clienteService.all(), HttpStatus.OK);
	} 

	@ApiOperation(value = "Buscar cliente por su ID")
	@PreAuthorize("@authServiceImpl.hasAccess('find')")
	@GetMapping("/{id}")
	public ResponseEntity<Cliente> findById(@PathVariable("id") Integer id){
		Cliente cliente = clienteService.findById(id);
		if (cliente.getIdCliente() == null) {
			throw new ModeloNotFoundException(String.format("ID %s del cliente, no encontrado.", id));
		}
		return new ResponseEntity<Cliente>(cliente, HttpStatus.OK);
	}
	
	@ApiOperation(value = "Obtener lista de Clientes Paginados")
	@PreAuthorize("@authServiceImpl.hasAccess('find')")
	@GetMapping("/pageable")
	public ResponseEntity<Page<Cliente>> clientesPage(Pageable pageable){
		Page<Cliente> clientes = clienteService.allPageable(pageable);
		return new ResponseEntity<Page<Cliente>>(clientes, HttpStatus.OK);
	}
	
	@ApiOperation(value = "Guardar Cliente")
	@PreAuthorize("@authServiceImpl.hasAccess('save')")
	@PostMapping
	public ResponseEntity<Object> save(@Valid @RequestBody Cliente cliente){
		Cliente cli = clienteService.save(cliente);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(cli.getIdCliente()).toUri();
		return ResponseEntity.created(location).build();
	}
	
	@ApiOperation(value = "Actualizar Cliente")
	@PreAuthorize("@authServiceImpl.hasAccess('update')")
	@PutMapping
	public ResponseEntity<Cliente> update(@Valid @RequestBody Cliente cliente){
		return new ResponseEntity<Cliente>(clienteService.update(cliente), HttpStatus.OK);
	}
	
	@ApiOperation(value = "Eliminar Cliente por el ID")
	@PreAuthorize("@authServiceImpl.hasAccess('delete')")
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> delete(@PathVariable("id") Integer id){
		Cliente cliente = clienteService.findById(id);
		if (cliente.getIdCliente() == null) {
			throw new ModeloNotFoundException(String.format("ID %s del cliente, no encontrado.", id));
		}
		clienteService.deleteById(id);
		return new ResponseEntity<Object>(HttpStatus.OK);
	}

}
