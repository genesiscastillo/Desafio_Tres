package cl.previred.vo;

import java.time.LocalDate;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import cl.previred.enums.FormatoArchivo;
import cl.previred.util.MyDateDeserializer;
import cl.previred.util.MyFormatoArchivoDesearializer;

public class DataRequestVO {
	
	@JsonDeserialize(using = MyDateDeserializer.class)	
	private LocalDate fechaInicio;
	
	@JsonDeserialize(using = MyDateDeserializer.class)	
	private LocalDate fechaFin;
	
	@JsonDeserialize(using = MyFormatoArchivoDesearializer.class)	
	private FormatoArchivo formatoArchivo;

	public LocalDate getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(LocalDate fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public LocalDate getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(LocalDate fechaFin) {
		this.fechaFin = fechaFin;
	}

	public FormatoArchivo getFormatoArchivo() {
		return formatoArchivo;
	}

	public void setFormatoArchivo(FormatoArchivo formatoArchivo) {
		this.formatoArchivo = formatoArchivo;
	}

	@Override
	public String toString() {
		return "DataRequestVO [fechaInicio=" + fechaInicio + ", fechaFin=" + fechaFin + ", formatoArchivo="
				+ formatoArchivo + "]";
	}
}
