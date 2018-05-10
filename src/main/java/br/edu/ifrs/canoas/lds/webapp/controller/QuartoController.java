package br.edu.ifrs.canoas.lds.webapp.controller;

import java.util.Arrays;
import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.edu.ifrs.canoas.lds.webapp.config.Messages;
import br.edu.ifrs.canoas.lds.webapp.domain.Quarto;
import br.edu.ifrs.canoas.lds.webapp.domain.enums.TipoDeQuarto;
import br.edu.ifrs.canoas.lds.webapp.service.QuartoService;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
@RequestMapping("/quarto")
public class QuartoController {
	
	private final Messages messages;
	private final QuartoService quartoService;
    
	@GetMapping("/")
	public ModelAndView list() {
		ModelAndView mav = new ModelAndView("/quarto/list");
		mav.addObject("quartos", quartoService.findAll());
		mav.addObject("quarto", new Quarto());
		return mav;
	}

	@GetMapping("/delete/{id}")
	public ModelAndView delete(@PathVariable Long id) {
		quartoService.delete(id); 
		return new ModelAndView("redirect:/quarto/");
	}

	@GetMapping("/novo")
	public ModelAndView novo() {
		ModelAndView mav = new ModelAndView("/quarto/form");
		mav.addObject("quarto", new Quarto());
		return mav;
	}

	@GetMapping("/edita/{id}")
	public ModelAndView edita(@PathVariable Long id) {
		ModelAndView mav = new ModelAndView("/quarto/list");
		mav.addObject("quarto", quartoService.busca(id));
		mav.addObject("quartos", quartoService.findAll());
		return mav;
	}

	@PostMapping("/salva")
	public ModelAndView salva(@Valid Quarto quarto) {
		ModelAndView mav = new ModelAndView("redirect:/quarto/list");
		quartoService.salva(quarto);
		return mav;
	}
	
	@ModelAttribute("tipoQuartos")
    public List<TipoDeQuarto> populateEvaluationStatus() {
        return Arrays.asList(TipoDeQuarto.values());
    }

}
