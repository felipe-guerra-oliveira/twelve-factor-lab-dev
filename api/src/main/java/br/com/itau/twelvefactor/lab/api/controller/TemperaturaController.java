package br.com.itau.twelvefactor.lab.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.itau.twelvefactor.lab.api.model.Temperatura;
import br.com.itau.twelvefactor.lab.api.service.DadosTemperaturaService;

@RestController
public class TemperaturaController {
	
	@Autowired
	private DadosTemperaturaService dadosTemperaturaService;
	
	@GetMapping(path = "/twelve-factor-app/temperatura/{cidadePais}",  
				produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Temperatura consultarEGravarTemperaturaPorCidadeEPais(@PathVariable String cidadePais) {
		return this.dadosTemperaturaService.consultarEGravarTemperaturaPorCidadeEPais(cidadePais);
	}

}
