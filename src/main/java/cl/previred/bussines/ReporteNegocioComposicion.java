package cl.previred.bussines;

import java.io.File;
import java.io.IOException;
import java.io.StringWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;

import cl.previred.client.ClienteServicio;
import cl.previred.exception.ReportServiceException;
import cl.previred.jaxb.Valores;
import cl.previred.jaxb.Valores.UFs.UF;
import cl.previred.vo.DataRequestVO;
import cl.previred.vo.ValoresVO;

@Service
@ConfigurationProperties(prefix = "descarga" )
public class ReporteNegocioComposicion implements ReporteNegocio	{
	
	@Autowired
	ClienteServicio clienteServicioIntegracion;
	
	private String nombreArchivo;
	
	private static final Logger LOGGER = Logger.getLogger(ReporteNegocioComposicion.class);
	
	public File generateArchivo(DataRequestVO dataRequestVO) throws ReportServiceException	{
		File fichero = null;
		switch (dataRequestVO.getFormatoArchivo()) {
			case JSON:
					fichero = generateJson(dataRequestVO);
				break;
			case XML:
					fichero = generateXml(dataRequestVO);
				break;
			case CSV:
					fichero = generateCsv(dataRequestVO);
				break;
		}
		return fichero;
	}
	
	private File generateJson(DataRequestVO dataRequestVO) throws ReportServiceException {
		try {
			Valores valores = clienteServicioIntegracion.obtenerValores(dataRequestVO);
			ValoresVO valoresVO = wrapper(valores);
			
			ObjectMapper mapper = new ObjectMapper();
			String content =  mapper.writeValueAsString( valoresVO );
			
			String nombreFichero = String.format("%s.%s", nombreArchivo , "json");
	
			return Files.write(Paths.get( nombreFichero), content.getBytes()).toFile();
		
		}catch(IOException e) {
			throw new ReportServiceException(e.getMessage());
		}
	}
	
	private File generateCsv(DataRequestVO dataRequestVO) throws ReportServiceException {
		try {
			Valores valores = clienteServicioIntegracion.obtenerValores(dataRequestVO);

			List<List<String>> listCsv = new ArrayList<List<String>>();

			List<String> rowCabecera = Arrays.asList("1", valores.getInicio(), valores.getFin());
			listCsv.add(rowCabecera);
			for (UF uf : valores.getUFs().getUF()) {
				List<String> rowDetalle = Arrays.asList("2", uf.getFecha(), uf.getDato());
				listCsv.add(rowDetalle);
			}

			StringBuilder csvWriter = new StringBuilder();

			for (List<String> rowData : listCsv) {
				csvWriter.append(String.join(";", rowData));
				csvWriter.append(System.lineSeparator());
			}

			String nombreFichero = String.format("%s.%s", nombreArchivo , "csv");
			
			return Files.write(Paths.get( nombreFichero), csvWriter.toString().getBytes()).toFile();

		} catch (Exception exception) {
			throw new ReportServiceException(exception.getMessage());
		}
	}
	
	private File generateXml(DataRequestVO dataRequestVO ) throws ReportServiceException{
		Valores valores = clienteServicioIntegracion.obtenerValores(dataRequestVO);
		File fichero = null;
		String xmlContent = null;
		try {
			if (valores != null) {
				JAXBContext jaxbContext = JAXBContext.newInstance(Valores.class);
				Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
				jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
				StringWriter sw = new StringWriter();
				jaxbMarshaller.marshal(valores, sw);
				xmlContent = sw.toString();
				LOGGER.debug(xmlContent);
				String nombreFichero = String.format("%s.%s", nombreArchivo , "xml");
				fichero = Files.write(Paths.get(nombreFichero), xmlContent.getBytes()).toFile();
			}
		} catch ( IOException | JAXBException e) {
			LOGGER.error("Error en generateXml", e);
			throw new ReportServiceException("Error en generateXml");
		}
		return fichero;
	}
	
	
	protected ValoresVO wrapper(Valores valores) {
		ValoresVO valoresVO = new ValoresVO();
		valoresVO.setInicio(  valores.getInicio());
		valoresVO.setFin( valores.getFin() );
		for( Valores.UFs.UF uf : valores.getUFs().getUF() ) {
			valoresVO.getUFs().add(new ValoresVO.UF( uf.getFecha()  ,uf.getDato() ));	
		}
		return valoresVO;
	}

	public void setNombreArchivo(String nombreArchivo) {
		this.nombreArchivo = nombreArchivo;
	}
}
