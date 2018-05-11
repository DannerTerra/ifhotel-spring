package br.edu.ifrs.canoas.lds.webapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.ifrs.canoas.lds.webapp.domain.Diaria;

public interface DiariaRepository extends JpaRepository<Diaria, Long>{

	List<Diaria> findByQuarto_Id(Long id);

}
