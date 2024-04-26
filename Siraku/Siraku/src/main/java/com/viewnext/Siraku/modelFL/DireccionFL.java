package com.viewnext.Siraku.modelFL;

import java.io.Serializable;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// De este hay uno por cliente, dado que es la direccion 
// de entrega y por tanto solo tendría que haber una

@Data
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class DireccionFL implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String direccion;
	private String poblacion;
	private String codPostal;
	private String provincia;
	private String pais;
	
}
