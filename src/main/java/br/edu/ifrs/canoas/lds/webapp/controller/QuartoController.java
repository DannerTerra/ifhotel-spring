package br.edu.ifrs.canoas.lds.webapp.controller;

import java.util.Locale;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.edu.ifrs.canoas.lds.webapp.config.Messages;
import br.edu.ifrs.canoas.lds.webapp.domain.Quarto;
import br.edu.ifrs.canoas.lds.webapp.repository.QuartoRepository;
import br.edu.ifrs.canoas.lds.webapp.service.QuartoService;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class QuartoController {
	
	private final Messages messages;
	private final QuartoService quartoService;

	/*
	@GetMapping("/profile")
    public ModelAndView viewProfile(@AuthenticationPrincipal UserImpl activeUser){
        ModelAndView mav = new ModelAndView("/user/profile");
        mav.addObject("user", userService.getOne(activeUser.getUser()));
        return mav;
    }
    */

    @PostMapping("/save")
    public ModelAndView save(@Valid Quarto quarto, BindingResult bindingResult,
            RedirectAttributes redirectAttr, Locale locale){

    	if (bindingResult.hasErrors()) {
            return new ModelAndView("/quarto/profile");
        }

    	ModelAndView mav = new ModelAndView("redirect:/quarto/profile");
        mav.addObject("quarto", quartoService.save(quarto));
        redirectAttr.addFlashAttribute("message", messages.get("field.saved"));

        return mav;
    }   
    
}
