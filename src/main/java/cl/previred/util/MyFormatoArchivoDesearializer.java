package cl.previred.util;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import cl.previred.enums.FormatoArchivo;

public class MyFormatoArchivoDesearializer extends JsonDeserializer<FormatoArchivo> {


	@Override
	public FormatoArchivo deserialize(JsonParser jsonParser, DeserializationContext deserializationContext)
			throws IOException, JsonProcessingException {
		String formatoTipo = jsonParser.getText();

		try {
			return FormatoArchivo.valueOf(formatoTipo);
		} catch (IllegalArgumentException e) {
			throw new IOException("tipo de formato inválido", e);
		}
	}
}