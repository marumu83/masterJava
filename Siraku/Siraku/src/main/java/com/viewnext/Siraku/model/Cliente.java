package com.viewnext.Siraku.model;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cliente implements Serializable {
	private static final long serialVersionUID = 1L;
	

	private String identificadorFiscal;
	
	private String nombreComercial;
	private String nombre;
	private String apellido1;
	private String apellido2;
	
	private Direccion direccion;

	private DatosContacto datosContacto;

	private List<Producto> productos;

	@Override
	public int hashCode() {
		return Objects.hash(identificadorFiscal);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;
		return Objects.equals(identificadorFiscal, other.identificadorFiscal);
	}

	@Override
	public String toString() {
		return "Cliente [identificadorFiscal=" + identificadorFiscal + ", nombreComercial=" + nombreComercial
				+ ", nombre=" + nombre + ", apellido1=" + apellido1 + ", apellido2=" + apellido2 + ", direccion="
				+ direccion + ", datosContacto=" + datosContacto + "]";
	}
	
}
