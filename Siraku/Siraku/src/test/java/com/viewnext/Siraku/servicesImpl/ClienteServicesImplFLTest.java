package com.viewnext.Siraku.servicesImpl;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.dozer.DozerBeanMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.viewnext.Siraku.model.Cliente;
import com.viewnext.Siraku.model.DatosContacto;
import com.viewnext.Siraku.model.Direccion;
import com.viewnext.Siraku.modelFL.ClienteFL;
import com.viewnext.Siraku.modelFL.DatosContactoFL;
import com.viewnext.Siraku.modelFL.DireccionFL;
import com.viewnext.Siraku.repository.ClienteRepository;

@ExtendWith(MockitoExtension.class)
class ClienteServicesImplFLTest {

	private Direccion direccion1,direccion2;
	private DireccionFL direccionFL1,direccionFL2;
	private DatosContacto datos1,datos2;
	private DatosContactoFL datosFL1,datosFL2;
	private ClienteFL clienteFL1, clienteFL2;
	private Cliente cliente1, cliente2;
	private List<ClienteFL> clientesFL;
	
	@Mock
	private ClienteRepository clienteRepository;
	
	@Mock
	private DozerBeanMapper mapper;
	
	@InjectMocks
	private ClienteServicesImplFL clienteServices;
	
	private void initMocks() {
		clientesFL = new ArrayList<>();
		
		direccion1 = new Direccion("Direccion1", "Direccion1","Direccion1","Direccion1","Direccion1");
		direccion2 = new Direccion("Direccion2", "Direccion2","Direccion2","Direccion2","Direccion2");
		
		datos1 = new DatosContacto("datos1", "datos1", "datos1");
		datos2 = new DatosContacto("datos2", "datos2", "datos2");
		
		cliente1 = new Cliente("1a", "Cliente1", "Cliente1", "Cliente1", "Cliente1", direccion1, datos1, null);
		cliente2 = new Cliente("2a", "Cliente2", "Cliente2", "Cliente2", "Cliente2", direccion2, datos2, null);
		
		direccionFL1 = new DireccionFL("DireccionFL1", "DireccionFL1","DireccionFL1","DireccionFL1","DireccionFL1");
		direccionFL2 = new DireccionFL("DireccionFL2", "DireccionFL2","DireccionFL2","DireccionFL2","DireccionFL2");
		
		datosFL1 = new DatosContactoFL("datosFL1", "datosFL1", "datosFL1");
		datosFL2 = new DatosContactoFL("datosFL2", "datosFL2", "datosFL2");
		
		clienteFL1 = new ClienteFL("1a", "Cliente1", "Cliente1", "Cliente1", "Cliente1", direccionFL1, datosFL1, null);
		clienteFL2 = new ClienteFL("2a", "Cliente2", "Cliente2", "Cliente2", "Cliente2", direccionFL2, datosFL2, null);
		
		clientesFL.add(clienteFL1);
		clientesFL.add(clienteFL2);
	}
	
	@BeforeEach
	public void init() {
		initMocks();
	}

	@Test
	void testCreate() {
		// Arrange
		when(clienteRepository.save(clienteFL1)).thenReturn(clienteFL1);
		when(mapper.map(clienteFL1, Cliente.class)).thenReturn(cliente1);
		when(mapper.map(cliente1, ClienteFL.class)).thenReturn(clienteFL1);
		
		// Act
		Cliente clienteCreateTest = clienteServices.create(cliente1);
		
		//Assert
		assertNotNull(clienteCreateTest);
		assertEquals("1a", clienteCreateTest.getIdentificadorFiscal());
		assertEquals("Cliente1", clienteCreateTest.getNombreComercial());
		assertEquals("Cliente1", clienteCreateTest.getNombre());
		assertEquals("Cliente1", clienteCreateTest.getApellido1());
		assertEquals("Cliente1", clienteCreateTest.getApellido2());
		assertEquals(direccion1, clienteCreateTest.getDireccion());
		assertEquals(datos1, clienteCreateTest.getDatosContacto());
	}

	@Test
	void testRead() {
		// Arrange
		when(clienteRepository.findById("1a")).thenReturn(Optional.of(clienteFL1));
		when(mapper.map(clienteFL1, Cliente.class)).thenReturn(cliente1);
		
		// Act
		Cliente clienteReadTest = clienteServices.read("1a");
		
		//Assert
		assertNotNull(clienteReadTest);
		assertEquals("1a", clienteReadTest.getIdentificadorFiscal());
		assertEquals("Cliente1", clienteReadTest.getNombreComercial());
		assertEquals("Cliente1", clienteReadTest.getNombre());
		assertEquals("Cliente1", clienteReadTest.getApellido1());
		assertEquals("Cliente1", clienteReadTest.getApellido2());
		assertEquals(direccion1, clienteReadTest.getDireccion());
		assertEquals(datos1, clienteReadTest.getDatosContacto());
	}

	@Test
	void testGetAll() {
		// Arrange
		when(clienteRepository.findAll()).thenReturn(clientesFL);
		when(mapper.map(clienteFL1, Cliente.class)).thenReturn(cliente1);
		when(mapper.map(clienteFL2, Cliente.class)).thenReturn(cliente2);
		
		// Act
		List<Cliente> listaClientesGetAllTest = clienteServices.getAll();
		
		//Assert
		assertNotNull(listaClientesGetAllTest);
		assertEquals(2, listaClientesGetAllTest.size());
		assertTrue(listaClientesGetAllTest.contains(cliente1));
		assertTrue(listaClientesGetAllTest.contains(cliente2));
	}

	@Test
	void testGetByPoblacion() {
		// Arrange
		when(clienteRepository.findAll()).thenReturn(clientesFL);
		when(mapper.map(clienteFL1, Cliente.class)).thenReturn(cliente1);
		when(mapper.map(clienteFL2, Cliente.class)).thenReturn(cliente2);
		
		// Act
		List<Cliente> listaClientesByPoblacionTest = clienteServices.getByPoblacion(direccion1.getPoblacion());
		
		//Assert
		assertNotNull(listaClientesByPoblacionTest);
		assertEquals(1, listaClientesByPoblacionTest.size());
		assertTrue(listaClientesByPoblacionTest.contains(cliente1));
	}

	@Test
	void testGetByCodigoPostal() {
		// Arrange
		when(clienteRepository.findAll()).thenReturn(clientesFL);
		when(mapper.map(clienteFL1, Cliente.class)).thenReturn(cliente1);
		when(mapper.map(clienteFL2, Cliente.class)).thenReturn(cliente2);
		
		// Act
		List<Cliente> listaClientesByPoblacionTest = clienteServices.getByCodigoPostal(direccion1.getCodPostal());
		
		//Assert
		assertNotNull(listaClientesByPoblacionTest);
		assertEquals(1, listaClientesByPoblacionTest.size());
		assertTrue(listaClientesByPoblacionTest.contains(cliente1));
	}

}
