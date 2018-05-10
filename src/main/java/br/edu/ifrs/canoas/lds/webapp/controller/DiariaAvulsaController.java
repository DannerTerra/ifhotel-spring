package br.edu.ifrs.canoas.lds.webapp.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.edu.ifrs.canoas.lds.webapp.config.Messages;
import br.edu.ifrs.canoas.lds.webapp.domain.DiariaAvulsa;
import br.edu.ifrs.canoas.lds.webapp.service.DiariaAvulsaService;
import br.edu.ifrs.canoas.lds.webapp.service.PessoaFisicaService;
import br.edu.ifrs.canoas.lds.webapp.service.PessoaJuridicaService;
import br.edu.ifrs.canoas.lds.webapp.service.QuartoService;
import br.edu.ifrs.canoas.lds.webapp.service.ReservaService;
import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
@RequestMapping("/diaria_avulsa")
public class DiariaAvulsaController {

	private DiariaAvulsaService diariaAvulsaService;

	private final Messages messages;
	private final QuartoService quartoService;
	private final PessoaJuridicaService pessoaJuridicaService;
	private final PessoaFisicaService pessoaFisicaService;
	
	@GetMapping("/")
	public ModelAndView list() {
		ModelAndView mav = new ModelAndView("/diaria_avulsa/list");
		mav.addObject("quartos", quartoService.findAll());
		mav.addObject("pessoasFisicas", pessoaFisicaService.list());
		mav.addObject("pessoasJuridicas", pessoaJuridicaService.findAll());
		mav.addObject("diariasAvulsas", diariaAvulsaService.findAll());
		return mav;
	}

	@GetMapping("/delete/{id}")
	public ModelAndView delete(@PathVariable Long id) {
		diariaAvulsaService.delete(id);
		return new ModelAndView("redirect:/diaria_avulsa/");
	}

	@GetMapping("/novo")
	public ModelAndView novo() {
		ModelAndView mav = new ModelAndView("/diaria_avulsa/form");
		mav.addObject("diariaAvulsa", new DiariaAvulsa());
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
		ModelAndView mav = new ModelAndView("redirect:/diaria_avulsa/");
		diariaAvulsaService.salva(diariaAvulsa);
		return mav;
	}
}
