package br.edu.ifrs.canoas.lds.webapp.service;

import static org.assertj.core.api.Assertions.assertThat;

import javax.transaction.Transactional;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import br.edu.ifrs.canoas.lds.webapp.domain.Usuario;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Transactional
public class UsuarioServiceTest {

    @Autowired
    UsuarioService service;

    private final String PASSWORD = "password";

    @Test
    public void testSaveExistingUserIgnoringPassword(){
        // given
        Usuario user = new Usuario();
        user.setId(100L);
        user.setPassword(PASSWORD);

        // when
        Usuario saved = service.salva(user);

        // then
        assertThat(saved.getId()).isNotNull();
        assertThat(saved.getPassword()).isNotEqualTo(PASSWORD);
    }

    @Test
    public void testSaveNotExistingUser(){
        // given
        Usuario user = new Usuario();
        user.setId(2L);
        user.setName("name");
        user.setEmail("email@email.email");
        user.setPassword(PASSWORD);

        // when
        Usuario saved = service.salva(user);

        // then
        assertThat(saved).isNull();
    }

    @Ignore
    public void testSaveWithNullValue(){
        // given
        Usuario user = new Usuario();
        user.setId(100L);
        user.setPassword(PASSWORD);

        // when
        Usuario saved = service.salva(null);

        // then
        assertThat(saved).isNull();
    }
}