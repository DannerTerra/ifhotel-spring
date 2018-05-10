package br.edu.ifrs.canoas.lds.webapp.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import br.edu.ifrs.canoas.lds.webapp.domain.Usuario;
import br.edu.ifrs.canoas.lds.webapp.repository.UsuarioRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UsuarioService {

	private final UsuarioRepository userRepository;

	public Usuario save(Usuario user) {
		Usuario fetchedUser = this.getOne(user);
		if (fetchedUser == null) return null;

		fetchedUser.setName(user.getName());
		fetchedUser.setEmail(user.getEmail());
		fetchedUser.setSkill(user.getSkill());
		fetchedUser.setExperience(user.getExperience());
		return userRepository.save(fetchedUser);
	}

	public Usuario getOne(Usuario user) {
		Optional<Usuario> optUser = userRepository.findById(user.getId());
		return optUser.isPresent()?optUser.get():null;
	}

	public Iterable<Usuario> list() {
		return userRepository.findAll();
	}
}
