package br.edu.ifrs.canoas.lds.webapp.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by rodrigo on 3/18/17.
 */
@Entity
@Data
@NoArgsConstructor
public class Papel {

	@Id @GeneratedValue
	private Long id;
	private String role;
}
