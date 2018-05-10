package br.edu.ifrs.canoas.lds.webapp.service;

import java.util.List;
import javax.transaction.Transactional;
import org.springframework.stereotype.Service;
import br.edu.ifrs.canoas.lds.webapp.domain.Quarto;
import br.edu.ifrs.canoas.lds.webapp.repository.DiariaAvulsaRepository;
import br.edu.ifrs.canoas.lds.webapp.repository.QuartoRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class QuartoService {

	private final QuartoRepository quartoRepository;
	private final DiariaAvulsaRepository diariaAvulsaRepository;

	public List<Quarto> findAll(){
		return quartoRepository.findAll();
	}

	@Transactional
	public void delete(Long id) {
		
		//diariaAvulsaRepository.deleteById(arg0);
		//Quarto quarto = this.busca(id);
		quartoRepository.deleteById(id); 
	}

	public void salva(Quarto quarto) {
		quartoRepository.save(quarto);
	}

	public Quarto busca(Long id) {
		return quartoRepository.getOne(id);
	}	
	
}
