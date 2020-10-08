package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ControladorGC {

  @RequestMapping(value="/calculadora", method=RequestMethod.GET)
  public String calculadora_get() {
	  
    return "calculadora";
    
  }
  
  @RequestMapping(value="/calculadora", method=RequestMethod.POST)
  public String  calculadora_post(Model modelo,
		  @RequestParam Double peso,
		  @RequestParam Double estatura,
		  @RequestParam Integer edad,
		  @RequestParam Integer hm) {
	  
	  Double resultado= 1.2*(peso/(estatura*estatura))+0.23*edad-10.8*hm-5.4;
	  
	  String resultado2 = null;
	  
	  switch(hm) {
	  	case 1:
	  		if(resultado>=2 && resultado<=5)
	  			resultado2="Grasa esencial";
	  		else if(resultado <= 13 && resultado>5)
	  			resultado2="Atletas";
	  		else if(resultado <= 17 && resultado>13)
	  			resultado2="Fitness";
	  		else if(resultado <= 24 && resultado>17)
	  			resultado2="Aceptable";
	  		else if(resultado >= 25)
	  			resultado2="Obesidad";
	  		else
	  			resultado2=null;
	  	break;
	  	case 0:
	  		if(resultado <= 13 && resultado>=10)
	  			resultado2="Grasa esencial";
	  		else if(resultado <= 20 && resultado>13)
	  			resultado2="Atletas";
	  		else if(resultado <= 24 && resultado>20)
	  			resultado2="Fitness";
	  		else if(resultado <= 31 && resultado>24)
	  			resultado2="Aceptable";
	  		else if(resultado >= 32)
	  			resultado2="Obesidad";
	  		else
	  			resultado2=null;
	  	break;
	  }
	  
  modelo.addAttribute("resultado2",resultado2);
  modelo.addAttribute("resultado",resultado);
  modelo.addAttribute("hm",hm);
  
  return "resultadoCalculadora";
	}
}