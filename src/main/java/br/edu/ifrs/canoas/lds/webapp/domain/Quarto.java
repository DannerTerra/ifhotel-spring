package br.edu.ifrs.canoas.lds.webapp.domain;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import br.edu.ifrs.canoas.lds.webapp.domain.enums.TipoDeQuarto;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Entity implementation class for Entity: Usuario
 *
 */
@Entity
@Data
@NoArgsConstructor
public class Quarto  {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

	private String numero;

	@Enumerated(EnumType.STRING)
	private TipoDeQuarto tipo;
	private Boolean disponivel;
	private String descricao;
}
