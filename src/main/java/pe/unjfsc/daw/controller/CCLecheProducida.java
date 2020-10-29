package pe.unjfsc.daw.controller;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import pe.unjfsc.daw.entity.CELecheProducidaDia;
import pe.unjfsc.daw.logical.impl.CMILecheProducidaDia;

@Controller
public class CCLecheProducida {
	
	private LinkedHashSet<CELecheProducidaDia> oListaFinalLecheProducida;
	@Autowired
	private CMILecheProducidaDia oCMILecheProducidaDia;
	
		@RequestMapping(value = "lecheProducida/jspProducionLeche.lhs")
		public ModelAndView linkedHashSetConsulta() {
			String lArchivoRealJsp="lecheProducida/jspProducionLeche";
			oListaFinalLecheProducida = new LinkedHashSet<CELecheProducidaDia>();	
			oListaFinalLecheProducida = oCMILecheProducidaDia.consultaAll();		
			Map<String, Object> myModel = new HashMap<String,Object>();
			myModel.put("listLecheProducida", oListaFinalLecheProducida);
			return new ModelAndView(lArchivoRealJsp,"model",myModel);
		}
		
		@RequestMapping(value="lecheProducida/agregarProduccionLecheForm.lhs", method=RequestMethod.GET)
		public ModelAndView addProduccionLeche() {
			ModelAndView model = new ModelAndView();
			CELecheProducidaDia pCELecheProducidaDia = new CELecheProducidaDia();
			model.addObject("lecheProducida/ProduccionLecheForm", pCELecheProducidaDia);
			model.setViewName("lecheProducida/ProduccionLecheForm");
			return model;
		}
		
		@RequestMapping(value="lecheProducida/save.lhs", method=RequestMethod.POST)
		public ModelAndView saveLecheProducida(@ModelAttribute("ProduccionLecheForm") CELecheProducidaDia pCELecheProducidaDia) {
			String lArchivoRealJsp="lecheProducida/jspProducionLeche";
			oCMILecheProducidaDia.saveLecheProducidaDia(pCELecheProducidaDia);
			oListaFinalLecheProducida = new LinkedHashSet<>();		
			oListaFinalLecheProducida = oCMILecheProducidaDia.consultaAll();		
			Map<String, Object> myModel = new HashMap<String,Object>();
			myModel.put("listLecheProducida", oListaFinalLecheProducida);
			return new ModelAndView(lArchivoRealJsp,"model",myModel);
		}
		
		@RequestMapping(value="lecheProducida/updateProduccionLeche.lhs/{idLechProd}.lhs", method=RequestMethod.GET)
		public ModelAndView updateLecheProducida(@PathVariable int idLechProd,CELecheProducidaDia pCELecheProducidaDia) {
			ModelAndView model = new ModelAndView();
			CELecheProducidaDia pCE2LecheProducidaDia = oCMILecheProducidaDia.consultarById(idLechProd);
			model.addObject("lecheProducida/produccionLecheFromUpdate", pCE2LecheProducidaDia);
			model.setViewName("lecheProducida/produccionLecheFromUpdate");
			return model;
		}
		
		@RequestMapping(value = "lecheProducida/update.lhs", method=RequestMethod.POST)
		public ModelAndView updateLecheProducida(@ModelAttribute("produccionLecheFromUpdate") CELecheProducidaDia pCELecheProducidaDia ) {
			String lArchivoRealJsp="lecheProducida/jspProducionLeche";
			oCMILecheProducidaDia.updateLecheProducidaDia(pCELecheProducidaDia);
			oListaFinalLecheProducida = new LinkedHashSet<>();		
			oListaFinalLecheProducida = oCMILecheProducidaDia.consultaAll();		
			Map<String, Object> myModel = new HashMap<String,Object>();
			myModel.put("listLecheProducida", oListaFinalLecheProducida);
			return new ModelAndView(lArchivoRealJsp,"model",myModel);
		}
	
		@RequestMapping(value = "lecheProducida/eliminarProduccionLeche.lhs/{idLechProd}.lhs", method=RequestMethod.GET)
		public ModelAndView deleteLecgeProducida(@PathVariable int idLechProd) {
			oCMILecheProducidaDia.deleteLecheProducidaDia(idLechProd);
			return new ModelAndView("redirect:/lecheProducida/jspProducionLeche.lhs");
		}

}










