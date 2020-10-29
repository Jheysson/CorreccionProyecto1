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

import pe.unjfsc.daw.entity.CEGanadoVacuno;
import pe.unjfsc.daw.logical.impl.CMGanadoVacuno;

@Controller
public class CCGanadoVacuno {

private static final Logger log = LoggerFactory.getLogger("CCGanadoVacuno");
	
	private LinkedHashSet<CEGanadoVacuno> olistaGanadoVacuno;
	
	@Autowired
	private CMGanadoVacuno oCMGanadoVacuno;
	
	@RequestMapping(value = "ganadoVacuno/ListadoGanadoVacuno.lhs")
	public ModelAndView linkedHashSetConsultaGanado() {
		log.info("LISTANDO");
		String lArchivoRealJsp="ganadoVacuno/jspGanadoVacuno";
		String lFechaSistema=(new Date().toString());		
		olistaGanadoVacuno = new LinkedHashSet<CEGanadoVacuno>();	
		olistaGanadoVacuno = oCMGanadoVacuno.consultaAll();		
		Map<String, Object> myModel = new HashMap<String,Object>();
		myModel.put("now", lFechaSistema);
		myModel.put("listGanadoVacuno", olistaGanadoVacuno);
		return new ModelAndView(lArchivoRealJsp,"model",myModel);
	}	
	@RequestMapping(value="ganadoVacuno/agregarGanadoVacuno.lhs", method=RequestMethod.GET)
	public ModelAndView addGanadoVacuno() {
		log.info("FORMULARIO AGREGAR");
		ModelAndView model = new ModelAndView();
		CEGanadoVacuno oCEGanadoVacuno= new CEGanadoVacuno();
		model.addObject("ganadoVacuno/ganadoVacunoForm", oCEGanadoVacuno);
		model.setViewName("ganadoVacuno/ganadoVacunoForm");
		return model;
	}
	
	@RequestMapping(value="ganadoVacuno/saveGanadoVacuno.lhs", method=RequestMethod.POST)
	public ModelAndView saveGanadoVacuno(@ModelAttribute("ganadoVacunoForm") CEGanadoVacuno pCEGanadoVacuno) {
		String IArchivoRealJsp = "ganadoVacuno/jspGanadoVacuno";
		oCMGanadoVacuno.saveGanadoVacuno(pCEGanadoVacuno);
		log.info("PROBANDOOIOOOOOOOOOOOOO:{}",pCEGanadoVacuno);
		olistaGanadoVacuno = new LinkedHashSet<CEGanadoVacuno>();	
		olistaGanadoVacuno = oCMGanadoVacuno.consultaAll();	
		
		Map<String, Object> myModel = new HashMap<String,Object>();
		myModel.put("listGanadoVacuno", olistaGanadoVacuno);
		return new ModelAndView(IArchivoRealJsp,"model",myModel);
	}
	
	@RequestMapping(value="ganadoVacuno/updateGanadoVacuno.lhs/{CUIA}.lhs", method=RequestMethod.GET)
	public ModelAndView updateGanadoVacuno(@PathVariable int CUIA,CEGanadoVacuno pCEGanadoVacuno) {
		ModelAndView model = new ModelAndView();
		CEGanadoVacuno oCEGanadoVacuno = oCMGanadoVacuno.showByCUIA(CUIA);
		model.addObject("ganadoVacuno/ganadoVacunoUpdate", oCEGanadoVacuno);
		model.setViewName("ganadoVacuno/ganadoVacunoUpdate");
		return model;
	}
	@RequestMapping(value = "ganadoVacuno/updateGV.lhs", method=RequestMethod.POST)
	public ModelAndView updateGanadoVacuno(@ModelAttribute("ganadoVacunoUpdate") CEGanadoVacuno pCEGanadoVacuno) {
		String IArchivoRealJsp = "ganadoVacuno/jspGanadoVacuno";
		oCMGanadoVacuno.updateGanadoVacuno(pCEGanadoVacuno);
		olistaGanadoVacuno = new LinkedHashSet<CEGanadoVacuno>();	
		olistaGanadoVacuno = oCMGanadoVacuno.consultaAll();
		Map<String, Object> myModel = new HashMap<String,Object>();
		myModel.put("listGanadoVacuno", olistaGanadoVacuno);
		log.info("Update en controller" + pCEGanadoVacuno);
		return new ModelAndView(IArchivoRealJsp,"model",myModel);
	}
	
	@RequestMapping(value = "ganadoVacuno/eliminarGanadoVacuno.lhs/{cuia}.lhs", method=RequestMethod.GET)
	public ModelAndView deleteGanadoVacuno(@PathVariable int cuia) {
		oCMGanadoVacuno.deleteGanadoVacuno(cuia);
		return new ModelAndView("redirect:/ganadoVacuno/ListadoGanadoVacuno.lhs");
	}
}
