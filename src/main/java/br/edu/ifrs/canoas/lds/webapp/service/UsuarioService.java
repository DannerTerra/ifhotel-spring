package br.edu.ifrs.canoas.lds.webapp.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import br.edu.ifrs.canoas.lds.webapp.domain.Usuario;
import br.edu.ifrs.canoas.lds.webapp.repository.UsuarioRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UsuarioService {

	private final UsuarioRepository usuarioRepository;

	public Usuario salva(Usuario usuario) {
		Usuario fetchedUser = this.busca(usuario);
		if (fetchedUser == null) return null;

		fetchedUser.setName(usuario.getName());
		fetchedUser.setEmail(usuario.getEmail());
		fetchedUser.setSkill(usuario.getSkill());
		fetchedUser.setExperience(usuario.getExperience());
		return usuarioRepository.save(fetchedUser);
	}

	public Usuario busca(Usuario usuario) {
		Optional<Usuario> optUser = usuarioRepository.findById(usuario.getId());
		return optUser.isPresent()?optUser.get():null;
	}

	public Iterable<Usuario> lista() {
		return usuarioRepository.findAll();
	}
}
