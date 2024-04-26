package com.viewnext.Siraku.servicesImpl;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.assertj.core.util.Arrays;
import org.dozer.DozerBeanMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.viewnext.Siraku.model.Comercial;
import com.viewnext.Siraku.modelFL.ComercialFL;
import com.viewnext.Siraku.repository.ComercialRepository;
import com.viewnext.Siraku.servicesImpl.ComercialServicesImplFL;

@ExtendWith(MockitoExtension.class)
class ComercialSrevicesImplFLTest {

	private ComercialFL comercialFL, comercialFL2, comercialFL3;
	private Comercial comercial, comercial2, comercial3;
	private List<ComercialFL> comercialesFL;
	
	@Mock
	private ComercialRepository comercialRepository;
	
	@Mock
	private DozerBeanMapper mapper;
	
	@InjectMocks
	private ComercialServicesImplFL comercialServices;
	
	private void initMocks() {
		comercialFL = new ComercialFL();
		comercialFL.setCodigo(100L);
		comercialFL.setNombre("Honorio");
		comercialFL.setApellido1("Martin");
		comercialFL.setApellido2("Salvador");

		comercialFL2 = new ComercialFL();
		comercialFL.setCodigo(101L);
		comercialFL.setNombre("Mario");
		comercialFL.setApellido1("Sanchez");
		comercialFL.setApellido2("Pilar");
		
		comercialFL3 = new ComercialFL();
		comercialFL.setCodigo(102L);
		comercialFL.setNombre("Francisco");
		comercialFL.setApellido1("Balonero");
		comercialFL.setApellido2("Pilar");
		
		comercial = new Comercial();
		comercial.setCodigo(100L);
		comercial.setNombre("Honorio");
		comercial.setApellido1("Martin");
		comercial.setApellido2("Salvador");
		
		comercial2 = new Comercial();
		comercialFL.setCodigo(101L);
		comercialFL.setNombre("Mario");
		comercialFL.setApellido1("Sanchez");
		comercialFL.setApellido2("Pilar");
		
		comercial3 = new Comercial();
		comercialFL.setCodigo(102L);
		comercialFL.setNombre("Francisco");
		comercialFL.setApellido1("Balonero");
		comercialFL.setApellido2("Pilar");
		
		comercialesFL = new ArrayList<>();
		
		comercialesFL.add(comercialFL);
		comercialesFL.add(comercialFL2);
		comercialesFL.add(comercialFL3);
	}
	
	@BeforeEach
	public void init() {
		initMocks();
	}
	
	@Test
	void testCreate() {
		
		// Arrange
		when(comercialRepository.save(comercialFL)).thenReturn(comercialFL);
		when(mapper.map(comercialFL, Comercial.class)).thenReturn(comercial);
		when(mapper.map(comercial, ComercialFL.class)).thenReturn(comercialFL);
		
		// Act
		Comercial comercialTestCreate = comercialServices.create(comercial);
		
		// Assert
		assertNotNull(comercialTestCreate);
		assertEquals(100L, comercialTestCreate.getCodigo());
		assertEquals("Honorio", comercialTestCreate.getNombre());
		assertEquals("Martin", comercialTestCreate.getApellido1());
		assertEquals("Salvador", comercialTestCreate.getApellido2());
	}

	@Test
	void testRead() {
		
		// Arrange
		when(comercialRepository.findById(100L)).thenReturn(Optional.of(comercialFL));
		when(mapper.map(comercialFL, Comercial.class)).thenReturn(comercial);
		
		// Act
		Comercial comercialTestRead = comercialServices.read(100L);
		
		// Assert
		assertNotNull(comercialTestRead);
		assertEquals(100L, comercialTestRead.getCodigo());
		assertEquals("Honorio", comercialTestRead.getNombre());
		assertEquals("Martin", comercialTestRead.getApellido1());
		assertEquals("Salvador", comercialTestRead.getApellido2());
	}
	
	@Test
	void testReadNegative() {
		
		// Arrange
		when(comercialRepository.findById(100L)).thenReturn(Optional.empty());
		
		// Act
		Comercial comercialTestRead = comercialServices.read(100L);
		
		// Assert
		assertNull(comercialTestRead);
	}

	@Test
	void testGetAll() {
		// Arrange
		when(comercialRepository.findAll()).thenReturn(comercialesFL);
		when(mapper.map(comercialFL, Comercial.class)).thenReturn(comercial);
		when(mapper.map(comercialFL2, Comercial.class)).thenReturn(comercial2);
		when(mapper.map(comercialFL3, Comercial.class)).thenReturn(comercial3);
		
		// Act
		List<Comercial> comercialesTestGetAll = comercialServices.getAll();
		
		// Assert
		assertNotNull(comercialesTestGetAll);
		assertEquals(3, comercialesTestGetAll.size());
		
		assertTrue(comercialesTestGetAll.contains(comercial));
		assertTrue(comercialesTestGetAll.contains(comercial2));
		assertTrue(comercialesTestGetAll.contains(comercial3));
	}

	@Test
	void testGetNumeroTotalComerciales() {
		// Arrange
		when(comercialRepository.count()).thenReturn(239L);
		
		// Act
		int numerototalComerciales = comercialServices.getNumeroTotalComerciales();
		
		// Assert
		assertEquals(239, numerototalComerciales);
	}

}
