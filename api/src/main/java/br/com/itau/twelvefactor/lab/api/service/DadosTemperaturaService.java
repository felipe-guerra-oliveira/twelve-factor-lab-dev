/**
 * 
 */
package br.com.itau.twelvefactor.lab.api.service;

import java.io.Serializable;

/**
 * @author felipeguerraoliveira
 *
 */
public interface DadosTemperaturaService extends Serializable {
	
	
	/**
	 * <p>
	 * 	Método responsável por consultar no microserviço os dados de temperatura para
	 *  uma determinada cidade e país <strong>(cidade,país</strong> e armazenar o resultado
	 *  na base de dados.
	 * </p>
	 * @param cidadePais (Ex.: London,uk)
	 */
	public void consultarEGravarTemperaturaPorCidadeEPais(String cidadePais);

}
