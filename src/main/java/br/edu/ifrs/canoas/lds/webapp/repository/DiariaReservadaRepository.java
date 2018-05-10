package br.edu.ifrs.canoas.lds.webapp.repository;

import br.edu.ifrs.canoas.lds.webapp.domain.DiariaAvulsa;
import br.edu.ifrs.canoas.lds.webapp.domain.DiariaReservada;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DiariaReservadaRepository extends JpaRepository<DiariaReservada, Long> {
	
}