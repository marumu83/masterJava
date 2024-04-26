package com.viewnext.Siraku.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.viewnext.Siraku.model.Familia;
import com.viewnext.Siraku.modelFL.ProductoFL;

public interface ProductoRepository extends JpaRepository<ProductoFL, Long> {
	
	public List<ProductoFL> findByFamilia(Familia familia);
}
