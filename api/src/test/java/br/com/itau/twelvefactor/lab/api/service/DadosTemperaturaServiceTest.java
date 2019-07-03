/**
 * 
 */
package br.com.itau.twelvefactor.lab.api.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.BDDMockito.given;
import static org.mockito.ArgumentMatchers.anyString;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import br.com.itau.twelvefactor.lab.api.integration.DadosTemperaturaApi;
import br.com.itau.twelvefactor.lab.api.model.Temperatura;
import br.com.itau.twelvefactor.lab.api.repository.TemperaturaRepository;

/**
 * @author felipeguerraoliveira
 *
 */
@RunWith(MockitoJUnitRunner.class)
public class DadosTemperaturaServiceTest {
	
	private DadosTemperaturaService dadosTempService;
	
	@Mock
	private TemperaturaRepository temperaturaRepository;
	
	@Mock
	private DadosTemperaturaApi dadosTemperaturaApiTest;
	
	@Before
	public void setUp() {
		this.dadosTempService = new DadosTemperaturaServiceImpl(temperaturaRepository, dadosTemperaturaApiTest);
	}

	@Test
	public void consultarEGravarTemperaturaPorCidadeEPais_DeveVoltarSucesso() throws Exception {
		Temperatura temperaturaTest = new Temperatura(2643743L, "London");
		given(temperaturaRepository.save(temperaturaTest)).willReturn(temperaturaTest);
		given(dadosTemperaturaApiTest.consultarTemperaturaAtualPelaCidadeEPais(anyString())).willReturn(temperaturaTest);
		
		Temperatura temperatura = this.dadosTempService.consultarEGravarTemperaturaPorCidadeEPais("London,uk");
		
		assertEquals(temperaturaTest, temperatura);
	}
	
}
