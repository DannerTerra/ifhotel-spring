package br.edu.ifrs.canoas.lds.webapp.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

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
public class Quarto extends BaseEntity<Long> implements Serializable {

	private static final long serialVersionUID = 8671579293612635068L;
	@GeneratedValue(strategy = GenerationType.AUTO)
	
	private String numero;
	
	@Enumerated(EnumType.STRING)    
	private TipoDeQuarto tipo;
	private Boolean disponivel;
	private String descricao;
}
