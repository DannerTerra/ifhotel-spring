package br.edu.ifrs.canoas.lds.webapp.domain;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToOne;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Entity implementation class for Entity: Pessoa
 *
 */
@Entity
@NoArgsConstructor
@Data
@DiscriminatorValue("RESERVADA")
public class DiariaReservada extends Diaria{

	@OneToOne
	private Reserva reserva;

}
