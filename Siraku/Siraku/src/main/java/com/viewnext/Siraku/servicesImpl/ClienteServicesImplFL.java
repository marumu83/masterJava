package com.viewnext.Siraku.servicesImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.viewnext.Siraku.model.Cliente;
import com.viewnext.Siraku.modelFL.ClienteFL;
import com.viewnext.Siraku.repository.ClienteRepository;
import com.viewnext.Siraku.service.ClienteServices;

@Service
@Qualifier
@Primary
public class ClienteServicesImplFL implements ClienteServices{
	
	@Autowired
	private ClienteRepository clr;
	
	@Autowired
	private DozerBeanMapper mapper;	

	@Override
	public Cliente create(Cliente cliente) {
		Cliente createdCliente;
		if (cliente != null && cliente.getIdentificadorFiscal() != null) {
			createdCliente = mapper.map(clr.save(mapper.map(cliente, ClienteFL.class)), Cliente.class);
			return createdCliente;
		}else {
			return null;
		}
	}

	
	@Override
	public Cliente read(String identificadorFiscal) {
		ClienteFL clienteFLLeido = clr.findById(identificadorFiscal).orElse(null);
		System.out.println(clr.toString());
		if (clienteFLLeido != null) {
			return mapper.map(clienteFLLeido, Cliente.class);
		}else {
			return null;
		}
	}

	@Override
	public List<Cliente> getAll() {
		List<ClienteFL> clientesFL = clr.findAll();
		return clientesFL.stream().map(clienteFL -> mapper.map(clienteFL, Cliente.class)).toList();
	}

	@Override
	public List<Cliente> getByPoblacion(String poblacion) {
		List<ClienteFL> clientesFL = clr.findAll();
		return clientesFL.stream()
				.map(clienteFL -> mapper.map(clienteFL, Cliente.class))
				.filter(c -> c.getDireccion().getPoblacion() == poblacion)
				.collect(Collectors.toList());
	}

	@Override
	public List<Cliente> getByCodigoPostal(String codigoPostal) {
		List<ClienteFL> clientesFL = clr.findAll();
		return clientesFL.stream()
				.map(clienteFL -> mapper.map(clienteFL, Cliente.class))
				.filter(c -> c.getDireccion().getCodPostal() == codigoPostal)
				.collect(Collectors.toList());
	}

}
