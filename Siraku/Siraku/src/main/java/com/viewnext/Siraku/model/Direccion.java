package com.viewnext.Siraku.model;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Direccion implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String direccion;
	private String poblacion;
	private String codPostal;
	private String provincia;
	private String pais;
	
}
