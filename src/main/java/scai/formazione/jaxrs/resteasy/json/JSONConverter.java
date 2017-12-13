package scai.formazione.jaxrs.resteasy.json;

import org.codehaus.jackson.map.ObjectMapper;

import scai.formazione.jaxrs.resteasy.data.Risorsa;

/**
 * Classe JSON Converter
 * 
 * @author Rosario
 *
 */
public class JSONConverter {

	/**
	 * Trasforma un oggetto di tipo Risorsa in una stringa JSON
	 * 
	 * @param risorsa
	 *            Risorsa da convertire in JSON
	 * @return Risorsa in formato JSON
	 * @throws Exception
	 *             come JsonGenerationException, JsonMappingException, IOException
	 */
	public String risorsaToJSON(Risorsa risorsa) throws Exception {
		ObjectMapper mapper = new ObjectMapper();
		String json = "";
		json = mapper.writeValueAsString(risorsa);
		return json;
	}

	/**
	 * Trasforma un oggetto di tipo JSON in uno di tipo Risorsa
	 * 
	 * @param json
	 *            Risorsa in formato JSON
	 * @return Risorsa richiesta
	 * @throws Exception
	 *             come JsonGenerationException, JsonMappingException, IOException
	 */
	public Risorsa jsonToRisorsa(String json) throws Exception {
		ObjectMapper mapper = new ObjectMapper();
		Risorsa risorsa = mapper.readValue(json, Risorsa.class);
		return risorsa;
	}
}
