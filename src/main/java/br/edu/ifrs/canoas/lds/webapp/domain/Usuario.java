
package br.edu.ifrs.canoas.lds.webapp.domain;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by rodrigo on 2/21/17.
 */
@Entity
@Data
@NoArgsConstructor
public class Usuario {

	@Id
	@GeneratedValue
	private Long id;
	private String username;
	private boolean active;
	private String password;
	@ManyToMany(fetch = FetchType.EAGER)
	private Set<Papel> papeis;
	@NotBlank
	private String name;
	@Email @NotBlank
	private String email;
	private String experience;
	private String skill;
    @OneToOne
    private Arquivo picture;

}