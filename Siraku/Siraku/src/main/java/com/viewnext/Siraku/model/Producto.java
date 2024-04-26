package com.viewnext.Siraku.model;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;
import java.util.Objects;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Producto implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Long codigo;
	
	private String nombre;
	private double precio;
	private Date fechaAlta;
	private Familia familia;
	private boolean descatalogado;
	private List<Cliente> clientes;
	private Comercial comercial;
	
	@Override
	public int hashCode() {
		return Objects.hash(codigo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Producto other = (Producto) obj;
		return Objects.equals(codigo, other.codigo);
	}

	@Override
	public String toString() {
		return "Producto [codigo=" + codigo + ", nombre=" + nombre + ", precio=" + precio + ", fechaAlta=" + fechaAlta
				+ ", familia=" + familia + ", descatalogado=" + descatalogado + ", clientes=" + clientes + "]";
	}

}
