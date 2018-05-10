package br.edu.ifrs.canoas.lds.webapp.controller;

import br.edu.ifrs.canoas.lds.webapp.config.Messages;
import br.edu.ifrs.canoas.lds.webapp.config.auth.UserImpl;
import br.edu.ifrs.canoas.lds.webapp.domain.Usuario;
import br.edu.ifrs.canoas.lds.webapp.service.UsuarioService;
import lombok.AllArgsConstructor;

import java.util.Locale;

import javax.validation.Valid;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/usuario")
@AllArgsConstructor
public class UsuarioController {

	private final Messages messages;
	private final UsuarioService usuarioService;

	@GetMapping("/perfil")
    public ModelAndView perfil(@AuthenticationPrincipal UserImpl usuarioAtivo){
        ModelAndView mav = new ModelAndView("/usuario/perfil");
        mav.addObject("usuario", usuarioService.busca(usuarioAtivo.getUser()));
        return mav;
    }

	@GetMapping("/")
    public ModelAndView lista(@AuthenticationPrincipal UserImpl usuarioAtivo){
        ModelAndView mav = new ModelAndView("/usuario/lista");
        mav.addObject("usuarios", usuarioService.lista());
        return mav;
    }

    @PostMapping("/salva")
    public ModelAndView salva(@Valid Usuario usuario, BindingResult bindingResult,
            RedirectAttributes redirectAttr, Locale locale){

    	if (bindingResult.hasErrors()) {
            return new ModelAndView("/usuario/perfil");
        }

    	ModelAndView mav = new ModelAndView("redirect:/usuario/perfil");
        mav.addObject("usuario", usuarioService.salva(usuario));
        redirectAttr.addFlashAttribute("message", messages.get("field.saved"));

        return mav;
    }
}
