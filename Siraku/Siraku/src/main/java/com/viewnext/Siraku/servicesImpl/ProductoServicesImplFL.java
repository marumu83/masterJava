package com.viewnext.Siraku.servicesImpl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.viewnext.Siraku.model.Familia;
import com.viewnext.Siraku.model.Producto;
import com.viewnext.Siraku.modelFL.ProductoFL;
import com.viewnext.Siraku.repository.ProductoRepository;
import com.viewnext.Siraku.service.ProductoServices;

@Service
@Qualifier
@Primary
public class ProductoServicesImplFL implements ProductoServices{

	@Autowired
	private ProductoRepository pr;

	@Autowired
	private DozerBeanMapper mapper;
	
	@Override
	public Producto create(Producto producto) {
		Producto createdProducto = mapper.map(pr.save(mapper.map(producto, ProductoFL.class)), Producto.class);
		return createdProducto;
	}

	@Override
	public Producto read(long codigo) {
		ProductoFL productoFL = pr.findById(codigo).orElse(null);
		if (productoFL != null) {
			return mapper.map(productoFL, Producto.class);
		}else {
			return null;
		}
	}
	
	@Override
	public Producto update(Producto producto) {
		Producto prod;
		if (producto != null) {
			prod = mapper.map(pr.save(mapper.map(producto, ProductoFL.class)), Producto.class);
		}else {
			prod = null;
		}
		return prod;
	}

	@Override
	public boolean delete(long codigo) {
		Producto prod = read(codigo);
		if (prod != null) {
			pr.delete(mapper.map(prod, ProductoFL.class));
			return true;
		}else {
			return false;
		}
	}

	@Override
	public List<Producto> getAll() {
		List<ProductoFL> productosFL = pr.findAll();
		return productosFL.stream().map(prod -> mapper.map(prod, Producto.class)).toList();
	}
	
	@Override
	public List<Producto> getByFamilia(Familia familia) {
		List<ProductoFL> productosFL = pr.findByFamilia(familia);
		return productosFL.stream().map(prod -> mapper.map(productosFL, Producto.class)).toList();
	}

	@Override
	public List<Producto> getBetweenPriceRange(double min, double max) {
		
		return null;
	}

	@Override
	public List<Producto> getBetweenDates(Date desde, Date hasta) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getNumeroTotalProductos() {
		return (int) pr.count();
	}

	@Override
	public Map<Familia, Integer> getNumeroTotalProductosPorFamilia() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<Familia, Double> getPrecioMedioPorFamilia() {
		// TODO Auto-generated method stub
		return null;
	}

}
