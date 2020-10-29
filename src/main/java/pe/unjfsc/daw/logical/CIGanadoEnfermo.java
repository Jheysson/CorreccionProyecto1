package pe.unjfsc.daw.logical;


import java.util.LinkedHashSet;

import pe.unjfsc.daw.entity.CEGanadoEnfermo;

public interface CIGanadoEnfermo {
	public void saveGanadoEnfermo (CEGanadoEnfermo pCEGanadoEnfermo);
	public void updateGanadoEnfermo (CEGanadoEnfermo pCEGanadoEnfermo);
	public void deleteGanadoEnfermo (int pCUIA);
	public LinkedHashSet<CEGanadoEnfermo> consultaAll();
	public CEGanadoEnfermo consultarByCUIA (int pCUIA);
	

}
