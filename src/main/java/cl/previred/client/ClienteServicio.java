package cl.previred.client;

import cl.previred.exception.ReportServiceException;
import cl.previred.jaxb.Valores;
import cl.previred.vo.DataRequestVO;

public interface ClienteServicio {

	Valores obtenerValores(DataRequestVO dataRequestVO) throws ReportServiceException;
	
}
