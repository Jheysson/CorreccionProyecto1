package pe.unjfsc.daw.logical.impl;

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
		iListaPropi.add(new CEPropietarioInseminacion(120, 564.00, 1.64, "Establo 1", 20.00, "20/09/2020", 1, "Hereford", "N/O"));
		iListaPropi.add(new CEPropietarioInseminacion(220, 614.00, 1.60, "Establo 2", 22.00, "21/09/2020", 1, "Hereford", "N/O"));
		iListaPropi.add(new CEPropietarioInseminacion(320, 584.00, 1.58, "Establo 3", 24.00, "22/09/2020", 1, "Hereford", "N/O"));
		iListaPropi.add(new CEPropietarioInseminacion(420, 604.00, 1.61, "Establo 4", 26.00, "23/09/2020", 1, "Hereford", "N/O"));
		iListaPropi.add(new CEPropietarioInseminacion(520, 542.00, 1.62, "Establo 5", 19.00, "24/09/2020", 1, "Hereford", "N/O"));
		
		
	}
	
	public void savePropiInseminacion(CEPropietarioInseminacion poCEPropiInseminacion) {
		
		log.info("GUARDANDO EN EL REGISTRO CON EL CODIGO "+ poCEPropiInseminacion.getcodigo());
		iListaPropi.add(poCEPropiInseminacion);
		
	}

	public void updatePropiInseminacion(CEPropietarioInseminacion poCEPropiInseminacion) {
		Iterator<CEPropietarioInseminacion> it = iListaPropi.iterator();
		while (it.hasNext()){
			moCEPropieInse = it.next();
			if(moCEPropieInse.getcodigo() == poCEPropiInseminacion.getcodigo()) {
				moCEPropieInse.setcodigo(poCEPropiInseminacion.getcodigo());
				moCEPropieInse.setPeso(poCEPropiInseminacion.getPeso());
				moCEPropieInse.setTalla(poCEPropiInseminacion.getTalla());
				moCEPropieInse.setLugar(poCEPropiInseminacion.getLugar());
				moCEPropieInse.setPrecio(poCEPropiInseminacion.getPrecio());
				moCEPropieInse.setFechcompra(poCEPropiInseminacion.getFechcompra());
				moCEPropieInse.setEstado(poCEPropiInseminacion.getEstado());
				moCEPropieInse.setGenotipo(poCEPropiInseminacion.getGenotipo());
				moCEPropieInse.setObse(poCEPropiInseminacion.getObse());
			}
			log.info("Registro Actualizado"+moCEPropieInse);
		}
	}

	
	public void deletePropiInseminacion(int codigo) {
		
		Iterator<CEPropietarioInseminacion> it = iListaPropi.iterator();
		while(it.hasNext()) {
			// moCENatalidad = new CENatalidad();
			moCEPropieInse = it.next();
			if(moCEPropieInse.getcodigo() == codigo) {
				iListaPropi.remove(moCEPropieInse);
				break;
			}
		}
	}

	public LinkedHashSet<CEPropietarioInseminacion> showAll() {
		return iListaPropi;
	}

	public CEPropietarioInseminacion showBycodigo(int codigo) {
		log.info("MOSTRANDO EL REGISTRO CON EL CODIGO "+ codigo +"...");
		Iterator<CEPropietarioInseminacion> it = iListaPropi.iterator();
		while(it.hasNext()) {
			// moCENatalidad = new CENatalidad();
			moCEPropieInse = it.next();
			if(moCEPropieInse.getcodigo() == codigo) {
				oCEPropietarioInseResponse = moCEPropieInse;
				break;
			}
		}
		
		return oCEPropietarioInseResponse;
	}

	public void setoCEPropietarioInseResponse(CEPropietarioInseminacion oCEPropietarioInseResponse) {
		this.oCEPropietarioInseResponse = oCEPropietarioInseResponse;
	}

}
