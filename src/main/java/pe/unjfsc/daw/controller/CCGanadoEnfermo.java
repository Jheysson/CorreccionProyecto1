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

import pe.unjfsc.daw.entity.CEGanadoEnfermo;
import pe.unjfsc.daw.logical.impl.CMGanadoEnfermo;

@Controller
public class CCGanadoEnfermo {
	private static final Logger log = LoggerFactory.getLogger("CMGanadoEnfermo");
	private LinkedHashSet<CEGanadoEnfermo> oListaFinalEnferma;

	@Autowired
	private CMGanadoEnfermo oCMGanadoEnfermo;
	
	@RequestMapping(value = "ganadoEnfermo/ListadoGanadoEnfermo.lhs")
	public ModelAndView linkedHashSetConsulta() {
		String lArchivoRealJsp="ganadoEnfermo/jspGanadoEnfermo";
		String lFechaSistema=(new Date().toString());		
		oListaFinalEnferma = new LinkedHashSet<>();		
		oListaFinalEnferma = oCMGanadoEnfermo.consultaAll();	
		Map<String, Object> myModel = new HashMap<String,Object>();
		myModel.put("now", lFechaSistema);
		myModel.put("listGanadoEnfermo", oListaFinalEnferma);
		return new ModelAndView(lArchivoRealJsp,"model",myModel);
	}
	
	@RequestMapping(value="ganadoEnfermo/agregarGanadoEnfermo.lhs", method=RequestMethod.GET)
	public ModelAndView addGanadoEnfermo() {
		ModelAndView model = new ModelAndView();
		CEGanadoEnfermo pCEGanadoEnfermo = new CEGanadoEnfermo();
		model.addObject("ganadoEnfermo/ganadoEnfermoForm", pCEGanadoEnfermo);
		model.setViewName("ganadoEnfermo/ganadoEnfermoForm");
		return model;
	}
	
	@RequestMapping(value="ganadoEnfermo/save.lhs", method=RequestMethod.POST)
	public ModelAndView saveGanadoEnfermo(@ModelAttribute("ganadoEnfermoForm") CEGanadoEnfermo pCEGanadoEnfermo) {
		String lArchivoRealJsp="ganadoEnfermo/jspGanadoEnfermo";
		oCMGanadoEnfermo.saveGanadoEnfermo(pCEGanadoEnfermo);
		oListaFinalEnferma = new LinkedHashSet<>();		
		oListaFinalEnferma = oCMGanadoEnfermo.consultaAll();
		Map<String, Object> myModel = new HashMap<String,Object>();
		myModel.put("listGanadoEnfermo", oListaFinalEnferma);
		log.info("Registro en controller" + pCEGanadoEnfermo);
		return new ModelAndView(lArchivoRealJsp,"model",myModel);
	}
	@RequestMapping(value="ganadoEnfermo/updateGanadoEnfermo.lhs/{CUIA}.lhs", method=RequestMethod.GET)
	public ModelAndView updateNatalidad(@PathVariable int CUIA,CEGanadoEnfermo pCeGanadoEnfermo) {
		ModelAndView model = new ModelAndView();
		CEGanadoEnfermo pCEGanadoEnfermo = oCMGanadoEnfermo.consultarByCUIA(CUIA);
		model.addObject("ganadoEnfermo/ganadoEnfermoFormUpdate", pCEGanadoEnfermo);
		model.setViewName("ganadoEnfermo/ganadoEnfermoFormUpdate");
		return model;
	}
	/*@RequestMapping(value="updateNatalidad.lhs/{CUIA}", method=RequestMethod.GET)
	public ModelAndView updateNatalidad(@PathVariable int CUIA,HttpServletRequest request,HttpServletResponse response) {
		ModelAndView model = new ModelAndView();
		CENatalidad pCENatalidad = oCMNatalidad.consultByIdCUIA(CUIA);
		log.info("registro encontrado" + pCENatalidad);
		model.addObject("natalidadFormUpdate", pCENatalidad);
		model.setViewName("natalidadFormUpdate");
		return model;
	}*/
	
	@RequestMapping(value = "ganadoEnfermo/update.lhs", method=RequestMethod.POST)
	public ModelAndView updateGanadoEnfermo(@ModelAttribute("ganadoEnfermoFormUpdate") CEGanadoEnfermo pCEGanadoEnfermo) {
		String lArchivoRealJsp="ganadoEnfermo/jspGanadoEnfermo";
		oCMGanadoEnfermo.updateGanadoEnfermo(pCEGanadoEnfermo);
		oListaFinalEnferma = new LinkedHashSet<>();		
		oListaFinalEnferma = oCMGanadoEnfermo.consultaAll();		
		Map<String, Object> myModel = new HashMap<String,Object>();
		myModel.put("listGanadoEnfermo", oListaFinalEnferma);
		log.info("Update en controller" + pCEGanadoEnfermo);
		return new ModelAndView(lArchivoRealJsp,"model",myModel);
	}
	
	/*@RequestMapping(value = "eliminarNatalidad.lhs", method=RequestMethod.GET)
	public ModelAndView deleteNatalidad(@PathVariable("CUIA") int CUIA) {
		String lArchivoRealJsp="jspNatalidad";
		oCMNatalidad.deleteNatalidad(CUIA);
		oListaFinal = new LinkedHashSet<>();		
		oListaFinal = oCMNatalidad.consultAllRetiros();		
		Map<String, Object> myModel = new HashMap<String,Object>();
		myModel.put("listNatalidad", oListaFinal);
		return new ModelAndView(lArchivoRealJsp,"model",myModel);
	}*/
	@RequestMapping(value = "ganadoEnfermo/eliminarGanadoEnfermo.lhs/{CUIA}.lhs", method=RequestMethod.GET)
	public ModelAndView deleteGanadoEnfermo(@PathVariable int CUIA) {
		oCMGanadoEnfermo.deleteGanadoEnfermo(CUIA);
		return new ModelAndView("redirect:/ganadoEnfermo/ListadoGanadoEnfermo.lhs");
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}