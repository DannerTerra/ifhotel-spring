package br.edu.ifrs.canoas.lds.webapp.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.edu.ifrs.canoas.lds.webapp.domain.Reserva;
import br.edu.ifrs.canoas.lds.webapp.repository.DiariaReservadaRepository;
import br.edu.ifrs.canoas.lds.webapp.repository.ReservaRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ReservaService {

	private ReservaRepository reservaRepository;
	private DiariaReservadaRepository diariaReservadaRepository;

	public List<Reserva> findAll(){
		return reservaRepository.findAll();
	}

	public void deleta(Long id) {
		reservaRepository.deleteById(id);
	}
	@Transactional
	public Reserva salva(Reserva reserva) {
		diariaReservadaRepository.save(reserva.getDiaria());
		return reservaRepository.save(reserva);
	}

	public Reserva busca(Long id) {
		return reservaRepository.getOne(id);
	}

}