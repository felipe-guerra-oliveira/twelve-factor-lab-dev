package br.com.itau.twelvefactor.lab.api.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.itau.twelvefactor.lab.api.integration.DadosTemperaturaApi;
import br.com.itau.twelvefactor.lab.api.model.Temperatura;
import br.com.itau.twelvefactor.lab.api.repository.TemperaturaRepository;

@Service
public class DadosTemperaturaServiceImpl implements DadosTemperaturaService {

	private static final long serialVersionUID = 3066667408538282113L;
	
	private static final Logger LOG = LoggerFactory.getLogger(DadosTemperaturaServiceImpl.class);
	
	@Autowired
	private TemperaturaRepository temperaturaRepository;
	
	@Autowired
	private DadosTemperaturaApi dadosTemperaturaApi;
	
	public DadosTemperaturaServiceImpl(TemperaturaRepository temperaturaRepository, DadosTemperaturaApi dadosTemperaturaApi) {
		this.temperaturaRepository = temperaturaRepository;
		this.dadosTemperaturaApi = dadosTemperaturaApi;
	}
	
	public DadosTemperaturaServiceImpl() {
		super();
	}
	
	@Override
	public Temperatura consultarEGravarTemperaturaPorCidadeEPais(String cidadePais) {
		Temperatura temperatura = null;
		
		try {
			LOG.debug("Pesquisar a cidade,país [" + cidadePais + "] no microserviço.");
			temperatura = dadosTemperaturaApi.consultarTemperaturaAtualPelaCidadeEPais(cidadePais);
			
			LOG.debug("Gravar a temperatura de [" + cidadePais + "] no banco de dados.");
			this.temperaturaRepository.save(temperatura);
			
		}catch(Exception e) {
			LOG.error("Erro ao tentar consultar a cidade e gravar no banco de dados.", e);
			throw new RuntimeException(e);
		}
		return temperatura;
	}
	
}
