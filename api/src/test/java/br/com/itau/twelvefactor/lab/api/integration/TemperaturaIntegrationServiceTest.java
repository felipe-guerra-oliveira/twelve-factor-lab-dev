/**
 * 
 */
package br.com.itau.twelvefactor.lab.api.integration;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import br.com.itau.twelvefactor.lab.api.model.Temperatura;

/**
 * @author felipeguerraoliveira
 *
 */
public class TemperaturaIntegrationServiceTest {

	private DadosTemperaturaApi dadosTemperaturaApi; 
	
	@Before
	public void setUp() {
		this.dadosTemperaturaApi = new DadosTemperaturaApi();
		this.dadosTemperaturaApi.setUrl("http://api.openweathermap.org/data/2.5/weather?q=");
		this.dadosTemperaturaApi.setToken("2a5145f9f367e7a725bb8b6f3ea92ff0");
	}
	
	
	@Test
	public void testConsultarTemperaturaViGET_Sucesso() throws Exception {
		Temperatura assertResult = dadosTemperaturaApi.consultarTemperaturaAtualPelaCidadeEPais("London,uk");
		
		System.out.println(assertResult.toString());
		assertEquals("London", assertResult.getName());
	}
	
}
