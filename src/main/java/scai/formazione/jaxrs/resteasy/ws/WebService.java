package scai.formazione.jaxrs.resteasy.ws;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

import scai.formazione.jaxrs.resteasy.data.Risorsa;
import scai.formazione.jaxrs.resteasy.data.doa.DOA;
import scai.formazione.jaxrs.resteasy.data.doa.DOAImpl;

/**
 * 
 * @author Rosario
 *
 */
@Path("/WebService")
public class WebService {

	private DOA dataAccessRisorse = new DOAImpl();

	/**
	 * Restituisce la risorsa richiesta nella query string
	 * 
	 * @param idRisorsa
	 *            Identificativo risorsa
	 * @return Response contenente la risorsa richiesta
	 */
	@GET
	@Path("/lettura")
	public Response leggiRisorsa(@QueryParam("ID") String idRisorsa) {
		Risorsa risorsa = dataAccessRisorse.leggiRisorsa(idRisorsa);
		return Response.status(200).entity(risorsa.toString()).build();
	}
}
