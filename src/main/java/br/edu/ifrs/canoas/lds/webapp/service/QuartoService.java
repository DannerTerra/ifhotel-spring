package br.edu.ifrs.canoas.lds.webapp.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import br.edu.ifrs.canoas.lds.webapp.domain.Diaria;
import br.edu.ifrs.canoas.lds.webapp.domain.Quarto;
import br.edu.ifrs.canoas.lds.webapp.domain.Reserva;
import br.edu.ifrs.canoas.lds.webapp.repository.DiariaRepository;
import br.edu.ifrs.canoas.lds.webapp.repository.QuartoRepository;
import br.edu.ifrs.canoas.lds.webapp.repository.ReservaRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class QuartoService {

	private final QuartoRepository quartoRepository;
	private final DiariaRepository diariaRepository;
	private final ReservaRepository reservaRepository;

	public List<Quarto> findAll(){
		return quartoRepository.findAll();
	}

	@Transactional
	public void delete(Long id) {
		for(Reserva reserva: reservaRepository.findByDiaria_Quarto_Id(id)) {
			reservaRepository.delete(reserva);
		}

		for(Diaria diaria : diariaRepository.findByQuarto_Id(id)) {
			diariaRepository.delete(diaria);
		}
		
		quartoRepository.deleteById(id); 
	}

	public void salva(Quarto quarto) {
		quartoRepository.save(quarto);
	}

	public Quarto busca(Long id) {
		return quartoRepository.getOne(id);
	}	
	
}
