package cl.cokke.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import cl.cokke.model.Alumno;
import cl.cokke.services.AlumnoService;
import cl.cokke.services.DireccionService;

@Controller
@RequestMapping({"/","alumnos"})
public class AlumnoController {
	
	@Autowired
	private AlumnoService as;
	
	@Autowired
	private DireccionService ds;
	
	@GetMapping
	public ModelAndView alumnos() {
		
		ModelAndView  modelAndView = new ModelAndView("alumnos");
		modelAndView.addObject("alumnos", as.findAllAlumno());
		return modelAndView;
	}
	
	@GetMapping("/crear")
	public ModelAndView crear() {
		ModelAndView  modelAndView = new ModelAndView("crear-alumno");
		modelAndView.addObject("alumno", new Alumno());
		modelAndView.addObject("direcciones", ds.findAllDireccion());
		return modelAndView;
	}
	
	@PostMapping("/crear")
	public RedirectView crear(@ModelAttribute Alumno alumno) {
		as.save(alumno);
		return new RedirectView("/alumnos");
	}
	
	@GetMapping("/editar")
	public ModelAndView editar(@RequestParam Integer id) {
		ModelAndView  modelAndView = new ModelAndView("editar-alumno");
		modelAndView.addObject("alumno", new Alumno());
		modelAndView.addObject("alumnoVO", as.findById(id).get());
		modelAndView.addObject("direcciones", ds.findAllDireccion());
		return modelAndView;
	}
	
	@PostMapping("/editar")
	public RedirectView editar(@ModelAttribute Alumno alumno) {
		as.save(alumno);
		return new RedirectView("/alumnos");
	}
	
	@GetMapping("/eliminar")
	public RedirectView eliminar(@RequestParam Integer id) {
		if(as.findById(id).isPresent()) {
			as.delete(as.findById(id).get());
		}		
		return new RedirectView("/alumnos");
	}
	
	
	
}
