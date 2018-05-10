package br.edu.ifrs.canoas.lds.webapp.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.edu.ifrs.canoas.lds.webapp.domain.Reserva;
import br.edu.ifrs.canoas.lds.webapp.repository.ReservaRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ReservaService {

	private ReservaRepository reservaRepository;

	public List<Reserva> findAll(){
		return reservaRepository.findAll();
	}

	public void delete(Long id) {
		reservaRepository.deleteById(id);
	}

	public Reserva salva(Reserva reserva) {
		return reservaRepository.save(reserva);
	}

	public Reserva busca(Long id) {
		return reservaRepository.getOne(id);
	}

}
