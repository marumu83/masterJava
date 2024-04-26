package com.viewnext.Siraku.modelFL;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Clientes")
public class ClienteFL implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	private String identificadorFiscal;
	
	private String nombreComercial;
	private String nombre;
	private String apellido1;
	private String apellido2;
	
	@Embedded
	private DireccionFL direccion;
	@Embedded
	private DatosContactoFL datosContacto;
	
	@ManyToMany
	@JoinTable(name = "PEDIDOS", joinColumns = @JoinColumn(name = "identificadorFiscal"),
			inverseJoinColumns = @JoinColumn(name = "cod_producto"))
	private List<ProductoFL> productos;
	

	public String getIdentificadorFiscal() {
		return identificadorFiscal;
	}

	public void setIdentificadorFiscal(String identificadorFiscal) {
		this.identificadorFiscal = identificadorFiscal;
	}

	public String getNombreComercial() {
		return nombreComercial;
	}

	public void setNombreComercial(String nombreComercial) {
		this.nombreComercial = nombreComercial;
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

	public DireccionFL getDireccion() {
		return direccion;
	}

	public void setDireccion(DireccionFL direccion) {
		this.direccion = direccion;
	}

	public DatosContactoFL getDatosContacto() {
		return datosContacto;
	}

	public void setDatosContacto(DatosContactoFL datosContacto) {
		this.datosContacto = datosContacto;
	}

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
		ClienteFL other = (ClienteFL) obj;
		return Objects.equals(identificadorFiscal, other.identificadorFiscal);
	}

	@Override
	public String toString() {
		return "Cliente [identificadorFiscal=" + identificadorFiscal + ", nombreComercial=" + nombreComercial
				+ ", nombre=" + nombre + ", apellido1=" + apellido1 + ", apellido2=" + apellido2 + ", direccion="
				+ direccion + ", datosContacto=" + datosContacto + "]";
	}
	
}
