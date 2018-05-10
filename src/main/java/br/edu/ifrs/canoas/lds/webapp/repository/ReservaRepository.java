package br.edu.ifrs.canoas.lds.webapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.ifrs.canoas.lds.webapp.domain.Reserva;

public interface ReservaRepository extends JpaRepository<Reserva, Long> {
	
}