/**
 * 
 */
package br.com.itau.twelvefactor.lab.api.model;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author felipeguerraoliveira
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class DadosTemperatura {

	@JsonProperty("temp")
	private BigDecimal valor;

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}
	
}
