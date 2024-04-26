package com.viewnext.Siraku.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.viewnext.Siraku.model.Familia;
import com.viewnext.Siraku.model.Producto;
import com.viewnext.Siraku.service.ProductoServices;

@RestController
public class ProductoController {
	
	@Autowired
	private ProductoServices productoServices;
	
	@GetMapping("productos/{codigo}")
	public Producto getByCodigo(@PathVariable Long codigo){
		return productoServices.read(codigo);
	}
	
	@GetMapping("/productos")
	public List<Producto> getList(@RequestParam(value = "familia", required = false) Familia familia){
		
		List<Producto> productos = null;
		
		if(familia == null) {
			productos = productoServices.getAll();
		} else {
			productos = productoServices.getByFamilia(familia);
		}
		
		return productos;
	}

	@PostMapping("/productos/create")
	public Producto create(@RequestBody Producto producto, UriComponentsBuilder uriComponentsBuilder) {
		Producto createdProducto = productoServices.create(producto);
		return createdProducto;
	}
	
	@DeleteMapping("productos/delete/{codigo}")
	public ResponseEntity<?> delete(@PathVariable Long codigo) {
		boolean success = productoServices.delete(codigo);
		if (success) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}else {
			MensajeError mensajeError = new MensajeError("No existe el producto " + codigo, 56667);
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(mensajeError);
		}
	}
	
	@PutMapping("/productos/update")
	public  ResponseEntity<?> update(@RequestBody Producto producto){
		try {
			Producto updatedProducto = productoServices.update(producto);
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}catch(Exception e) {
			MensajeError mensajeError = new MensajeError("No existe el producto " + producto.getCodigo(), 56667);
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(mensajeError);
		}
	}
	
}
