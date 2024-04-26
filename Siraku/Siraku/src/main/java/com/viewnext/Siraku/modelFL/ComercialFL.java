package com.viewnext.Siraku.modelFL;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.TableGenerator;

@Entity
@Table(name = "comerciales")
public class ComercialFL implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@TableGenerator(name = "generadorCom",
					table = "sequences",
					pkColumnName = "nombre",
					pkColumnValue = "COMERCIALES_SEQ",
					valueColumnName = "valor",
					allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "generadorCom")
	@Column(name = "cod_comercial")
	private Long codigo;
	
	private String nombre;
	private String apellido1;
	private String apellido2;
	
	@OneToMany(mappedBy = "codigo")
	private List<ProductoFL> productos;
	
	public ComercialFL() {
		
	}

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido1() {
		return apellido1;
	}

	public void setApellido1(String apellido1) {
		this.apellido1 = apellido1;
	}

	public String getApellido2() {
		return apellido2;
	}

	public void setApellido2(String apellido2) {
		this.apellido2 = apellido2;
	}

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
		ComercialFL other = (ComercialFL) obj;
		return Objects.equals(codigo, other.codigo);
	}

	@Override
	public String toString() {
		return "Comercial [codigo=" + codigo + ", nombre=" + nombre + ", apellido1=" + apellido1 + ", apellido2="
				+ apellido2 + "]";
	}
	
}
