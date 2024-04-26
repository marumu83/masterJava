package com.viewnext.Siraku.servicesImpl;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.viewnext.Siraku.dto.ComercialDTO1;
import com.viewnext.Siraku.repository.ComercialRepository;

@ExtendWith(MockitoExtension.class)
class ComercialServicesImplDto {

	@Mock
	private ComercialRepository comrep;
	
	@InjectMocks
	private ComercialServicesImplFL comserv;
	
	@Test
	void getComercialesDTO1Test() {
		List<Object[]> listaObj = new ArrayList<>();
		
		Object[] fila1 = {1L, "Pedro", "Pérez", "Pérez"};
		Object[] fila2 = {2L, "Mario", "Gutierrez", "Hinojosa"};
		Object[] fila3 = {3L, "Sofia", "Martinez", "Martinez"};
		listaObj.add(fila1);
		listaObj.add(fila2);
		listaObj.add(fila3);
		
		when(comrep.listaDeObjetos()).thenReturn(listaObj);
		
		List<ComercialDTO1> listacomDTO = comserv.getComercialesDTO1();
		
		
		System.out.println(listacomDTO.get(0).getApellido1());
		
		assertNotNull(listacomDTO);
		List<String> nombres = listacomDTO.stream().map(x -> x.getNombre()).toList();
		assertTrue(nombres.contains("Pedro"));
		assertTrue(nombres.contains("Mario"));
		assertTrue(nombres.contains("Sofia"));
	}

}
