package br.edu.ifrs.canoas.lds.webapp.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.edu.ifrs.canoas.lds.webapp.domain.DiariaAvulsa;
import br.edu.ifrs.canoas.lds.webapp.domain.PessoaFisica;
import br.edu.ifrs.canoas.lds.webapp.domain.PessoaJuridica;
import br.edu.ifrs.canoas.lds.webapp.repository.DiariaAvulsaRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class DiariaAvulsaService {

	private DiariaAvulsaRepository diariaAvulsaRepository;

	public List<DiariaAvulsa> findAll(){
		return diariaAvulsaRepository.findAll();
	}

	public void delete(Long id) {
		diariaAvulsaRepository.deleteById(id);
	}

	public void salva(DiariaAvulsa diariaAvulsa, PessoaFisica pessoaFisica, PessoaJuridica pessoaJuridica) {
		
		diariaAvulsaRepository.save(diariaAvulsa);
	}

	public DiariaAvulsa busca(Long id) {
		return diariaAvulsaRepository.getOne(id);
	}
}
