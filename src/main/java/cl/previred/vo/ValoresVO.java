package cl.previred.vo;

import java.util.ArrayList;
import java.util.List;

public class ValoresVO {
	
	private String inicio;
	private String fin;
	private List<UF> UFs = new ArrayList<>();
	
	public String getInicio() {
		return inicio;
	}

	public void setInicio(String inicio) {
		this.inicio = inicio;
	}

	public String getFin() {
		return fin;
	}

	public void setFin(String fin) {
		this.fin = fin;
	}

	public List<UF> getUFs() {
		return UFs;
	}

	public void setUFs(List<UF> uFs) {
		UFs = uFs;
	}

	public void add(UF uf) {
		this.getUFs().add(uf);
	}
	
	public static class UF {
		private String fecha;
		private String dato;
		
		public UF(String fecha , String dato) {
			this.fecha = fecha;
			this.dato = dato;
		}
		
		public String getFecha() {
			return fecha;
		}
		public void setFecha(String fecha) {
			this.fecha = fecha;
		}
		public String getDato() {
			return dato;
		}
		public void setDato(String dato) {
			this.dato = dato;
		}
	}
}