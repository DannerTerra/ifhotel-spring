package br.edu.ifrs.canoas.lds.webapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.edu.ifrs.canoas.lds.webapp.domain.Quarto;
import br.edu.ifrs.canoas.lds.webapp.repository.QuartoRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class QuartoService {

	private final QuartoRepository quartoRepository;

	public List<Quarto> findAll(){
		return quartoRepository.findAll();
	}

	public void delete(Long id) {
		quartoRepository.deleteById(id);
	}

	public void salva(Quarto quarto) {
		quartoRepository.save(quarto);
	}

	public Quarto busca(Long id) {
		return quartoRepository.getOne(id);
	}	
	
}
