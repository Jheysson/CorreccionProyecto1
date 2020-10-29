package pe.unjfsc.daw.logical;


import java.util.LinkedHashSet;

import pe.unjfsc.daw.entity.CEPropietarioInseminacion;

public interface CIPropietarioInseminacion {
	
	public void savePropiInseminacion(CEPropietarioInseminacion poCEPropiInseminacion);
	public void updatePropiInseminacion(CEPropietarioInseminacion poCEPropiInseminacion);
	public void deletePropiInseminacion(int codiPropInse);
	public LinkedHashSet<CEPropietarioInseminacion> showAll();
	public CEPropietarioInseminacion showBycodigo(int codiPropInse);

}
