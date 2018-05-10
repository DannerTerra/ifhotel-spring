package br.edu.ifrs.canoas.lds.webapp.domain;

import java.io.Serializable;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
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
public class DiariaReservada extends Diaria implements Serializable {
	
	private static final long serialVersionUID = -159905495749992552L;
	
	@OneToOne
	private Reserva reserva;
   
}
