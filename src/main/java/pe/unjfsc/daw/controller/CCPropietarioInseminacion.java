package pe.unjfsc.daw.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import pe.unjfsc.daw.entity.CEPropietarioInseminacion;
import pe.unjfsc.daw.logical.impl.CMPropietarioInseminacion;

@Controller

public class CCPropietarioInseminacion {
	private static final Logger log = LoggerFactory.getLogger("CMPropietarioInseminacion");
	
	private LinkedHashSet<CEPropietarioInseminacion> iListaFinal;
	
	@Autowired

	private CMPropietarioInseminacion oCMInseminacion;
	@RequestMapping(value = "inseminacion/ListadoInseminacion.lhs")
	public ModelAndView linkedHashSetShow() {
		String lArchivoRealJsp="inseminacion/jspPropInseminacion";
		String lFechaSistema=(new Date().toString());		
		iListaFinal = new LinkedHashSet<>();	
		iListaFinal = oCMInseminacion.showAll();
		Map<String, Object> myModel = new HashMap<String,Object>();
		myModel.put("now", lFechaSistema);
		myModel.put("listPropi", iListaFinal);
		return new ModelAndView(lArchivoRealJsp,"model",myModel);
	}
	
	@RequestMapping(value="inseminacion/agregarPropInse.lhs", method=RequestMethod.GET)
	public ModelAndView addPropInse() {
		ModelAndView model = new ModelAndView();
		CEPropietarioInseminacion pCEPropInse= new CEPropietarioInseminacion();
		model.addObject("inseminacion/inseminacionForm", pCEPropInse);
		model.setViewName("inseminacion/inseminacionForm");
		return model;
	}
	
	@RequestMapping(value="inseminacion/save.lhs", method=RequestMethod.POST)
	public ModelAndView saveInseminacion(@ModelAttribute("inseminacionForm") CEPropietarioInseminacion pCEPropInse) {
		String lArchivoRealJsp="inseminacion/jspPropInseminacion";
		oCMInseminacion.savePropiInseminacion(pCEPropInse);
		iListaFinal = new LinkedHashSet<>();	
		iListaFinal = oCMInseminacion.showAll();	
		Map<String, Object> myModel = new HashMap<String,Object>();
		myModel.put("listPropi", iListaFinal);
		log.info("Registro en controller" + pCEPropInse);
		return new ModelAndView(lArchivoRealJsp,"model",myModel);
	}
	@RequestMapping(value="inseminacion/updatePropInse.lhs/{codiPropInse}.lhs", method=RequestMethod.GET)
	public ModelAndView updatePropInse(@PathVariable int codiPropInse,CEPropietarioInseminacion pCePropInse) {
		ModelAndView model = new ModelAndView();
		CEPropietarioInseminacion pCEPropInse = oCMInseminacion.showBycodigo(codiPropInse);
		model.addObject("inseminacion/inseminacionFormUpdate", pCEPropInse);
		model.setViewName("inseminacion/inseminacionFormUpdate");
		return model;
	}
	
	@RequestMapping(value = "inseminacion/update.lhs", method=RequestMethod.POST)
	public ModelAndView updateInseminacion(@ModelAttribute("inseminacion/inseminacionFormUpdate") CEPropietarioInseminacion pCEPropInse) {
		String lArchivoRealJsp="inseminacion/jspPropInseminacion";
		oCMInseminacion.updatePropiInseminacion(pCEPropInse);
		iListaFinal = new LinkedHashSet<>();	
		iListaFinal = oCMInseminacion.showAll();
		Map<String, Object> myModel = new HashMap<String,Object>();
		myModel.put("listPropi", iListaFinal);
		log.info("Update en controller" + pCEPropInse);
		return new ModelAndView(lArchivoRealJsp,"model",myModel);
	}
	
	@RequestMapping(value = "inseminacion/eliminarPropInse.lhs/{codiPropInse}.lhs", method=RequestMethod.GET)
	public ModelAndView deleteInseminacion(@PathVariable int codiPropInse) {		
		oCMInseminacion.deletePropiInseminacion(codiPropInse);
		return new ModelAndView("redirect:/inseminacion/ListadoInseminacion.lhs");
	}
	

	
}
