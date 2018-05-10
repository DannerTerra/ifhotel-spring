package br.edu.ifrs.canoas.lds.webapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.ifrs.canoas.lds.webapp.domain.DiariaAvulsa;
@Repository
public interface DiariaAvulsaRepository extends JpaRepository<DiariaAvulsa, Long> {
	
}