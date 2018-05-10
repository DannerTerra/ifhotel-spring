package br.edu.ifrs.canoas.lds.webapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.ifrs.canoas.lds.webapp.domain.Quarto;

@Repository
public interface QuartoRepository extends JpaRepository<Quarto, Long> {
	
}
