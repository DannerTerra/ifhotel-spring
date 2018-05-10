package br.edu.ifrs.canoas.lds.webapp.service;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import br.edu.ifrs.canoas.lds.webapp.domain.PessoaJuridica;
import br.edu.ifrs.canoas.lds.webapp.repository.PessoaJuridicaRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class PessoaJuridicaService {

	private final PessoaJuridicaRepository pessoaJuridicaRepository;
	
	public List<PessoaJuridica> findAll(){
		return pessoaJuridicaRepository.findAll();
	}

	public void delete(Long id) {
		pessoaJuridicaRepository.deleteById(id);
	}

	public PessoaJuridica save(PessoaJuridica pessoaJuridica) { 
		return pessoaJuridicaRepository.save(pessoaJuridica);
	}

	public PessoaJuridica getOne(PessoaJuridica pessoaJuridica) {
		Optional<PessoaJuridica> optPessoaJuridica = pessoaJuridicaRepository.findById(pessoaJuridica.getId());
		return optPessoaJuridica.isPresent()?optPessoaJuridica.get():null;
	}
	
	public PessoaJuridica busca(Long id) {
		return pessoaJuridicaRepository.getOne(id);
	}
}
