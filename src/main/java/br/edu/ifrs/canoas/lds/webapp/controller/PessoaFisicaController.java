package br.edu.ifrs.canoas.lds.webapp.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.edu.ifrs.canoas.lds.webapp.config.Messages;
import br.edu.ifrs.canoas.lds.webapp.config.auth.UserImpl;
import br.edu.ifrs.canoas.lds.webapp.service.PessoaFisicaService;
import lombok.AllArgsConstructor;

@Controller
@RequestMapping("/pessoa_fisica")
@AllArgsConstructor
public class PessoaFisicaController {

	private final Messages messages;
	private final PessoaFisicaService pfService;

	@GetMapping("/")
    public ModelAndView list(@AuthenticationPrincipal UserImpl activeUser){
        ModelAndView mav = new ModelAndView("/pessoa_fisica/index");
        mav.addObject("pessoasFisicas", pfService.list());
        return mav;
    }
	
//	@GetMapping("/")
//    public ModelAndView list(@PathVariable Long id){
//        ModelAndView mav = new ModelAndView("/pessoa_fisica/fragments/select_pessoa :: select");
//        mav.addObject("pessoasFisicas", pfService.list());
//        return mav;
//    }

//    @PostMapping("/save")
//    public ModelAndView save(@Valid Usuario user, BindingResult bindingResult,
//            RedirectAttributes redirectAttr, Locale locale){
//
//    	if (bindingResult.hasErrors()) {
//            return new ModelAndView("/user/profile");
//        }
//
//    	ModelAndView mav = new ModelAndView("redirect:/user/profile");
//        mav.addObject("user", userService.save(user));
//        redirectAttr.addFlashAttribute("message", messages.get("field.saved"));
//
//        return mav;
//    }
}
