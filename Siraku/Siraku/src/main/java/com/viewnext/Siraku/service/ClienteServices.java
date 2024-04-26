package com.viewnext.Siraku.service;

import java.util.List;

import com.viewnext.Siraku.model.Cliente;

public interface ClienteServices {

	Cliente create(Cliente cliente);
	
	Cliente read(String identificadorFiscal);
	
	List<Cliente> getAll();
	
	List<Cliente> getByPoblacion(String poblacion);
	List<Cliente> getByCodigoPostal(String codigoPostal);
	
}
