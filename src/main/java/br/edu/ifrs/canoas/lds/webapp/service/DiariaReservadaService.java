package br.edu.ifrs.canoas.lds.webapp.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.edu.ifrs.canoas.lds.webapp.domain.DiariaReservada;
import br.edu.ifrs.canoas.lds.webapp.repository.DiariaReservadaRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class DiariaReservadaService {

	private DiariaReservadaRepository diariaReservadaRepository;

	public List<DiariaReservada> findAll(){
		return diariaReservadaRepository.findAll();
	}

	public void deleta(Long id) {
		diariaReservadaRepository.deleteById(id);
	}

	public void salva(DiariaReservada diariaReservada) {
		diariaReservadaRepository.save(diariaReservada);
	}

	public DiariaReservada busca(Long id) {
		return diariaReservadaRepository.getOne(id);
	}
}
