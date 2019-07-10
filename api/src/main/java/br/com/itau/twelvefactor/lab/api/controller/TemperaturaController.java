package br.com.itau.twelvefactor.lab.api.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.itau.twelvefactor.lab.api.model.Temperatura;
import br.com.itau.twelvefactor.lab.api.service.DadosTemperaturaService;

@RestController
@EnableAuthorizationServer
@RequestMapping("twelve-factor-app")
public class TemperaturaController {
	
	private static final Logger LOG = LoggerFactory.getLogger(TemperaturaController.class);
	
	@Autowired
	private DadosTemperaturaService dadosTemperaturaService;
	
	@PreAuthorize("#oauth2.hasScope('read')")
	@GetMapping(path = "/temperatura/{cidadePais}",  
				produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Temperatura consultarEGravarTemperaturaPorCidadeEPais(@PathVariable String cidadePais) {
		LOG.warn("######### Cidade,país {}", cidadePais);
		
		return this.dadosTemperaturaService.consultarEGravarTemperaturaPorCidadeEPais(cidadePais);
	}

}
