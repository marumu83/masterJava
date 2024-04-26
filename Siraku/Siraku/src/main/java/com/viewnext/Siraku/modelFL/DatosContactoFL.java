package com.viewnext.Siraku.modelFL;

import java.io.Serializable;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

//De este hay uno por cliente
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class DatosContactoFL implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String telefono1;
	private String telefono2;
	private String email;

	public String getTelefono1() {
		return telefono1;
	}

	public void setTelefono1(String telefono1) {
		this.telefono1 = telefono1;
	}

	public String getTelefono2() {
		return telefono2;
	}

	public void setTelefono2(String telefono2) {
		this.telefono2 = telefono2;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
}
