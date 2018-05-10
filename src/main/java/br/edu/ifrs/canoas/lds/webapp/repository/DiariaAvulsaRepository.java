package br.edu.ifrs.canoas.lds.webapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.ifrs.canoas.lds.webapp.domain.DiariaAvulsa;
@Repository
public interface DiariaAvulsaRepository extends JpaRepository<DiariaAvulsa, Long> {

	List<DiariaAvulsa> findByQuarto_Id(Long id);
	
}