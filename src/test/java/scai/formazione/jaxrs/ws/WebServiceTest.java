package scai.formazione.jaxrs.ws;

import static org.junit.Assert.*;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

import org.junit.Test;

import scai.formazione.jaxrs.resteasy.data.Risorsa;
import scai.formazione.jaxrs.resteasy.json.JSONConverter;

/**
 * Test JUnit con chiamata ai metodi offerti dal Web Service
 * 
 * @author Rosario
 *
 */
public class WebServiceTest {

	private Client client = ClientBuilder.newBuilder().build();
	private JSONConverter jsonConverter = new JSONConverter();
	private WebTarget target;
	private Response response;
	private static int numeroRisorse = 3;

	/**
	 * Test di verifica per metodo "leggiRisorsa"
	 * 
	 * @throws Exception
	 *             come JsonGenerationException, JsonMappingException, IOException
	 */
	@Test
	public void testLeggiRisorsa() throws Exception {
		String idRisorsaTest = "0";
		target = client.target("http://localhost:8080/JAXRS/rest/WebService/read/resource?ID=" + idRisorsaTest);
		response = target.request().get();
		String jsonRisorsa = response.readEntity(String.class);
		Risorsa risorsa = jsonConverter.jsonToRisorsa(jsonRisorsa);
		assertEquals(risorsa.getIdRisorsa(), idRisorsaTest);
	}

	/**
	 * Test di verifica per metodo "leggiTutteRisorse"
	 * 
	 * @throws Exception
	 *             come JsonGenerationException, JsonMappingException, IOException
	 */
	@Test
	public void testLeggiTutteRisorse() throws Exception {
		target = client.target("http://localhost:8080/JAXRS/rest/WebService/read");
		response = target.request().get();
		String jsonTutteRisorse = response.readEntity(String.class);
		String[] parserRisorse = jsonTutteRisorse.split("\n");
		assertEquals(numeroRisorse, parserRisorse.length);
	}

	/**
	 * Test di verifica per metodo "eliminaRisorsa"
	 * 
	 * @throws Exception
	 *             come JsonGenerationException, JsonMappingException, IOException
	 */
	@Test
	public void testEliminaRisorsa() throws Exception {
		String idRisorsaTest = "2";
		target = client.target("http://localhost:8080/JAXRS/rest/WebService/delete/resource?ID=" + idRisorsaTest);
		response = target.request().delete();
		/* Reinizializzazione del client per nuova chiamata al Web Service */
		client = ClientBuilder.newBuilder().build();
		target = client.target("http://localhost:8080/JAXRS/rest/WebService/read");
		response = target.request().get();
		String jsonTutteRisorse = response.readEntity(String.class);
		String[] parserRisorse = jsonTutteRisorse.split("\n");
		assertEquals(--numeroRisorse, parserRisorse.length);
	}
}
