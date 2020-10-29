package pe.unjfsc.daw.entity;


public class CEGanadoEnfermo {

		private int CUIA;
		private String enfermedad;
		private String fechIngreso;
		private String observacion;
		private int Estado;
		public CEGanadoEnfermo() {
			
		}
		public CEGanadoEnfermo (int CUIA, String enfermedad, String fechIngreso, String observacion, int Estado) {
			super();
			this.CUIA = CUIA;
			this.enfermedad = enfermedad;
			this.fechIngreso = fechIngreso;
			this.observacion = observacion;
			this.Estado = Estado;
			
		}
		public int getCUIA() {
			return CUIA;
		}
		public void setCUIA(int cUIA) {
			CUIA = cUIA;
		}
		public String getEnfermedad() {
			return enfermedad;
		}
		public void setEnfermedad(String enfermedad) {
			this.enfermedad = enfermedad;
		}
		public String getFechIngreso() {
			return fechIngreso;
		}
		public void setFechIngreso(String fechIngreso) {
			this.fechIngreso = fechIngreso;
		}
		public String getObservacion() {
			return observacion;
		}
		public void setObservacion(String observacion) {
			this.observacion = observacion;
		}
		public int getEstado() {
			return Estado;
		}
		public void setEstado(int estado) {
			Estado = estado;
		}
		@Override
		public String toString() {
			StringBuilder builder = new StringBuilder();
			builder.append("CEGanadoEnfermo [CUIA=");
			builder.append(CUIA);
			builder.append(", enfermedad=");
			builder.append(enfermedad);
			builder.append(", fechIngreso=");
			builder.append(fechIngreso);
			builder.append(", observacion=");
			builder.append(observacion);
			builder.append(", Estado=");
			builder.append(Estado);
			builder.append("]");
			return builder.toString();
		}
}