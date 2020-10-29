package pe.unjfsc.daw.logical.impl;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Iterator;
import java.util.LinkedHashSet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import pe.unjfsc.daw.entity.CEGanadoVacuno;
import pe.unjfsc.daw.logical.CIGanadoVacuno;

@Component
public class CMGanadoVacuno implements CIGanadoVacuno {

private static final Logger log = LoggerFactory.getLogger("CMGanadoVacuno");
	
	private CEGanadoVacuno moCEGanadoVacuno;
	private LinkedHashSet<CEGanadoVacuno> linkedHashSetGanadoVacuno;
	private CEGanadoVacuno oCEGanadoVacunoResponse;
	private CEGanadoVacuno oCEGanadoVacunoRequest;
	
	private String etapa = "";
	private LocalDate fechActual = LocalDate.now();
	
	public CMGanadoVacuno() {
		linkedHashSetGanadoVacuno = new LinkedHashSet<CEGanadoVacuno>();
		linkedHashSetGanadoVacuno.add(new CEGanadoVacuno(2001, calcularEdad("2017-08-16"), 
				"Perla", "2017-08-16",
				500, 1.4, 2, 
				LocalDate.now(), 0, 0, 
				"Niguna", 
				1, //estadoAnimal
				0, //sexo 0=hembra 1=macho
				1, //EstaActivo 0=Seca, 1=Preñada, 2=Produccion
				1, //Origen 0=Autoctono, 1=Comprado 
				1, //TipoGana 0=Leche, 1=Carne 
				1, //Genotipo
				0, //PropInsemin
				asignarEtapa(calcularEdad("2017-08-16"))));
		linkedHashSetGanadoVacuno.add(new CEGanadoVacuno(2002, calcularEdad("2018-08-16"), 
				"Juana", "2018-08-16",
				490, 1.5, 2, 
				LocalDate.now(), 0, 0, 
				"Niguna", 1, 0, 1, 1, 1, 1,
				0,asignarEtapa(calcularEdad("2018-08-16"))));
	}
	@Override
	public void saveGanadoVacuno(CEGanadoVacuno poCEGanadoVacuno) {
		log.info("FECHA ANTES DE SER EVALUADA"+poCEGanadoVacuno.getFecha_nacimiento());
		log.info("MI FECHA ES DE TIPO"+((Object)poCEGanadoVacuno.getFecha_nacimiento().getClass().getSimpleName()));
		boolean madreApta = buscarMadre(poCEGanadoVacuno);
		boolean verifExistente = verificarExiste(poCEGanadoVacuno);
		if (madreApta && verifExistente) {
			linkedHashSetGanadoVacuno.add(new CEGanadoVacuno(
					/*
					poCEGanadoVacuno.getAliasGanadoVacuno(),
					poCEGanadoVacuno.getFecha_nacimiento(),//LocalDate.of(2017, 3, 5),
					poCEGanadoVacuno.getSexo(),
					calcularEdad(poCEGanadoVacuno.getFecha_nacimiento()), 
					asignarEtapa(calcularEdad(poCEGanadoVacuno.getFecha_nacimiento())),
					poCEGanadoVacuno.getPeso(), 
					poCEGanadoVacuno.getTalla(),
					poCEGanadoVacuno.getEstaActivo(),
					poCEGanadoVacuno.getEstaAnim(), 
					poCEGanadoVacuno.getGenotipo(), 
					poCEGanadoVacuno.getTipoGana(), 
					poCEGanadoVacuno.getOrigen(), 
					poCEGanadoVacuno.getCuiaPadre(),
					poCEGanadoVacuno.getCuiaMadre()*/
					poCEGanadoVacuno.getCuia(),
					calcularEdad(poCEGanadoVacuno.getFecha_nacimiento()),
					poCEGanadoVacuno.getAliasGanadoVacuno(),
					poCEGanadoVacuno.getFecha_nacimiento(),
					poCEGanadoVacuno.getPeso(),
					poCEGanadoVacuno.getTalla(),
					poCEGanadoVacuno.getCantiPartGana(),
					LocalDate.now(),
					poCEGanadoVacuno.getCuiaMadre(),
					poCEGanadoVacuno.getCuiaPadre(),
					poCEGanadoVacuno.getObse(),
					1,
					poCEGanadoVacuno.getIdSexo(),
					poCEGanadoVacuno.getIdEstaActiv(),
					poCEGanadoVacuno.getIdOrig(),
					poCEGanadoVacuno.getIdTipoGana(),
					poCEGanadoVacuno.getIdGeno(),0,
					asignarEtapa(calcularEdad(poCEGanadoVacuno.getFecha_nacimiento()))
					));
		}else {
			log.info("NO SE PUDO REGISTRAR");
		}
		
	}

	@Override
	public void updateGanadoVacuno(CEGanadoVacuno poCEGanadoVacuno) {
		Iterator<CEGanadoVacuno> it = linkedHashSetGanadoVacuno.iterator();
		
		while(it.hasNext()) {
			moCEGanadoVacuno = it.next();
			if (moCEGanadoVacuno.getCuia() == poCEGanadoVacuno.getCuia()) {
				log.info("ACTUALIZANDO EL REGISTRO CON EL CUIA "+poCEGanadoVacuno.getCuia()+"...");
				
				/*moCEGanadoVacuno.setAliasGanadoVacuno(poCEGanadoVacuno.getAliasGanadoVacuno());
				moCEGanadoVacuno.setCuiaMadre(poCEGanadoVacuno.getCuiaMadre());
				moCEGanadoVacuno.setCuiaPadre(poCEGanadoVacuno.getCuiaPadre());
				moCEGanadoVacuno.setEdad(calcularEdad(poCEGanadoVacuno.getFecha_nacimiento()));
				moCEGanadoVacuno.setEstaActivo(poCEGanadoVacuno.getEstaActivo());
				moCEGanadoVacuno.setEstaAnim(poCEGanadoVacuno.getEstaAnim());
				moCEGanadoVacuno.setFecha_nacimiento(poCEGanadoVacuno.getFecha_nacimiento());
				moCEGanadoVacuno.setEtapa(asignarEtapa(calcularEdad(poCEGanadoVacuno.getFecha_nacimiento())));
				moCEGanadoVacuno.setGenotipo(poCEGanadoVacuno.getGenotipo());
				moCEGanadoVacuno.setOrigen(poCEGanadoVacuno.getOrigen());
				
				*/
			}
		}
		log.info("Verificar actualización: {}",consultaAll());
		
	}

	@Override
	public void deleteGanadoVacuno(int CUIA) {
		Iterator<CEGanadoVacuno> it = linkedHashSetGanadoVacuno.iterator();
		
		while(it.hasNext()) {
			moCEGanadoVacuno = it.next();
			
			if (moCEGanadoVacuno.getCuia() == CUIA) {
				linkedHashSetGanadoVacuno.remove(moCEGanadoVacuno);
				break;
			}
		}
		
	}

	@Override
	public LinkedHashSet<CEGanadoVacuno> consultaAll() {
		log.info("TODOS LOS REGISTROS: {}",linkedHashSetGanadoVacuno);
		return linkedHashSetGanadoVacuno;
	}

	@Override
	public CEGanadoVacuno showByCUIA(int CUIA) {
		log.info("BUSCANDO REGISTRO CON EL CUIA "+CUIA+":");
		Iterator<CEGanadoVacuno> it = linkedHashSetGanadoVacuno.iterator();
		
		while(it.hasNext()) {
			moCEGanadoVacuno = it.next();
			if (moCEGanadoVacuno.getCuia() == CUIA) {
				oCEGanadoVacunoResponse = moCEGanadoVacuno;
				break;
			}
		}
		log.info("{}",oCEGanadoVacunoResponse);
		return oCEGanadoVacunoResponse;
	}protected int calcularEdad(String fechaNaci) {	
		log.info("LLEGANDO FECHA A CALCULAR EDAD:"+ fechaNaci);		
		int edad = (int) ChronoUnit.MONTHS.between(LocalDate.parse(fechaNaci), fechActual);
		log.info("RETORNANDO EDAD "+edad);
		return edad;
	}
	protected String asignarEtapa(int edad) {
		log.info("RECIBIENDO LA EDAD PARA RETORNAR ETAPA: "+edad);
		if(edad <= 4) {
			etapa = "Ternero(a)";
		}else if(edad > 4 && edad <=12) {
			etapa = "Destete";
		}else if(edad > 12 && edad <=24) {
			etapa = "Becerro(a)";
		}else if(edad >= 24) {
			etapa = "Adulto";
		}
		log.info("RETORNANDO LA ETAPA...: "+etapa);
		return etapa;
		
	}protected boolean buscarMadre(CEGanadoVacuno oCEGanadoVacuno) {
		boolean rpta = false;
		log.info("VERIFICANDO EL CUIA DE MADRE "+oCEGanadoVacuno.getCuiaMadre()+" EN LOS REGISTROS");
		if (oCEGanadoVacuno.getCuiaMadre() !=0) {
			Iterator<CEGanadoVacuno> it = linkedHashSetGanadoVacuno.iterator();
			while(it.hasNext()) {
				moCEGanadoVacuno = it.next();

					if (moCEGanadoVacuno.getCuia() == oCEGanadoVacuno.getCuiaMadre()) {
						log.info("SE ENCONTRÓ EL CUIA INGRESADO DE LA MADRE EN LOS REGISTROS ACTUALES");
						if (moCEGanadoVacuno.getIdSexo()==0 && moCEGanadoVacuno.getEdad()>18) {
							log.info("SE VALIDÓ COMO HEMBRA APTA");
							rpta = true;
							break;
						}else {
							log.info("EL CUIA DE LA MADRE INGRESADO ES DE UNA BOVINA NO APTA PARA SER MADRE");
							rpta = false;
							break;
						}
					}else {
						//No se encuentra el registro de la madre
						rpta = false;
					}
				
			}
		}else {
			rpta = true;
		}
		
		return rpta;
		
	}protected boolean verificarExiste(CEGanadoVacuno oCEGanadoVacuno) {
		boolean rpta = false;
		
		Iterator<CEGanadoVacuno> it = linkedHashSetGanadoVacuno.iterator();
		
		while(it.hasNext()) {
			moCEGanadoVacuno = it.next();

				if (moCEGanadoVacuno.getCuia() == oCEGanadoVacuno.getCuia()) {
					log.info("EL CUIA QUE SE INTENTA REGISTRAR YA EXISTE");
					rpta = false;
					break;
				}else {
					rpta = true;
				}
			
		}
		return rpta;
	}
	
	public void setoCEGanadoVacunoResponse(CEGanadoVacuno oCEGanadoVacunoResponse) {
		this.oCEGanadoVacunoResponse = oCEGanadoVacunoResponse;
	}
	public void setoCEGanadoVacunoRequest(CEGanadoVacuno oCEGanadoVacunoRequest) {
		this.oCEGanadoVacunoRequest = oCEGanadoVacunoRequest;
	}

}
