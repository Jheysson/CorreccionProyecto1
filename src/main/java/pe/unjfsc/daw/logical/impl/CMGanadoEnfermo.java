package pe.unjfsc.daw.logical.impl;

import java.util.Iterator;
import java.util.LinkedHashSet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import pe.unjfsc.daw.entity.CEGanadoEnfermo;
import pe.unjfsc.daw.logical.CIGanadoEnfermo;

@Component
public class CMGanadoEnfermo implements CIGanadoEnfermo {
	private static final Logger Log = LoggerFactory.getLogger("CMGanadoEnfermo");

	private LinkedHashSet<CEGanadoEnfermo> oListaFinalEnferma;
	private CEGanadoEnfermo moCEGanadoEnfermo;
	private CEGanadoEnfermo oCEGanadoEnfermoResponse;

	public CMGanadoEnfermo() {
		oListaFinalEnferma = new LinkedHashSet<CEGanadoEnfermo>();

		oListaFinalEnferma.add(new CEGanadoEnfermo(1901, "Mastitis", "2020, 10, 1", "Mejora considerable", 1));
		oListaFinalEnferma.add(new CEGanadoEnfermo(1902, "Mastitis", "2020, 10, 3", "Mejora considerable", 1));
		oListaFinalEnferma.add(new CEGanadoEnfermo(1903, "Mastitis", "2020, 10, 3", "Mejora considerable", 1));
		oListaFinalEnferma.add(new CEGanadoEnfermo(1904, "Hemolactea", "2020, 10, 6", "Mejora considerable", 1));
		oListaFinalEnferma.add(new CEGanadoEnfermo(1905, "Hemolactea", "2020, 10, 9", "Mejora considerable", 1));
		oListaFinalEnferma.add(new CEGanadoEnfermo(1906, "Hemolactea", "2020, 10, 13", "Mejora considerable", 1));

	}

	public void saveGanadoEnfermo(CEGanadoEnfermo pCEGanadoEnfermo) {
		Log.info("GUARDANDO EN EL REGISTRO CON EL CUIA" + pCEGanadoEnfermo.getCUIA());
		oListaFinalEnferma.add(pCEGanadoEnfermo);

	}

	public void updateGanadoEnfermo(CEGanadoEnfermo pCEGanadoEnfermo) {
		Iterator<CEGanadoEnfermo> it = oListaFinalEnferma.iterator();

		while (it.hasNext()) {
			moCEGanadoEnfermo = it.next();
			if (moCEGanadoEnfermo.getCUIA() == pCEGanadoEnfermo.getCUIA()) {
				Log.info("ACTUAlIZANDO EL REGISTRO CON EL CUIA" + pCEGanadoEnfermo.getCUIA() + "...");

				moCEGanadoEnfermo.setCUIA(pCEGanadoEnfermo.getCUIA());
				moCEGanadoEnfermo.setEnfermedad(pCEGanadoEnfermo.getEnfermedad());
				moCEGanadoEnfermo.setFechIngreso(pCEGanadoEnfermo.getFechIngreso());
				moCEGanadoEnfermo.setObservacion(pCEGanadoEnfermo.getObservacion());
				moCEGanadoEnfermo.setEstado(pCEGanadoEnfermo.getEstado());

			}

			Log.info("Registro actualizado" + moCEGanadoEnfermo);
		}

	}

	public void deleteGanadoEnfermo(int pCUIA) {
		Iterator<CEGanadoEnfermo> it = oListaFinalEnferma.iterator();

		while (it.hasNext()) {
			moCEGanadoEnfermo = it.next();
			if (moCEGanadoEnfermo.getCUIA() == pCUIA) {
				oListaFinalEnferma.remove(moCEGanadoEnfermo);
				break;
			}
		}

	}

	public LinkedHashSet<CEGanadoEnfermo> consultaAll() {
		return oListaFinalEnferma;
	}

	public CEGanadoEnfermo consultarByCUIA(int pCUIA) {
		Log.info("MOSTRANDO EL REGISTRO" + pCUIA + "...");
		Iterator<CEGanadoEnfermo> it = oListaFinalEnferma.iterator();
		while (it.hasNext()) {
			moCEGanadoEnfermo = it.next();
			if (moCEGanadoEnfermo.getCUIA() == pCUIA) {
				oCEGanadoEnfermoResponse = moCEGanadoEnfermo;
				Log.info("REGISTRANDO EL CUIA" + oCEGanadoEnfermoResponse);
				break;
			}
		}
		return oCEGanadoEnfermoResponse;
	}

	public void setoCEGanadoEnfermoResponse(CEGanadoEnfermo oCEGanadoEnfermoResponse) {
		this.oCEGanadoEnfermoResponse = oCEGanadoEnfermoResponse;
	}

}