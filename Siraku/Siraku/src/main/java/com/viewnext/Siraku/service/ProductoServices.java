package com.viewnext.Siraku.service;

import java.sql.Date;
import java.util.List;
import java.util.Map;

import com.viewnext.Siraku.model.Familia;
import com.viewnext.Siraku.model.Producto;

public interface ProductoServices {

	
	/**
	 * El método create devuelve el Producto con el c�digo que le ha otorgado el sistema
	 * 
	 */
	Producto create(Producto producto);
	
	Producto read(long codigo);
	
	/**
	 * El producto entrante debe tener un código existente
	 * 
	 * Si el código no existe lanza una IllegaStateException
	 * 
	 */
	Producto update(Producto producto);
	
	/**
	 * 
	 * Devuelve true si se ha podido eliminar
	 * 
	 */
	boolean delete(long codigo);
	
	List<Producto> getAll();
	
	List<Producto> getByFamilia(Familia familia);
	
	List<Producto> getBetweenPriceRange(double min, double max);
	
	List<Producto> getBetweenDates(Date desde, Date hasta);
	
	int getNumeroTotalProductos();
	
	Map<Familia, Integer> getNumeroTotalProductosPorFamilia();
	
	Map<Familia, Double> getPrecioMedioPorFamilia();

}
