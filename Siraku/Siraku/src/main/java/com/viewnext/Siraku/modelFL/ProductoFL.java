package com.viewnext.Siraku.modelFL;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.viewnext.Siraku.model.Familia;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.TableGenerator;

@Entity
@Table(name = "productos")
public class ProductoFL implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@TableGenerator(name = "generadorP",
					table = "sequences",
					pkColumnName = "nombre",
					pkColumnValue = "PRODUCTOS_SEQ",
					valueColumnName = "valor",
					allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "generadorP")
	@Column(name = "cod_producto")
	private Long codigo;
	
	private String nombre;
	private double precio;
	private Date fechaAlta;
	
	@Enumerated(value = EnumType.STRING)
	private Familia familia;
	private boolean descatalogado;
	
	@ManyToMany(mappedBy = "productos")
	@JsonIgnore
	private List<ClienteFL> clientes;
	
	@ManyToOne
	@JoinColumn(name = "cod_comercial")
	private ComercialFL comercial;
	
	public ProductoFL() {
		
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

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	/**
	 * @return the fechaAlta
	 */
	public Date getFechaAlta() {
		return fechaAlta;
	}

	/**
	 * @param fechaAlta the fechaAlta to set
	 */
	public void setFechaAlta(Date fechaAlta) {
		this.fechaAlta = fechaAlta;
	}

	public Familia getFamilia() {
		return familia;
	}

	public void setFamilia(Familia familia) {
		this.familia = familia;
	}

	public boolean isDescatalogado() {
		return descatalogado;
	}

	public void setDescatalogado(boolean descatalogado) {
		this.descatalogado = descatalogado;
	}

	/**
	 * @return the clientes
	 */
	public List<ClienteFL> getClientes() {
		return clientes;
	}

	/**
	 * @param clientes the clientes to set
	 */
	public void setClientes(List<ClienteFL> clientes) {
		this.clientes = clientes;
	}

	/**
	 * @return the comercial
	 */
	public ComercialFL getComercial() {
		return comercial;
	}

	/**
	 * @param comercial the comercial to set
	 */
	public void setComercial(ComercialFL comercial) {
		this.comercial = comercial;
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
		ProductoFL other = (ProductoFL) obj;
		return Objects.equals(codigo, other.codigo);
	}

	@Override
	public String toString() {
		return "Producto [codigo=" + codigo + ", nombre=" + nombre + ", precio=" + precio + ", fechaAlta=" + fechaAlta
				+ ", familia=" + familia + ", descatalogado=" + descatalogado + ", clientes=" + clientes + "]";
	}

}
