package br.edu.ifrs.canoas.lds.webapp.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import br.edu.ifrs.canoas.lds.webapp.domain.PessoaFisica;
import br.edu.ifrs.canoas.lds.webapp.repository.PessoaFisicaRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class PessoaFisicaService {

	private final PessoaFisicaRepository pfRepository;

	public PessoaFisica save(PessoaFisica pf) {
		PessoaFisica fetchedPF = this.getOne(pf);
		if (fetchedPF == null) return null;

		fetchedPF.setCpf(pf.getCpf());
		fetchedPF.setDataNascimento(pf.getDataNascimento());
		fetchedPF.setEmail(pf.getEmail());
		fetchedPF.setEndereco(pf.getEndereco());
		fetchedPF.setNome(pf.getNome());
		fetchedPF.setRg(pf.getRg());
		fetchedPF.setTelefone(pf.getTelefone());
		fetchedPF.setSexo(pf.getSexo());
		return pfRepository.save(fetchedPF);
	}

	public PessoaFisica getOne(PessoaFisica pf) {
		Optional<PessoaFisica> optPF = pfRepository.findById(pf.getId());
		return optPF.isPresent()?optPF.get():null;
	}

	public Iterable<PessoaFisica> list() {
		return pfRepository.findAll();
	}
}
