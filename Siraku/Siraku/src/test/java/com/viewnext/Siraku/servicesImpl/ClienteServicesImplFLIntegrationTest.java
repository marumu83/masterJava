package com.viewnext.Siraku.servicesImpl;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

import com.viewnext.Siraku.model.Cliente;
import com.viewnext.Siraku.model.DatosContacto;
import com.viewnext.Siraku.model.Direccion;

@SpringBootTest
@Sql(scripts = { "/data/h2/schema.sql", "/data/h2/data.sql" })
class ClienteServicesImplFLIntegrationTest {

	@Autowired
	private ClienteServicesImplFL clienteServices;

	@Test
	void testCreate() {
		// Arrange
		Direccion direccion1 = new Direccion("Direccion1", "Direccion1", "Dir1", "Direccion1", "Direccion1");
		DatosContacto datos1 = new DatosContacto("datos1", "datos1", "datos1");
		Cliente cliente1 = new Cliente("1a", "Cliente1", "Cliente1", "Cliente1", "Cliente1", direccion1, datos1, null);

		// Act
		Cliente clienteCreado = clienteServices.create(cliente1);

		// Assert
		assertNotNull(clienteCreado);
		assertEquals(cliente1.getIdentificadorFiscal(), clienteCreado.getIdentificadorFiscal());
		assertEquals(cliente1.getNombreComercial(), clienteCreado.getNombreComercial());
		assertEquals(cliente1.getNombre(), clienteCreado.getNombre());
		assertEquals(cliente1.getApellido1(), clienteCreado.getApellido1());
		assertEquals(cliente1.getApellido2(), clienteCreado.getApellido2());
		assertEquals(cliente1.getDireccion(), clienteCreado.getDireccion());
		assertEquals(cliente1.getDatosContacto(), clienteCreado.getDatosContacto());
		assertEquals(cliente1.getProductos(), clienteCreado.getProductos());
	}

	@Test
	void testRead() {
		// Arrange
		String idCliente = "12G";

		// Act
		Cliente clienteCreado = clienteServices.read(idCliente);

		// Assert
		assertNotNull(clienteCreado);
		assertNotNull(clienteCreado.getIdentificadorFiscal());
		assertNotNull(clienteCreado.getNombreComercial());
		assertNotNull(clienteCreado.getNombre());
		assertNotNull(clienteCreado.getApellido1());
		assertNotNull(clienteCreado.getApellido2());
		assertNotNull(clienteCreado.getDireccion());
		assertNotNull(clienteCreado.getDatosContacto());
	}

	@Test
	void testGetAll() {
		// Act
		List<Cliente> listaClientes = clienteServices.getAll();

		// Assert
		assertNotNull(listaClientes);
		assertEquals(3, listaClientes.size());
	}

	@Test
	void testGetByPoblacion() {
		// Arrange
		String poblacionCliente = "Plasencia";

		// Act
		List<Cliente> listaClientesByPoblacion = clienteServices.getByPoblacion(poblacionCliente);

		// Assert
		assertNotNull(listaClientesByPoblacion);
		assertEquals(1, listaClientesByPoblacion.size());
	}

	@Test
	void testGetByCodigoPostal() {
		// Arrange
		String codPostalCliente = "10005";

		// Act
		List<Cliente> listaClientesByPoblacion = clienteServices.getByCodigoPostal(codPostalCliente);

		// Assert
		assertNotNull(listaClientesByPoblacion);
		assertEquals(1, listaClientesByPoblacion.size());
	}

}
