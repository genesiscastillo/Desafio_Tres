package cl.previred.client;

import java.time.LocalDate;
import java.util.Date;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.previred.desafio.tres.uf.DatosUf;
import com.previred.desafio.tres.uf.vo.Uf;

import cl.previred.exception.ReportServiceException;
import cl.previred.jaxb.Valores;
import cl.previred.util.Utilitario;
import cl.previred.vo.DataRequestVO;

@Service
public class ClienteServicioIntegracion implements ClienteServicio {
	
	private static final Logger LOGGER = Logger.getLogger(ClienteServicioIntegracion.class);
	
	@Override
	public Valores obtenerValores(DataRequestVO dataRequestVO) throws ReportServiceException {
		LocalDate inicio = dataRequestVO.getFechaInicio();
		LocalDate fin = dataRequestVO.getFechaFin();
		Valores valores = new Valores();
		valores.setInicio( Utilitario.getDateString( inicio ));
		valores.setFin( Utilitario.getDateString(fin ));
		
		fin = fin.plusDays(1);
		
		do {
			try {
				LOGGER.info("fecha a buscar "+Utilitario.getDateString(inicio));
				Date fechaInicio = Utilitario.getDate(inicio);
				Uf uf =	DatosUf.getInstance().getUf(fechaInicio);
				valores.getUFs().add(new Valores.UFs.UF( Utilitario.getDateString(uf.getFecha() ) , uf.getValor().toString()   ));
				
				inicio = inicio.plusDays(1);
				
			}catch(IllegalArgumentException illegalArgumentException){
				String mensaje = String.format("No existe dato para esta fecha %s ", Utilitario.getDateString(inicio ));
				LOGGER.error( mensaje , illegalArgumentException);
				throw new ReportServiceException(mensaje);
			}
		} while (inicio.compareTo(fin) != 0);

		return valores;
	}

}
