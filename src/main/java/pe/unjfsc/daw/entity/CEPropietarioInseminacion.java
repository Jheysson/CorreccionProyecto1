package pe.unjfsc.daw.entity;

import java.time.LocalDate;

public class CEPropietarioInseminacion {

	
	private int codiPropInse;
	private int idGeno;
	private double pesoPropInse;
	private double tallPropInse;
	private String lugaPropInse;
	private double precPropInse;
	private LocalDate fechCompPropInse;
	private String obse;
	private int esta;
	
	public CEPropietarioInseminacion() {
		
	}

	public CEPropietarioInseminacion(int codiPropInse, int idGeno, double pesoPropInse, double tallPropInse,
			String lugaPropInse, double precPropInse, LocalDate fechCompPropInse, String obse, int esta) {
		super();
		this.codiPropInse = codiPropInse;
		this.idGeno = idGeno;
		this.pesoPropInse = pesoPropInse;
		this.tallPropInse = tallPropInse;
		this.lugaPropInse = lugaPropInse;
		this.precPropInse = precPropInse;
		this.fechCompPropInse = fechCompPropInse;
		this.obse = obse;
		this.esta = esta;
	}

	public int getCodiPropInse() {
		return codiPropInse;
	}

	public void setCodiPropInse(int codiPropInse) {
		this.codiPropInse = codiPropInse;
	}

	public int getIdGeno() {
		return idGeno;
	}

	public void setIdGeno(int idGeno) {
		this.idGeno = idGeno;
	}

	public double getPesoPropInse() {
		return pesoPropInse;
	}

	public void setPesoPropInse(double pesoPropInse) {
		this.pesoPropInse = pesoPropInse;
	}

	public double getTallPropInse() {
		return tallPropInse;
	}

	public void setTallPropInse(double tallPropInse) {
		this.tallPropInse = tallPropInse;
	}

	public String getLugaPropInse() {
		return lugaPropInse;
	}

	public void setLugaPropInse(String lugaPropInse) {
		this.lugaPropInse = lugaPropInse;
	}

	public double getPrecPropInse() {
		return precPropInse;
	}

	public void setPrecPropInse(double precPropInse) {
		this.precPropInse = precPropInse;
	}

	public LocalDate getFechCompPropInse() {
		return fechCompPropInse;
	}

	public void setFechCompPropInse(LocalDate fechCompPropInse) {
		this.fechCompPropInse = fechCompPropInse;
	}

	public String getObse() {
		return obse;
	}

	public void setObse(String obse) {
		this.obse = obse;
	}

	public int getEsta() {
		return esta;
	}

	public void setEsta(int esta) {
		this.esta = esta;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("CEPropietarioInseminacion [codiPropInse=");
		builder.append(codiPropInse);
		builder.append(", idGeno=");
		builder.append(idGeno);
		builder.append(", pesoPropInse=");
		builder.append(pesoPropInse);
		builder.append(", tallPropInse=");
		builder.append(tallPropInse);
		builder.append(", lugaPropInse=");
		builder.append(lugaPropInse);
		builder.append(", precPropInse=");
		builder.append(precPropInse);
		builder.append(", fechCompPropInse=");
		builder.append(fechCompPropInse);
		builder.append(", obse=");
		builder.append(obse);
		builder.append(", esta=");
		builder.append(esta);
		builder.append("]");
		return builder.toString();
	}
	
	
	
}