package cl.cokke.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import cl.cokke.model.Direccion;
import cl.cokke.services.DireccionService;

@Controller
@RequestMapping("direcciones")
public class DireccionController {
	
	@Autowired
	private DireccionService ds;
	
	@GetMapping
	public ModelAndView direcciones() {
		
		ModelAndView  modelAndView = new ModelAndView("direcciones");
		modelAndView.addObject("direcciones", ds.findAllDireccion());
		return modelAndView;
	}

	@GetMapping("/crear")
	public ModelAndView crear() {
		ModelAndView  modelAndView = new ModelAndView("crear-direccion");
		modelAndView.addObject("direccion", new Direccion());
		modelAndView.addObject("direccion", new Direccion());
		return modelAndView;
	}
	
	@PostMapping("/crear")
	public RedirectView crear(@ModelAttribute Direccion direccion) {
		ds.save(direccion);
		return new RedirectView("/direcciones");
	}
	
	
	
}
