package br.edu.ifrs.canoas.lds.webapp.domain;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Entity implementation class for Entity: Pessoa
 *
 */
@Entity
@NoArgsConstructor
@Data
@DiscriminatorValue("PJ")
public class PessoaJuridica extends Pessoa {


	//@NotNull @Size(min=2, max=100,message="#{pessoa.razaoSocial}")
	private String razaoSocial;
	//@NotNull @CNPJ
	private String cnpj;
	//@NotNull @Size(min=0, max=30,message="#{pessoa.inscricaoEstadual}")
	private String inscricaoEstadual;
	//@NotNull @Size(min=0, max=30,message="#{pessoa.inscricaoMunicipal}")
	private String inscricaoMunicipal;
}
