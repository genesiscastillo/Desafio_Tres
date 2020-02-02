package cl.previred.rest;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import cl.previred.bussines.ReporteNegocioComposicion;
import cl.previred.exception.ReportServiceException;
import cl.previred.vo.DataRequestVO;

@RestController
@RequestMapping("/desafioTres")
@ConfigurationProperties(prefix = "descarga")
public class PreviredRest {

	@Autowired
	ReporteNegocioComposicion reporteNegocio;
	
	private String nombreArchivo;

	@SuppressWarnings({ "rawtypes" })
	@RequestMapping(value = "/valores", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.ALL_VALUE)
	public ResponseEntity execute(@RequestBody DataRequestVO dataRequestVO) {
		try {
			System.out.println(dataRequestVO);

			File file = reporteNegocio.generateArchivo(dataRequestVO);

			return ResponseEntity.ok()
					.header("Content-Disposition", "attachment; filename=" + nombreArchivo + dataRequestVO.getFormatoArchivo().getExtension())
					.contentLength(file.length()).contentType(dataRequestVO.getFormatoArchivo().getMediaType())
					.body(new FileSystemResource(file));
			
		} catch (ReportServiceException ex) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage(), ex);
		}
	}
	
	public void setNombreArchivo(String nombreArchivo) {
		this.nombreArchivo = nombreArchivo;
	}
}
