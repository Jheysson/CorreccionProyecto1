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

import pe.unjfsc.daw.entity.CENatalidad;
import pe.unjfsc.daw.logical.impl.CMNatalidad;

@Controller
public class CCNatalidad {
	private static final Logger log = LoggerFactory.getLogger("CMNatalidad");
	private LinkedHashSet<CENatalidad> oListaFinal;

	@Autowired
	private CMNatalidad oCMNatalidad;
	
	@RequestMapping(value = "natalidad/ListadoNatalidad.lhs")
	public ModelAndView linkedHashSetConsulta() {
		String lArchivoRealJsp="natalidad/jspNatalidad";
		String lFechaSistema=(new Date().toString());		
		oListaFinal = new LinkedHashSet<>();		
		oListaFinal = oCMNatalidad.consultAllRetiros();		
		Map<String, Object> myModel = new HashMap<String,Object>();
		myModel.put("now", lFechaSistema);
		myModel.put("listNatalidad", oListaFinal);
		return new ModelAndView(lArchivoRealJsp,"model",myModel);
	}
	
	@RequestMapping(value="natalidad/agregarNatalidad.lhs", method=RequestMethod.GET)
	public ModelAndView addNatalidad() {
		ModelAndView model = new ModelAndView();
		CENatalidad pCENatalidad = new CENatalidad();
		model.addObject("natalidad/natalidadForm", pCENatalidad);
		model.setViewName("natalidad/natalidadForm");
		return model;
	}
	
	@RequestMapping(value="natalidad/save.lhs", method=RequestMethod.POST)
	public ModelAndView saveNatalidad(@ModelAttribute("natalidadForm") CENatalidad pCENatalidad) {
		String lArchivoRealJsp="natalidad/jspNatalidad";
		oCMNatalidad.saveNatalidad(pCENatalidad);
		oListaFinal = new LinkedHashSet<>();		
		oListaFinal = oCMNatalidad.consultAllRetiros();		
		Map<String, Object> myModel = new HashMap<String,Object>();
		myModel.put("listNatalidad", oListaFinal);
		log.info("Registro en controller" + pCENatalidad);
		return new ModelAndView(lArchivoRealJsp,"model",myModel);
	}
	@RequestMapping(value="natalidad/updateNatalidad.lhs/{CUIA}.lhs", method=RequestMethod.GET)
	public ModelAndView updateNatalidad(@PathVariable int CUIA,CENatalidad pCeNatalidad) {
		ModelAndView model = new ModelAndView();
		CENatalidad pCENatalidad = oCMNatalidad.consultByIdCUIA(CUIA);
		model.addObject("natalidad/natalidadFormUpdate", pCENatalidad);
		model.setViewName("natalidad/natalidadFormUpdate");
		return model;
	}
	@RequestMapping(value = "natalidad/update.lhs", method=RequestMethod.POST)
	public ModelAndView updateNatalidad(@ModelAttribute("natalidadFormUpdate") CENatalidad pCENatalidad) {
		String lArchivoRealJsp="natalidad/jspNatalidad";
		oCMNatalidad.updateNatalidad(pCENatalidad);
		oListaFinal = new LinkedHashSet<>();		
		oListaFinal = oCMNatalidad.consultAllRetiros();		
		Map<String, Object> myModel = new HashMap<String,Object>();
		myModel.put("listNatalidad", oListaFinal);
		log.info("Update en controller" + pCENatalidad);
		return new ModelAndView(lArchivoRealJsp,"model",myModel);
	}
	@RequestMapping(value = "natalidad/buscarNatalidad.lhs/{CUIA}.lhs", method=RequestMethod.POST)
	public ModelAndView buscarNatalidad(@PathVariable int CUIA,CENatalidad pCeNatalidad) {
		/*ModelAndView model = new ModelAndView();
		CENatalidad pCENatalidad = oCMNatalidad.consultByIdCUIA(CUIA);
		model.addObject("natalidad/natalidadFormUpdate", pCENatalidad);
		model.setViewName("natalidad/natalidadFormUpdate");
		return model;*/
		
		ModelAndView model = new ModelAndView();
		CENatalidad pCENatalidad = oCMNatalidad.consultByIdCUIA(CUIA);
		model.addObject("natalidad/jspNatalidad", pCENatalidad);
		model.setViewName("natalidad/jspNatalidad");
		return model;
	}
	
	@RequestMapping(value = "natalidad/eliminarNatalidad.lhs/{CUIA}.lhs", method=RequestMethod.GET)
	public ModelAndView deleteNatalidad(@PathVariable int CUIA) {
		oCMNatalidad.deleteNatalidad(CUIA);
		return new ModelAndView("redirect:/natalidad/ListadoNatalidad.lhs");
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
