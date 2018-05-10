package br.edu.ifrs.canoas.lds.webapp.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.edu.ifrs.canoas.lds.webapp.domain.PessoaJuridica;
import br.edu.ifrs.canoas.lds.webapp.service.PessoaJuridicaService;
import lombok.AllArgsConstructor;

@Controller
@RequestMapping("/pessoa_juridica")
@AllArgsConstructor
public class PessoaJuridicaController {


	private PessoaJuridicaService pessoaJuridicaService;

	@GetMapping("/")
	public ModelAndView list() {
		ModelAndView mav = new ModelAndView("/pessoa_juridica/list");
		mav.addObject("diariasAvulsas", pessoaJuridicaService.findAll());
		return mav;
	}

	@GetMapping("/delete/{id}")
	public ModelAndView delete(@PathVariable Long id) {
		pessoaJuridicaService.delete(id);
		return new ModelAndView("redirect:/pessoa_juridica/list");
	}

	@GetMapping("/novo")
	public ModelAndView novo() {
		ModelAndView mav = new ModelAndView("/pessoa_juridica/form");
		mav.addObject("pessoaJuridica", new PessoaJuridica());
		return mav;
	}

	@GetMapping("/edita/{id}")
	public ModelAndView edita(@PathVariable Long id) {
		ModelAndView mav = new ModelAndView("/pessoa_juridica/form");
		mav.addObject("pessoaJuridica", pessoaJuridicaService.busca(id));
		return mav;
	}

	@PostMapping("/salva")
	public ModelAndView salva(@Valid PessoaJuridica pessoaJuridica) {
		ModelAndView mav = new ModelAndView("redirect:/pessoa_juridica/list");
		pessoaJuridicaService.salva(pessoaJuridica);
		return mav;
	}
}
