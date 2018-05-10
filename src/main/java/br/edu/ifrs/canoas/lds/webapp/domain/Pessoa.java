package br.edu.ifrs.canoas.lds.webapp.domain;

import java.util.List;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Transient;
import javax.validation.constraints.Email;

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
@DiscriminatorColumn(name = "TIPO_PESSOA")
public abstract class Pessoa {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

	//@NotNull
	//@Size(min=2, max=100,message="#{pessoa.nome}")
	private String nome;
	//@Pattern(regexp="\\(\\d{2}\\)\\ \\d{4}-\\d{4}")
	//@NotEmpty
	private String telefone;
	//@NotEmpty
	@Email private String email;

	@OneToOne
	private Endereco endereco;
	@OneToMany(mappedBy="cliente")
	private List<DiariaAvulsa> diariasAvulsas;
	@OneToMany(mappedBy="cliente")
	private List<Reserva> reservas;

	@Transient
	public String getCpfCnpj() {
		if (this instanceof PessoaFisica)
			return ((PessoaFisica)this).getCpf();
		else if(this instanceof PessoaJuridica)
			return ((PessoaJuridica)this).getCnpj();

		return null;
	}
}


