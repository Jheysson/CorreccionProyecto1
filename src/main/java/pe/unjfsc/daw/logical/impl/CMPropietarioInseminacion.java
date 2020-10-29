package pe.unjfsc.daw.logical.impl;

import java.time.LocalDate;
import java.util.Iterator;
import java.util.LinkedHashSet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import pe.unjfsc.daw.entity.CEPropietarioInseminacion;
import pe.unjfsc.daw.logical.CIPropietarioInseminacion;

@Component
public class CMPropietarioInseminacion implements CIPropietarioInseminacion{
	private static final Logger log = LoggerFactory.getLogger("CMPropietarioInseminacion");
	
	private LinkedHashSet<CEPropietarioInseminacion> iListaPropi;
	private CEPropietarioInseminacion moCEPropieInse;
	private CEPropietarioInseminacion oCEPropietarioInseResponse;
	
	
	public CMPropietarioInseminacion() {
		iListaPropi = new LinkedHashSet<CEPropietarioInseminacion>();
		iListaPropi.add(new CEPropietarioInseminacion(120, 1, 564.00, 1.64, "Establo 1", 20.00, LocalDate.now(), "N/O", 1));
		iListaPropi.add(new CEPropietarioInseminacion(220, 2, 614.00, 1.60, "Establo 2", 22.00, LocalDate.now(), "N/O", 1));
		iListaPropi.add(new CEPropietarioInseminacion(320, 3, 584.00, 1.58, "Establo 3", 24.00, LocalDate.now(), "N/O", 1));
		iListaPropi.add(new CEPropietarioInseminacion(420, 2, 604.00, 1.61, "Establo 4", 26.00, LocalDate.now(), "N/O", 1));
		iListaPropi.add(new CEPropietarioInseminacion(520, 1, 542.00, 1.62, "Establo 5", 19.00, LocalDate.now(), "N/O", 1));
		
		
	}
	public void savePropiInseminacion(CEPropietarioInseminacion poCEPropiInseminacion) {
		
		
		log.info("GUARDANDO EN EL REGISTRO CON EL CODIGO "+ poCEPropiInseminacion.getCodiPropInse());
		iListaPropi.add(poCEPropiInseminacion);
		
	}
	public void updatePropiInseminacion(CEPropietarioInseminacion poCEPropiInseminacion) {
		Iterator<CEPropietarioInseminacion> it = iListaPropi.iterator();
		while (it.hasNext()){
			moCEPropieInse = it.next();
			if(moCEPropieInse.getCodiPropInse() == poCEPropiInseminacion.getCodiPropInse()){
				log.info("ACTUALIZANDO EL REGISTTRO CON EL CODIGO" + poCEPropiInseminacion.getCodiPropInse());
			
				moCEPropieInse.setCodiPropInse(poCEPropiInseminacion.getCodiPropInse());
				moCEPropieInse.setIdGeno(poCEPropiInseminacion.getIdGeno());
				moCEPropieInse.setPesoPropInse(poCEPropiInseminacion.getPesoPropInse());
				moCEPropieInse.setTallPropInse(poCEPropiInseminacion.getTallPropInse());
				moCEPropieInse.setLugaPropInse(poCEPropiInseminacion.getLugaPropInse());
				moCEPropieInse.setPrecPropInse(poCEPropiInseminacion.getPrecPropInse());
				moCEPropieInse.setFechCompPropInse(poCEPropiInseminacion.getFechCompPropInse());
				moCEPropieInse.setObse(poCEPropiInseminacion.getObse());
				moCEPropieInse.setEsta(poCEPropiInseminacion.getEsta());
				
			}
			log.info("Verificar registro Actualizado"+ moCEPropieInse);
		}
		}
	
	public void deletePropiInseminacion(int codiPropInse) {
		
		Iterator<CEPropietarioInseminacion> it = iListaPropi.iterator();
		while(it.hasNext()) {
			// moCENatalidad = new CENatalidad();
			moCEPropieInse = it.next();
			if(moCEPropieInse.getCodiPropInse() == codiPropInse) {
				iListaPropi.remove(moCEPropieInse);
				break;
			}
		}
	}
	public LinkedHashSet<CEPropietarioInseminacion> showAll() {
		return iListaPropi;
	}
	public CEPropietarioInseminacion showBycodigo(int pcodiPropInse) {
		log.info("MOSTRANDO EL REGISTRO CON EL CODIGO "+ pcodiPropInse +"...");
		Iterator<CEPropietarioInseminacion> it = iListaPropi.iterator();
		while(it.hasNext()) {
			// moCENatalidad = new CENatalidad();
			moCEPropieInse = it.next();
			if(moCEPropieInse.getCodiPropInse() == pcodiPropInse) {
				oCEPropietarioInseResponse = moCEPropieInse;
				log.info("REGISTRANDO EL CODIGO" + oCEPropietarioInseResponse);
				
				break;
			}
		}
		
		return oCEPropietarioInseResponse;
	}

	public void setoCEPropietarioInseResponse(CEPropietarioInseminacion oCEPropietarioInseResponse) {
		this.oCEPropietarioInseResponse = oCEPropietarioInseResponse;
	}

	
}
