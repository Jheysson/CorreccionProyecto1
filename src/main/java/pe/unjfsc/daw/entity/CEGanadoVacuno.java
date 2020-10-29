package pe.unjfsc.daw.entity;

import java.time.LocalDate;

public class CEGanadoVacuno {
	private int cuiaGana;
	private int edadGana;
	private String aliaGana;
	private String fechNaciGana;
	private double pesoGana;
	private double tallGana;
	private int cantiPartGana;
	private LocalDate fechActuGana;
	private int cuiaMadr;
	private int cuiaPadr;
	private String obse;
	private int esta;
	
	private int idSexo;
	private int idEstaActi;
	private int idOrig;
	private int idTipoGana;
	private int idGeno;
	private int idPropInse;
	private String etapa;
	
	

	public CEGanadoVacuno() {
		 
	}



	public CEGanadoVacuno(int cuia, int edad, String aliasGanadoVacuno, String fecha_nacimiento, double peso,
			double talla, int cantiPartGana, LocalDate fechActuGana, int cuiaMadre, int cuiaPadre, String obse,
			int esta, int idSexo, int idEstaActiv, int idOrig, int idTipoGana, int idGeno, int idPropInse,
			String etapa) {
		super();
		this.cuiaGana = cuia;
		this.edadGana = edad;
		this.aliaGana = aliasGanadoVacuno;
		this.fechNaciGana = fecha_nacimiento;
		this.pesoGana = peso;
		this.tallGana = talla;
		this.cantiPartGana = cantiPartGana;
		this.fechActuGana = fechActuGana;
		this.cuiaMadr = cuiaMadre;
		this.cuiaPadr = cuiaPadre;
		this.obse = obse;
		this.esta = esta;
		this.idSexo = idSexo;
		this.idEstaActi = idEstaActiv;
		this.idOrig = idOrig;
		this.idTipoGana = idTipoGana;
		this.idGeno = idGeno;
		this.idPropInse = idPropInse;
		this.etapa = etapa;
	}



	public int getCuiaGana() {
		return cuiaGana;
	}



	public void setCuiaGana(int cuiaGana) {
		this.cuiaGana = cuiaGana;
	}



	public int getEdadGana() {
		return edadGana;
	}



	public void setEdadGana(int edadGana) {
		this.edadGana = edadGana;
	}



	public String getAliaGana() {
		return aliaGana;
	}



	public void setAliaGana(String aliaGana) {
		this.aliaGana = aliaGana;
	}



	public String getFechNaciGana() {
		return fechNaciGana;
	}



	public void setFechNaciGana(String fechNaciGana) {
		this.fechNaciGana = fechNaciGana;
	}



	public double getPesoGana() {
		return pesoGana;
	}



	public void setPesoGana(double pesoGana) {
		this.pesoGana = pesoGana;
	}



	public double getTallGana() {
		return tallGana;
	}



	public void setTallGana(double tallGana) {
		this.tallGana = tallGana;
	}



	public int getCantiPartGana() {
		return cantiPartGana;
	}



	public void setCantiPartGana(int cantiPartGana) {
		this.cantiPartGana = cantiPartGana;
	}



	public LocalDate getFechActuGana() {
		return fechActuGana;
	}



	public void setFechActuGana(LocalDate fechActuGana) {
		this.fechActuGana = fechActuGana;
	}



	public int getCuiaMadr() {
		return cuiaMadr;
	}



	public void setCuiaMadr(int cuiaMadr) {
		this.cuiaMadr = cuiaMadr;
	}



	public int getCuiaPadr() {
		return cuiaPadr;
	}



	public void setCuiaPadr(int cuiaPadr) {
		this.cuiaPadr = cuiaPadr;
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



	public int getIdSexo() {
		return idSexo;
	}



	public void setIdSexo(int idSexo) {
		this.idSexo = idSexo;
	}



	public int getIdEstaActi() {
		return idEstaActi;
	}



	public void setIdEstaActi(int idEstaActi) {
		this.idEstaActi = idEstaActi;
	}



	public int getIdOrig() {
		return idOrig;
	}



	public void setIdOrig(int idOrig) {
		this.idOrig = idOrig;
	}



	public int getIdTipoGana() {
		return idTipoGana;
	}



	public void setIdTipoGana(int idTipoGana) {
		this.idTipoGana = idTipoGana;
	}



	public int getIdGeno() {
		return idGeno;
	}



	public void setIdGeno(int idGeno) {
		this.idGeno = idGeno;
	}



	public int getIdPropInse() {
		return idPropInse;
	}



	public void setIdPropInse(int idPropInse) {
		this.idPropInse = idPropInse;
	}



	public String getEtapa() {
		return etapa;
	}



	public void setEtapa(String etapa) {
		this.etapa = etapa;
	}



	@Override
	public String toString() {
		return "CEGanadoVacuno [cuiaGana=" + cuiaGana + ", edadGana=" + edadGana + ", aliaGana=" + aliaGana
				+ ", fechNaciGana=" + fechNaciGana + ", pesoGana=" + pesoGana + ", tallGana=" + tallGana
				+ ", cantiPartGana=" + cantiPartGana + ", fechActuGana=" + fechActuGana + ", cuiaMadr=" + cuiaMadr
				+ ", cuiaPadr=" + cuiaPadr + ", obse=" + obse + ", esta=" + esta + ", idSexo=" + idSexo
				+ ", idEstaActi=" + idEstaActi + ", idOrig=" + idOrig + ", idTipoGana=" + idTipoGana + ", idGeno="
				+ idGeno + ", idPropInse=" + idPropInse + ", etapa=" + etapa + "]";
	}



	
	
}
