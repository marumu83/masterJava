package com.viewnext.Siraku.servicesImpl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

import com.viewnext.Siraku.model.Comercial;

@SpringBootTest
@Sql(scripts = {"/data/h2/schema.sql", "/data/h2/data.sql"})
public class ComercialServicesImplFLIntegrationTest {
	
	@Autowired
	private ComercialServicesImplFL comercialServices;
	
	@Test
	void testCount() {
		// Act
		long totalComerciales = comercialServices.getNumeroTotalComerciales();
		
		// Assert
		assertEquals(3L, totalComerciales);
	}
	
	@Test
	void testFindAll() {
		// Act
		List<Comercial> listaComerciales = comercialServices.getAll();
		
		// Assert
		assertNotNull(listaComerciales);
		assertEquals(3L, listaComerciales.size());
	}
	
	@Test
	void testCreate() {
		// Arrange
		Comercial nuevoComercial = new Comercial(501L, "COMERCIAL NO2", "APELLIDO NO1", "APELLIDO NO2", null);
		
		// Act
		Comercial comercialCreado = comercialServices.create(nuevoComercial);
		
		// Assert
		assertNotNull(comercialCreado);
		assertEquals(nuevoComercial.getCodigo(), comercialCreado.getCodigo());
		assertEquals(nuevoComercial.getNombre(), comercialCreado.getNombre());
		assertEquals(nuevoComercial.getApellido1(), comercialCreado.getApellido1());
		assertEquals(nuevoComercial.getApellido2(), comercialCreado.getApellido2());
	}
	
	@Test
	void testRead() {
		// Arrange
		long idComercial = 1L;
		
		// Act
		Comercial comercialCreado = comercialServices.read(idComercial);
		
		// Assert
		assertNotNull(comercialCreado);
		assertNotNull(comercialCreado.getCodigo());
		assertNotNull(comercialCreado.getNombre());
		assertNotNull(comercialCreado.getApellido1());
		assertNotNull(comercialCreado.getApellido2());
	}
	
	@Test
	void testReadNegative() {
		// Arrange
		long idComercial = 1000000L;
		
		// Act
		Comercial comercialCreado = comercialServices.read(idComercial);
		
		// Assert
		assertNull(comercialCreado);
	}
	
	
}
