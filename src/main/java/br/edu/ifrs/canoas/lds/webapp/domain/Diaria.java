package br.edu.ifrs.canoas.lds.webapp.domain;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToMany;
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
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "TIPO_DIARIA")
public abstract class Diaria {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

	private Date data;
	@ManyToMany(mappedBy="diarias")
	private List<PessoaFisica> hospedes;
	@ManyToOne
	private Quarto quarto;

}
