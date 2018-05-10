package br.edu.ifrs.canoas.lds.webapp.controller;

import java.util.Locale;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.edu.ifrs.canoas.lds.webapp.config.Messages;
import br.edu.ifrs.canoas.lds.webapp.domain.Reserva;
import br.edu.ifrs.canoas.lds.webapp.service.PessoaFisicaService;
import br.edu.ifrs.canoas.lds.webapp.service.PessoaJuridicaService;
import br.edu.ifrs.canoas.lds.webapp.service.QuartoService;
import br.edu.ifrs.canoas.lds.webapp.service.ReservaService;
import lombok.AllArgsConstructor;

@Controller
@RequestMapping("/reserva")
@AllArgsConstructor
public class ReservaController {

	private final Messages messages;
	private final ReservaService reservaService;
	private final QuartoService quartoService;
	private final PessoaJuridicaService pessoaJuridicaService;
	private final PessoaFisicaService pessoaFisicaService;
	
	@GetMapping("/")
	public ModelAndView lista() {
		ModelAndView mav = new ModelAndView("/reserva/lista");
		mav.addObject("reservas", reservaService.findAll());
		mav.addObject("quartos", quartoService.findAll());
		mav.addObject("pessoasFisicas", pessoaFisicaService.list());
		mav.addObject("pessoasJuridicas", pessoaJuridicaService.findAll());
		return mav;
	}
	
	@GetMapping("/deleta/{id}")
	public ModelAndView deleta(@PathVariable Long id) {
		reservaService.deleta(id);
		return new ModelAndView("redirect:/reserva");
	}
	
	@GetMapping("/edita/{id}")
	public ModelAndView edita(@PathVariable Long id) {
		ModelAndView mav = new ModelAndView("/reserva/lista");
		mav.addObject("reserva", reservaService.busca(id));
		return mav;
	}
	
    @PostMapping("/salva")
    public ModelAndView salva(@Valid Reserva reserva, BindingResult bindingResult,
            RedirectAttributes redirectAttr, Locale locale){

    	if (bindingResult.hasErrors()) {
            return new ModelAndView("/reserva/lista");
        }

    	ModelAndView mav = new ModelAndView("redirect:/reserva");
        mav.addObject("reserva", reservaService.salva(reserva));
        redirectAttr.addFlashAttribute("message", messages.get("field.saved"));

        return mav;
    }
}