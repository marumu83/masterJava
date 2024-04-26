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

import com.viewnext.Siraku.dto.ComercialDTO1;
import com.viewnext.Siraku.model.Comercial;
import com.viewnext.Siraku.service.ComercialServices;

@RestController
public class ComercialController {
	
	@Autowired
	private ComercialServices comercialService;
	
	@PostMapping("/comerciales/create")
	public ResponseEntity<?> create(@RequestBody Comercial comercial, UriComponentsBuilder uriComponentsBuilder) {
		Comercial createdComercial = comercialService.create(comercial);
		if (createdComercial != null) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}else {
			MensajeError mensajeError = new MensajeError("Se debe poner un comercial valido para insertar", 56667);
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(mensajeError);
		}
	}
	
	@GetMapping("/comerciales/{codigo}")
	public Comercial getByCodigo(@PathVariable Long codigo) {
		if (codigo != null) {
			return comercialService.read(codigo);
		}else {
			return null;
		}
	}
	
	@GetMapping("/comerciales")
	public List<Comercial> getList(){
		return comercialService.getAll();
	}
	
	@GetMapping("/comerciales/numero")
	public int getNmberOfComercials() {
		return comercialService.getNumeroTotalComerciales();
	}
	
	@GetMapping("/comercialesDto")
	public List<ComercialDTO1> getComercialesDto() {
		return comercialService.getComercialesDTO1();
	}
}
