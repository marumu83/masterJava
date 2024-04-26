package com.viewnext.Siraku.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.viewnext.Siraku.modelFL.ComercialFL;

@Repository
public interface ComercialRepository extends JpaRepository<ComercialFL, Long> {
	
	@Query("select c.codigo, c.nombre, c.apellido1, c.apellido2 from ComercialFL c")
	List<Object[]> listaDeObjetos();
}
