package br.edu.ifrs.canoas.lds.webapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.ifrs.canoas.lds.webapp.domain.DiariaAvulsa;

public interface DiariaAvulsaRepository extends JpaRepository<DiariaAvulsa, Long> {
	
}