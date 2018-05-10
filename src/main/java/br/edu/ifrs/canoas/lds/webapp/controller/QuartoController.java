package br.edu.ifrs.canoas.lds.webapp.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import br.edu.ifrs.canoas.lds.webapp.config.Messages;
import br.edu.ifrs.canoas.lds.webapp.domain.Quarto;
import br.edu.ifrs.canoas.lds.webapp.service.QuartoService;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class QuartoController {
	
	private final Messages messages;
	private final QuartoService quartoService;
    
	@GetMapping("/")
	public ModelAndView list() {
		ModelAndView mav = new ModelAndView("list");
		mav.addObject("quarto", quartoService.findAll());
		return mav;
	}

	@GetMapping("/delete/{id}")
	public ModelAndView delete(@PathVariable Long id) {
		quartoService.delete(id);
		return new ModelAndView("redirect:/");
	}

	@GetMapping("/novo")
	public ModelAndView novo() {
		ModelAndView mav = new ModelAndView("form");
		//mav.addObject("quarto", new QuartoService());
		return mav;
	}

	@GetMapping("/edita/{id}")
	public ModelAndView edita(@PathVariable Long id) {
		ModelAndView mav = new ModelAndView("form");
		mav.addObject("quarto", quartoService.busca(id));
		return mav;
	}

	@PostMapping("/salva")
	public ModelAndView salva(@Valid Quarto quarto) {
		ModelAndView mav = new ModelAndView("redirect:/");
		quartoService.salva(quarto);
		return mav;
	}
    
}
