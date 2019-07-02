/**
 * 
 */
package br.com.itau.twelvefactor.lab.api.integration;

import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;
import org.springframework.web.client.RestTemplate;

import br.com.itau.twelvefactor.lab.api.model.Temperatura;

/**
 * @author felipeguerraoliveira
 *
 */
public class TemperaturaIntegrationServiceTest {

	public String url;
	public String appID;
	
	@Before
	public void setUp() {
		this.url = "http://api.openweathermap.org/data/2.5/weather?q=";
		this.appID = "2a5145f9f367e7a725bb8b6f3ea92ff0";
	}
	
	
	@Test
	public void testConsultarTemperaturaViGET_Sucesso() throws Exception {
		RestTemplate restTemplate = new RestTemplate();
		
		String getUrl = this.url + "London,uk&APPID=" + this.appID;
		
		Temperatura result = restTemplate.getForObject(getUrl, Temperatura.class);
		
		assertNotNull(result);
		
		System.out.println("RESULTADO: \r\n" + result);
	}
	
}
