package cl.previred.enums;

import org.springframework.http.MediaType;

public enum FormatoArchivo {

	JSON(MediaType.APPLICATION_JSON , "json"),
	CSV(MediaType.parseMediaType("text/csv") , "csv"),
	XML(MediaType.parseMediaType("text/xml") , "xml");
	
	private MediaType mediaType;
	private String extension;
	
	FormatoArchivo(MediaType mediaType, String extension) {
		this.mediaType = mediaType;
		this.extension = extension;
	}
	
	public MediaType getMediaType() {
		return this.mediaType;
	}
	
	public String getExtension() {
		return this.extension;
	}
}
