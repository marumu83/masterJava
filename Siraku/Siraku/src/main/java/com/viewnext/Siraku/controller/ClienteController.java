package com.viewnext.Siraku.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.viewnext.Siraku.model.Cliente;
import com.viewnext.Siraku.service.ClienteServices;

@RestController
public class ClienteController {
	
	@Autowired
	private ClienteServices clienteService;
	
	@GetMapping("/clientes")
	public List<Cliente> getList(){
		return clienteService.getAll();
	}
	
	@GetMapping("/clientes/poblacion/{poblacion}")
	public List<Cliente> getListByPoblacion(String poblacion){
		if (poblacion != null) {
			return clienteService.getByPoblacion(poblacion);
		}else {
			return null;
		}
	}
	
	@GetMapping("/clientes/codigoPostal/{codigoPos}")
	public List<Cliente> getListByCodigoPostal(String codigoPos){
		if (codigoPos != null) {
			return clienteService.getByCodigoPostal(codigoPos);
		}else {
			return null;
		}
	}
	
	@GetMapping("/clientes/{identificadorFiscal}")
	public Cliente getByCodigo(@PathVariable String identificadorFiscal){
		if (identificadorFiscal != null) {
			return clienteService.read(identificadorFiscal);
		}else {
			return null;
		}
	}
	
	@PostMapping("clientes/create")
	public ResponseEntity<?> create(@RequestBody Cliente cliente, UriComponentsBuilder uriComponentsBuilder) {
		Cliente creadoCliente = clienteService.create(cliente);
		if (creadoCliente != null) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}else {
			MensajeError mensajeError = new MensajeError("Se debe poner un cliente con un identificador valido para insertar", 56667);
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(mensajeError);
		}
	}
}
