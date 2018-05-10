package br.edu.ifrs.canoas.lds.webapp.domain;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Entity implementation class for Entity: Pessoa
 *
 */
@Entity
@NoArgsConstructor
@Data
@DiscriminatorValue("AVULSA")
public class DiariaAvulsa extends Diaria  {

	@ManyToOne
	private Pessoa cliente;

}
