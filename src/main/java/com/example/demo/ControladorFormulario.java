package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ControladorFormulario {

  @RequestMapping(value="/formulario", method=RequestMethod.GET)
  public String formulario_get() {
	  
    return "formulario";
    
  }
  
  @RequestMapping(value="/formulario", method=RequestMethod.POST)
  public String  formulario_post(Model modelo,
		  @RequestParam String nombre,
		  @RequestParam String primerApellido,
		  @RequestParam String segundoApellido,
		  @RequestParam String email,
		  @RequestParam Integer dia,
		  @RequestParam Integer mes,
		  @RequestParam Integer ano,
		  @RequestParam String contrasena,
		  @RequestParam String hm,
		  @RequestParam String direccion,
		  @RequestParam String estudios,
		  @RequestParam(required=false) String intereses) {
  
  modelo.addAttribute("nombre",nombre);
  modelo.addAttribute("primerApellido",primerApellido);
  modelo.addAttribute("segundoApellido",segundoApellido);
  modelo.addAttribute("email",email);
  modelo.addAttribute("dia",dia);
  modelo.addAttribute("mes",mes);
  modelo.addAttribute("ano",ano);
  modelo.addAttribute("contrasena",contrasena);
  modelo.addAttribute("hm",hm);
  modelo.addAttribute("direccion",direccion);
  modelo.addAttribute("estudios",estudios);
  modelo.addAttribute("intereses",intereses);
  
  return "datosFormulario";
	}
}