package cl.previred.vo;

import java.util.ArrayList;
import java.util.List;

public class DataResponseVO {

	private String fechaInicio;
	private String fechaFin;
	
	private List<ValoresVO> ufVOs = new ArrayList<ValoresVO>();
	public String getFechaInicio() {
		return fechaInicio;
	}
	public void setFechaInicio(String fechaInicio) {
		this.fechaInicio = fechaInicio;
	}
	public String getFechaFin() {
		return fechaFin;
	}
	public void setFechaFin(String fechaFin) {
		this.fechaFin = fechaFin;
	}
	public List<ValoresVO> getUfVOs() {
		return ufVOs;
	}
	public void setUfVOs(List<ValoresVO> ufVOs) {
		this.ufVOs = ufVOs;
	}
}
