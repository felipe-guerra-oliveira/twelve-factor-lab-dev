/**
 * 
 */
package br.com.itau.twelvefactor.lab.api.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @author felipeguerraoliveira
 *
 */
@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
public class Temperatura implements Serializable, Comparable<Temperatura> {

	private static final long serialVersionUID = -8765465781L;
	
	public Temperatura() {
		super();
	}
	
	public Temperatura(Long id, String name) {
		this.id = id;
		this.name = name;
	}
	
	@Id
	private Long id;
	
	@Column(name = "cidade")
	private String name;
	
	@Transient
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
	public int compareTo(Temperatura o) {
		return o.getId().compareTo(this.getId());
	}

	@Override
	public String toString() {
		StringBuffer result = new StringBuffer();
		
		result.append("{ Id: ").append(id).append(", ");
		result.append("Cidade: ").append(name).append(", ");
		result.append("Temperatura: ").append("{Valor: ");
		result.append(this.main!=null ? this.main.getValor() : "-").append("} }");
		
		return result.toString();
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Temperatura))
			return false;
		Temperatura other = (Temperatura) obj;
		if (id == null) {
			if (other.getId() != null)
				return false;
		} else if (!id.equals(other.getId()))
			return false;
		
		return true;
	}

}
