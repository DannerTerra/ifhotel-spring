package br.edu.ifrs.canoas.lds.webapp.controller;

import static org.hamcrest.CoreMatchers.allOf;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.hasProperty;
import static org.mockito.BDDMockito.given;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.user;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.flash;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;

import br.edu.ifrs.canoas.lds.webapp.config.Messages;
import br.edu.ifrs.canoas.lds.webapp.config.auth.UserImpl;
import br.edu.ifrs.canoas.lds.webapp.service.UsuarioService;

@WebMvcTest(UsuarioController.class)
public class UsuarioControllerTest extends BaseControllerTest{

    // All autowired fields from Controller must have a mock
    @MockBean
    Messages messages;
    @MockBean
    UsuarioService usuarioService;
    @MockBean
    UserImpl usuarioImpl;

    @Test
    public void view_usuario_profile() throws Exception{
    	given(usuarioService.busca(super.usuario)).willReturn(super.usuario);
        this.mvc.perform(get("/usuario/perfil")
                .with(user(usuarioDetails))
                .accept(MediaType.TEXT_HTML)
        )
                .andExpect(status().isOk())
                .andExpect(content().contentType("text/html;charset=UTF-8"))
                .andExpect(view().name("/usuario/perfil"))
                .andExpect(model().attribute("usuario"
                        ,allOf(
                                hasProperty("id", is(USER_ID))
                                ,hasProperty("name", is(USER_NAME)))
                ))
        ;
    }

    @Test
    public void save_usuario_profile() throws Exception{
    	given(usuarioService.busca(super.usuario)).willReturn(super.usuario);
        given(this.messages.get("field.saved")).willReturn(FIELD_SAVED);

        this.mvc.perform(post("/usuario/salva")
                .with(user(usuarioDetails))
                .with(csrf())
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .param("id", USER_ID.toString())
                .param("name", USER_NAME)
                .param("email", USER_EMAIL)
        )
                .andExpect(view().name("redirect:/usuario/perfil"))
                .andExpect(model().size(1))
                .andExpect(flash().attributeExists("message"))
                .andExpect(flash().attribute("message", FIELD_SAVED))
        ;
    }



}