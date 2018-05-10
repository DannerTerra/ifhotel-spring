package br.edu.ifrs.canoas.lds.webapp.service;

import java.util.List;

import br.edu.ifrs.canoas.lds.webapp.domain.DiariaAvulsa;
import br.edu.ifrs.canoas.lds.webapp.repository.DiariaAvulsaRepository;

public class DiariaAvulsaService {

	private DiariaAvulsaRepository diariaAvulsaRepository;
	
	public List<DiariaAvulsa> findAll(){
		return diariaAvulsaRepository.findAll();
	}

	public void delete(Long id) {
		diariaAvulsaRepository.deleteById(id);
	}

	public void salva(DiariaAvulsa diariaAvulsa) {
		diariaAvulsaRepository.save(diariaAvulsa);
	}

	public DiariaAvulsa busca(Long id) {
		return diariaAvulsaRepository.getOne(id);
	}
}
