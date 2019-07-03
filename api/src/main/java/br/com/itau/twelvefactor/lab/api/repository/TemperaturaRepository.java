/**
 * 
 */
package br.com.itau.twelvefactor.lab.api.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import br.com.itau.twelvefactor.lab.api.model.Temperatura;

/**
 * @author felipeguerraoliveira
 *
 */
public interface TemperaturaRepository extends CrudRepository<Temperatura, Long> {
	
	public List<Temperatura> findByName(String name);

}
