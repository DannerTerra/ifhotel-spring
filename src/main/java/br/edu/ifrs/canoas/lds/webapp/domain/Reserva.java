package br.edu.ifrs.canoas.lds.webapp.domain;

import java.io.Serializable;
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
public class Reserva implements Serializable {
	
	private static final long serialVersionUID = -6363690009550605256L;
	
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
