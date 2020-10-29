package pe.unjfsc.daw.entity;


public class CEGanadoEnfermo {

		private int idGana;
		private int idEnfe;
		private String fechIngr;
		private String obse;
		private int esta;
		public CEGanadoEnfermo() {
			
		}
		public CEGanadoEnfermo (int idGana, int idEnfe, String fechIngr, String obse, int esta) {
			super();
			this.idGana = idGana;
			this.idEnfe = idEnfe;
			this.fechIngr = fechIngr;
			this.obse = obse;
			this.esta = esta;
			
		}
		public int getIdGana() {
			return idGana;
		}
		public void setIdGana(int idGana) {
			this.idGana = idGana;
		}
		public int getIdEnfe() {
			return idEnfe;
		}
		public void setIdEnfe(int idEnfe) {
			this.idEnfe = idEnfe;
		}
		public String getFechIngr() {
			return fechIngr;
		}
		public void setFechIngr(String fechIngr) {
			this.fechIngr = fechIngr;
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
			builder.append("CEGanadoEnfermo [idGana=");
			builder.append(idGana);
			builder.append(", idEnfe=");
			builder.append(idEnfe);
			builder.append(", fechIngr=");
			builder.append(fechIngr);
			builder.append(", obse=");
			builder.append(obse);
			builder.append(", esta=");
			builder.append(esta);
			builder.append("]");
			return builder.toString();
		}
		
}