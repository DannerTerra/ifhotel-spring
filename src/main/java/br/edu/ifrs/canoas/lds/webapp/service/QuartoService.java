package br.edu.ifrs.canoas.lds.webapp.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import br.edu.ifrs.canoas.lds.webapp.domain.Quarto;
import br.edu.ifrs.canoas.lds.webapp.repository.QuartoRepository;
import br.edu.ifrs.canoas.lds.webapp.repository.UserRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class QuartoService {

	private final QuartoRepository quartoRepository;

	public Quarto save(Quarto quarto) {
		Quarto fetchedQuarto = this.getOne(quarto);
		if (fetchedQuarto == null) return null;

		fetchedQuarto.setNumero(quarto.getNumero());
		fetchedQuarto.setDescricao(quarto.getDescricao());
		fetchedQuarto.setDisponivel(quarto.getDisponivel());
		fetchedQuarto.setTipo(quarto.getTipo());
		return quartoRepository.save(fetchedQuarto);
	}

	public Quarto getOne(Quarto quarto) {
		Optional<Quarto> optQuarto = quartoRepository.findById(quarto.getId());
		return optQuarto.isPresent()?optQuarto.get():null;
	}
}
