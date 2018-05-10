package br.edu.ifrs.canoas.lds.webapp.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.edu.ifrs.canoas.lds.webapp.domain.DiariaAvulsa;
import br.edu.ifrs.canoas.lds.webapp.service.DiariaAvulsaService;
import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
@RequestMapping("/diaria_avulsa")
public class DiariaAvulsaController {

	private DiariaAvulsaService diariaAvulsaService;

	@GetMapping("/")
	public ModelAndView list() {
		ModelAndView mav = new ModelAndView("/diaria_avulsa/list");
		mav.addObject("diariasAvulsas", diariaAvulsaService.findAll());
		return mav;
	}

	@GetMapping("/delete/{id}")
	public ModelAndView delete(@PathVariable Long id) {
		diariaAvulsaService.delete(id);
		return new ModelAndView("redirect:/diaria_avulsa/list");
	}

	@GetMapping("/novo")
	public ModelAndView novo() {
		ModelAndView mav = new ModelAndView("/diaria_avulsa/form");
		mav.addObject("diariasAvulsas", new DiariaAvulsa());
		return mav;
	}

	@GetMapping("/edita/{id}")
	public ModelAndView edita(@PathVariable Long id) {
		ModelAndView mav = new ModelAndView("/diaria_avulsa/form");
		mav.addObject("diariaAvulsa", diariaAvulsaService.busca(id));
		return mav;
	}

	@PostMapping("/salva")
	public ModelAndView salva(@Valid DiariaAvulsa diariaAvulsa) {
		ModelAndView mav = new ModelAndView("redirect:/diaria_avulsa/list");
		diariaAvulsaService.salva(diariaAvulsa);
		return mav;
	}
}
