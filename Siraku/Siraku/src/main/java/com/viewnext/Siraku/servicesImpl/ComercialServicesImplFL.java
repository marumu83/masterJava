package com.viewnext.Siraku.servicesImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.TreeMap;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.viewnext.Siraku.dto.ComercialDTO1;
import com.viewnext.Siraku.model.Comercial;
import com.viewnext.Siraku.modelFL.ComercialFL;
import com.viewnext.Siraku.repository.ComercialRepository;
import com.viewnext.Siraku.service.ComercialServices;

@Service
@Qualifier
@Primary
public class ComercialServicesImplFL implements ComercialServices {

	@Autowired
	private ComercialRepository cr;
	
	@Autowired
	private DozerBeanMapper mapper;
	
	@Override
	public Comercial create(Comercial comercial) {
		Comercial createdComercial = mapper.map(cr.save(mapper.map(comercial, ComercialFL.class)),Comercial.class);
		return createdComercial;
	}

	@Override
	public Comercial read(long codigo) {
		ComercialFL comercial = cr.findById(codigo).orElse(null);
		if (comercial != null) {
			return mapper.map(comercial, Comercial.class);
		}else {
			return null;
		}
	}

	@Override
	public List<Comercial> getAll() {
		List<ComercialFL> comericalesFL = cr.findAll();
		return comericalesFL.stream().map(com -> mapper.map(com, Comercial.class)).toList();
	}

	@Override
	public int getNumeroTotalComerciales() {
		return (int) cr.count();
	}

	@Override
	public List<ComercialDTO1> getComercialesDTO1() {
		List<Object[]> listaObjetos = cr.listaDeObjetos();
		List<ComercialDTO1> listaComercialDTO1 = new ArrayList<>();
		
		listaObjetos.stream().forEach(objeto -> {
			listaComercialDTO1.add(new ComercialDTO1(Long.valueOf(objeto[0].toString()),
					objeto[2].toString()+ " " + objeto[3].toString() + " " + objeto[1].toString(),
					objeto[1].toString(), objeto[2].toString(), objeto[3].toString()));
		});
		return listaComercialDTO1;
	}

}
