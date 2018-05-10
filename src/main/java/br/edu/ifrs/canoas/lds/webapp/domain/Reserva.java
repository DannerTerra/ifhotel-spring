package br.edu.ifrs.canoas.lds.webapp.domain;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Entity implementation class for Entity: Usuario
 *
 */
@Entity
@Data
@NoArgsConstructor
public class Reserva {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

	private Double valor;

	private LocalDate data;

	@ManyToOne
	private Pessoa cliente;

	@OneToOne
	private DiariaReservada diaria;

}
