package com.viewnext.Siraku.service;

import java.util.List;

import com.viewnext.Siraku.dto.ComercialDTO1;
import com.viewnext.Siraku.model.Comercial;

public interface ComercialServices {

	/**
	 * El metodo create devuelve el Comercial con el c�digo que le ha otorgado el sistema
	 * 
	 */
	Comercial create(Comercial comercial);
	
	Comercial read(long codigo);

	List<Comercial> getAll();
	
	int getNumeroTotalComerciales();
	
	List<ComercialDTO1> getComercialesDTO1();
}
