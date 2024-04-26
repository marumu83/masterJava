package com.viewnext.Siraku.servicesImpl;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.assertj.core.util.Arrays;
import org.dozer.DozerBeanMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.viewnext.Siraku.model.Cliente;
import com.viewnext.Siraku.model.Comercial;
import com.viewnext.Siraku.model.Familia;
import com.viewnext.Siraku.model.Producto;
import com.viewnext.Siraku.modelFL.ClienteFL;
import com.viewnext.Siraku.modelFL.ComercialFL;
import com.viewnext.Siraku.modelFL.ProductoFL;
import com.viewnext.Siraku.repository.ProductoRepository;

/**
 * @author Manuel Rubio
 * @author Ricardo David
 *
 */
@ExtendWith(MockitoExtension.class)
class ProductoServicesImplFlTest {
	
	private Producto producto1, producto2, producto3;
	private ProductoFL productoFL1, productoFL2, productoFL3;
	private List<ProductoFL> productosFL;
	private List<Producto> productos;
	private List<Cliente> listaClientes;
	private List<ClienteFL> listaClientesFL;
	private Familia familia1, familia2;
	private Comercial comercial1;
	private ComercialFL comercialFL1, comercialFL2;
	
	
	@Mock
	private ProductoRepository productoRepository;
	
	@Mock
	private DozerBeanMapper mapper;
	
	@InjectMocks
	private ProductoServicesImplFL productoServicesImplFL;
	
	private void initMocks() {
		
		producto1 = new Producto();
		producto1.setCodigo(1L);
		producto1.setNombre("producto1");
		producto1.setPrecio(100);
		producto1.setFechaAlta(Date.valueOf("2025-3-12"));
		producto1.setFamilia(familia1);
		producto1.setDescatalogado(false);
		producto1.setClientes(listaClientes);
		producto1.setComercial(comercial1);
		
		producto2 = new Producto();
		producto2.setCodigo(2L);
		producto2.setNombre("producto2");
		producto2.setPrecio(50);
		producto2.setFechaAlta(Date.valueOf("2025-3-12"));
		producto2.setFamilia(familia2);
		producto2.setDescatalogado(true);
		producto2.setClientes(listaClientes);
		producto2.setComercial(comercial1);
		
		producto3 = new Producto();
		producto3.setCodigo(3L);
		producto3.setNombre("producto3");
		producto3.setPrecio(150);
		producto3.setFechaAlta(Date.valueOf("2025-3-12"));
		producto3.setFamilia(familia1);
		producto3.setDescatalogado(false);
		producto3.setClientes(listaClientes);
		producto3.setComercial(comercial1);
		
		productos = new ArrayList<>();
		productos.add(producto1);
		productos.add(producto2);
		productos.add(producto3);
		
		productoFL1 = new ProductoFL();
		productoFL1.setCodigo(1L);
		productoFL1.setNombre("producto");
		productoFL1.setPrecio(100);
		productoFL1.setFechaAlta(Date.valueOf("2025-3-12"));
		productoFL1.setFamilia(familia1);
		productoFL1.setDescatalogado(false);
		productoFL1.setClientes(listaClientesFL);
		productoFL1.setComercial(comercialFL1);
		
		productoFL2 = new ProductoFL();
		productoFL2.setCodigo(2L);
		productoFL2.setNombre("producto2");
		productoFL2.setPrecio(50);
		productoFL2.setFechaAlta(Date.valueOf("2025-3-12"));
		productoFL2.setFamilia(familia1);
		productoFL2.setDescatalogado(true);
		productoFL2.setClientes(listaClientesFL);
		productoFL2.setComercial(comercialFL1);
		
		productoFL3 = new ProductoFL();
		productoFL3.setCodigo(3L);
		productoFL3.setNombre("producto3");
		productoFL3.setPrecio(150);
		productoFL3.setFechaAlta(Date.valueOf("2025-03-12"));
		productoFL3.setFamilia(familia1);
		productoFL3.setDescatalogado(false);
		productoFL3.setClientes(listaClientesFL);
		productoFL3.setComercial(comercialFL2);
		
		productosFL = new ArrayList<>();
		
		productosFL.add(productoFL1);
		productosFL.add(productoFL2);
		productosFL.add(productoFL3);	
		
	}
	
	@BeforeEach
	public void init() {
		initMocks();
	}

	/**
	 * Test method for {@link com.viewnext.Siraku.servicesImpl.ProductoServicesImplFL#create(com.viewnext.Siraku.model.Producto)}.
	 */
	@Test
	void testCreate() {
		
		when(productoRepository.save(productoFL1)).thenReturn(productoFL1);
		when(mapper.map(productoFL1, Producto.class)).thenReturn(producto1);
		when(mapper.map(producto1, ProductoFL.class)).thenReturn(productoFL1);
		
		Producto productoCreateTest = productoServicesImplFL.create(producto1);
	
		
		assertNotNull(productoCreateTest);
		assertEquals(1L, productoCreateTest.getCodigo());
		assertEquals("producto1", productoCreateTest.getNombre());
		assertEquals(100, productoCreateTest.getPrecio());
		assertEquals(familia1, productoCreateTest.getFamilia());
		assertEquals("2025-03-12", productoCreateTest.getFechaAlta().toString());
		assertEquals(listaClientes, productoCreateTest.getClientes());
		assertEquals(comercial1, productoCreateTest.getComercial());
		assertEquals(true, productoCreateTest.equals(productoCreateTest));
		
	}

	/**
	 * Test method for {@link com.viewnext.Siraku.servicesImpl.ProductoServicesImplFL#read(long)}.
	 */
	@Test
	void testRead() {
		
		when(productoRepository.findById(1L)).thenReturn(Optional.of(productoFL1));
		when(mapper.map(productoFL1,  Producto.class)).thenReturn(producto1);
		
		Producto productoTest = productoServicesImplFL.read(1L);
		
		assertNotNull(productoTest);

		
	}

	/**
	 * Test method for {@link com.viewnext.Siraku.servicesImpl.ProductoServicesImplFL#delete(long)}.
	 */
	@Test
	void testDelete() {
		
		
		when(productoRepository.existsById(1L)).thenReturn(true);

		//Act
		boolean test = productoServicesImplFL.delete(1L);

		//Assert
		assertTrue(test);
		
	}

	/**
	 * Test method for {@link com.viewnext.Siraku.servicesImpl.ProductoServicesImplFL#getAll()}.
	 */
	@Test
	void testGetAll() {
	
		// Arrange
		when(productoRepository.findAll()).thenReturn(productosFL);
		when(mapper.map(productoFL1, Producto.class)).thenReturn(producto1);
		when(mapper.map(productoFL2, Producto.class)).thenReturn(producto2);
		when(mapper.map(productoFL3, Producto.class)).thenReturn(producto3);
		
		// Act
		
		List<Producto> listaProductos = productoServicesImplFL.getAll();
		
		// Assert
		assertNotNull(listaProductos);
		assertEquals(3, listaProductos.size());
		assertTrue(listaProductos.contains(producto1));
		assertTrue(listaProductos.contains(producto2));
		assertTrue(listaProductos.contains(producto3));
	
	}

	/**
	 * Test method for {@link com.viewnext.Siraku.servicesImpl.ProductoServicesImplFL#getNumeroTotalProductos()}.
	 */
	@Test
	void testGetNumeroTotalProductos() {
		
		//Arrange
		when(productoRepository.count()).thenReturn(2L);
	
		//Act
		long test = productoServicesImplFL.getNumeroTotalProductos();
		
		//Assert
		assertEquals(test, 2L);
		
	}


}
