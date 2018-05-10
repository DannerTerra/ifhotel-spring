package br.edu.ifrs.canoas.lds.webapp.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.ifrs.canoas.lds.webapp.domain.Pessoa;
import br.edu.ifrs.canoas.lds.webapp.domain.Reserva;

public interface ReservaRepository extends JpaRepository<Reserva, Long> {

	Optional<Reserva> findByCliente(Pessoa cliente);

	List<Reserva> findByDiaria_Quarto_Id(Long id);
	
}