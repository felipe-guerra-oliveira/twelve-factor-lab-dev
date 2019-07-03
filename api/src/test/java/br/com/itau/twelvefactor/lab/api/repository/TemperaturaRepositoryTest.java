/**
 * 
 */
package br.com.itau.twelvefactor.lab.api.repository;

import static org.junit.Assert.assertEquals;
import static org.mockito.BDDMockito.given;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import br.com.itau.twelvefactor.lab.api.model.Temperatura;

/**
 * @author felipeguerraoliveira
 *
 */
@RunWith(MockitoJUnitRunner.class)
public class TemperaturaRepositoryTest {
	
	@Mock
	private TemperaturaRepository temperaturaRepository;

	@Test
	public void testGravarNovaTemperatura_DeveRetornarSucesso() {
		Temperatura instance = new Temperatura(1000000L, "teste");
		given(this.temperaturaRepository.save(instance)).willReturn(instance);
		
		
		Temperatura persistentTemp = this.temperaturaRepository.save(instance);
		
		assertEquals(persistentTemp, instance);
	}
	
}
