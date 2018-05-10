package br.edu.ifrs.canoas.lds.webapp.service;


import java.util.stream.Collectors;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.edu.ifrs.canoas.lds.webapp.config.auth.UserImpl;
import br.edu.ifrs.canoas.lds.webapp.repository.UsuarioRepository;
import lombok.AllArgsConstructor;

/**
 * Created by rodrigo on 2/21/17.
 */
@Service
@AllArgsConstructor
public class UsuarioDetailsImplService implements UserDetailsService {

	private final UsuarioRepository usuarioRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		return this.usuarioRepository.findByUsername(username)
				.map(usuario -> new UserImpl(
				        usuario.getUsername(),
                        usuario.getPassword(),
						usuario.getPapeis().stream().map(role -> new SimpleGrantedAuthority(role.getRole())).collect(Collectors.toList()),
                        usuario)
                ).orElseThrow(() -> new UsernameNotFoundException("couldn't find " + username + "!"));
	}
}