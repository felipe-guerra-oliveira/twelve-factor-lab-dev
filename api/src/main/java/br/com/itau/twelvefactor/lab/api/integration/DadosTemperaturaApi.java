/**
 * 
 */
package br.com.itau.twelvefactor.lab.api.integration;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import br.com.itau.twelvefactor.lab.api.model.Temperatura;

/**
 * @author felipeguerraoliveira
 *
 */
@Configuration
public class DadosTemperaturaApi implements Serializable {

	private static final long serialVersionUID = -89079685741L;
	
	private static final Logger LOG = LoggerFactory.getLogger(DadosTemperaturaApi.class);
	
	@Value("${twelvefactor.weather.api.url}")
	private String url;
	
	@Value("${twelvefactor.weather.api.token}")
	private String token;
	
	private RestTemplate restTemplate = null;
	
	public DadosTemperaturaApi() {
		this.restTemplate = new RestTemplate();
	}
	
	private HttpHeaders getHttpHeaders() {
		HttpHeaders httpHeaders = new HttpHeaders();
		List<MediaType> acceptList = new ArrayList<>();
		acceptList.add(MediaType.APPLICATION_JSON);
		
		httpHeaders.setAccept(acceptList);
		
		return httpHeaders;
	}
	
	/**
	 * @param cidadePais (Ex.: London,uk)
	 * @return instância de Temperatura com os dados extraídos do JSON
	 */
	public Temperatura consultarTemperaturaAtualPelaCidadeEPais(String cidadePais) {
		Temperatura result = null;
		StringBuffer urlToCall = new StringBuffer();
		
		try {
			urlToCall.append(url).append(cidadePais);
			urlToCall.append("&").append("APPID=");
			urlToCall.append(this.token);

			result = this.restTemplate.getForObject(urlToCall.toString(),
													Temperatura.class);
			
		}catch(Exception ex) {
			LOG.error("Erro ao tentar consultar o serviço de temperatura.", ex);
			throw new RuntimeException(ex);
		}
		return result;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

}
