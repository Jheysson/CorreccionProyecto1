package pe.unjfsc.daw.entity;

import java.time.LocalDate;

public class CEGanadoVacuno {
	private int cuia;
	private int edad;
	private String aliasGanadoVacuno;
	private String fecha_nacimiento;
	private double peso;
	private double talla;
	private int cantiPartGana;
	private LocalDate fechActuGana;
	private int cuiaMadre;
	private int cuiaPadre;
	private String obse;
	private int esta;
	
	private int idSexo;
	private int idEstaActiv;
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
		this.cuia = cuia;
		this.edad = edad;
		this.aliasGanadoVacuno = aliasGanadoVacuno;
		this.fecha_nacimiento = fecha_nacimiento;
		this.peso = peso;
		this.talla = talla;
		this.cantiPartGana = cantiPartGana;
		this.fechActuGana = fechActuGana;
		this.cuiaMadre = cuiaMadre;
		this.cuiaPadre = cuiaPadre;
		this.obse = obse;
		this.esta = esta;
		this.idSexo = idSexo;
		this.idEstaActiv = idEstaActiv;
		this.idOrig = idOrig;
		this.idTipoGana = idTipoGana;
		this.idGeno = idGeno;
		this.idPropInse = idPropInse;
		this.etapa = etapa;
	}



	public int getCuia() {
		return cuia;
	}



	public void setCuia(int cuia) {
		this.cuia = cuia;
	}



	public int getEdad() {
		return edad;
	}



	public void setEdad(int edad) {
		this.edad = edad;
	}



	public String getAliasGanadoVacuno() {
		return aliasGanadoVacuno;
	}



	public void setAliasGanadoVacuno(String aliasGanadoVacuno) {
		this.aliasGanadoVacuno = aliasGanadoVacuno;
	}



	public String getFecha_nacimiento() {
		return fecha_nacimiento;
	}



	public void setFecha_nacimiento(String fecha_nacimiento) {
		this.fecha_nacimiento = fecha_nacimiento;
	}



	public double getPeso() {
		return peso;
	}



	public void setPeso(double peso) {
		this.peso = peso;
	}



	public double getTalla() {
		return talla;
	}



	public void setTalla(double talla) {
		this.talla = talla;
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



	public int getCuiaMadre() {
		return cuiaMadre;
	}



	public void setCuiaMadre(int cuiaMadre) {
		this.cuiaMadre = cuiaMadre;
	}



	public int getCuiaPadre() {
		return cuiaPadre;
	}



	public void setCuiaPadre(int cuiaPadre) {
		this.cuiaPadre = cuiaPadre;
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



	public int getIdEstaActiv() {
		return idEstaActiv;
	}



	public void setIdEstaActiv(int idEstaActiv) {
		this.idEstaActiv = idEstaActiv;
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
		etapa = etapa;
	}



	@Override
	public String toString() {
		return "CEGanadoVacuno [cuia=" + cuia + ", edad=" + edad + ", aliasGanadoVacuno=" + aliasGanadoVacuno
				+ ", fecha_nacimiento=" + fecha_nacimiento + ", peso=" + peso + ", talla=" + talla + ", cantiPartGana="
				+ cantiPartGana + ", fechActuGana=" + fechActuGana + ", cuiaMadre=" + cuiaMadre + ", cuiaPadre="
				+ cuiaPadre + ", obse=" + obse + ", esta=" + esta + ", idSexo=" + idSexo + ", idEstaActiv="
				+ idEstaActiv + ", idOrig=" + idOrig + ", idTipoGana=" + idTipoGana + ", idGeno=" + idGeno
				+ ", idPropInse=" + idPropInse + ", Etapa=" + etapa + "]";
	}

	

	
}
