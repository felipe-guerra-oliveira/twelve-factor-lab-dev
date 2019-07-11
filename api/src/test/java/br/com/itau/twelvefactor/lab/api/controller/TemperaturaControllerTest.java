/**
 * 
 */
package br.com.itau.twelvefactor.lab.api.controller;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.itau.twelvefactor.lab.api.model.Temperatura;
import br.com.itau.twelvefactor.lab.api.service.DadosTemperaturaService;

/**
 * @author felipeguerraoliveira
 *
 */
//@RunWith(SpringRunner.class)
//@WebMvcTest(controllers = TemperaturaController.class)
public class TemperaturaControllerTest {
	
	@Autowired
	private MockMvc mockMVC;
	
	@MockBean
	private DadosTemperaturaService dadosTemperaturaService;
	
	public static byte[] convertObjectToJsonBytes(Temperatura t) throws IOException {
		ObjectMapper mapper = new ObjectMapper();
		mapper.setSerializationInclusion(Include.NON_NULL);
		
		return mapper.writeValueAsBytes(t);
	}
	
	//@Test
	public void consultarEGravarTemperaturaPorCidadeEPais_RetornaSucesso() throws IOException, Exception {
		Temperatura temperaturaTest = new Temperatura(2643743L, "London");
		
		given(dadosTemperaturaService.consultarEGravarTemperaturaPorCidadeEPais(anyString()))
			.willReturn(temperaturaTest);
		
		
		mockMVC.perform(MockMvcRequestBuilders.get("/twelve-factor-app/temperatura/London,uk")
											.contentType(MediaType.APPLICATION_JSON_UTF8)
											.content(convertObjectToJsonBytes(temperaturaTest)))
				.andExpect(status().is2xxSuccessful());
	}
	
	//@Test
	public void consultarEGravarTemperaturaPorCidadeEPais_RequestProibido() throws IOException, Exception {
		Temperatura temperaturaTest = new Temperatura(2643743L, "London");
		
		given(dadosTemperaturaService.consultarEGravarTemperaturaPorCidadeEPais(anyString()))
			.willReturn(temperaturaTest);
		
		
		mockMVC.perform(MockMvcRequestBuilders.get("/twelve-factor-app/temperatura")
											.contentType(MediaType.APPLICATION_JSON_UTF8)
											.content(convertObjectToJsonBytes(temperaturaTest)))
				.andExpect(status().isForbidden());
	}

}
