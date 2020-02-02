package cl.previred.bussines;

import java.io.File;

import cl.previred.exception.ReportServiceException;
import cl.previred.vo.DataRequestVO;

public interface ReporteNegocio {

	File generateArchivo(DataRequestVO dataRequestVO) throws ReportServiceException;
	
}
