/**
 * 
 */
package br.com.itau.twelvefactor.lab.api.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @author felipeguerraoliveira
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Temperatura implements Serializable {

	private static final long serialVersionUID = -8765465781L;
	
	private Long id;
	
	private String name;
	
	private DadosTemperatura main;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
	public DadosTemperatura getMain() {
		return main;
	}

	public void setMain(DadosTemperatura main) {
		this.main = main;
	}

	@Override
	public String toString() {
		StringBuffer result = new StringBuffer();
		
		result.append("{ Id: ").append(id).append(", ");
		result.append("Cidade: ").append(name).append(", ");
		result.append("Temperatura: ").append("{Valor: ");
		result.append(this.main.getValor()).append("} }");
		
		return result.toString();
	}

}
