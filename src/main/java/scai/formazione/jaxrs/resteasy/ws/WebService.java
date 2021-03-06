package scai.formazione.jaxrs.resteasy.ws;

import java.util.ArrayList;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

import scai.formazione.jaxrs.resteasy.data.Risorsa;
import scai.formazione.jaxrs.resteasy.data.doa.DOA;
import scai.formazione.jaxrs.resteasy.data.doa.DOAImpl;
import scai.formazione.jaxrs.resteasy.json.JSONConverter;

/**
 * Classe di implementazione del mio web service
 * 
 * @author Rosario
 *
 */
@Path("/WebService")
public class WebService {

	private DOA dataAccessRisorse = new DOAImpl();
	private JSONConverter jsonConverter = new JSONConverter();

	/**
	 * Restituisce la risorsa richiesta nella query string
	 * 
	 * @param idRisorsa
	 *            Identificativo risorsa
	 * @return Response contenente la risorsa richiesta
	 */
	@GET
	@Path("/read/resource")
	@Produces("application/json")
	public Response leggiRisorsa(@QueryParam("ID") String idRisorsa) throws Exception {
		Risorsa risorsa = dataAccessRisorse.leggiRisorsa(idRisorsa);
		String jsonRisorsa = jsonConverter.risorsaToJSON(risorsa);
		return Response.status(200).entity(jsonRisorsa).build();
	}

	/**
	 * Restituisce tutte le risorse richieste
	 * 
	 * @return Response contenente tutte le risorse richieste
	 */
	@GET
	@Path("/read")
	@Produces("application/json")
	public Response leggiTutteRisorse() throws Exception {
		ArrayList<Risorsa> listRisorse = null;
		listRisorse = dataAccessRisorse.leggiTutteRisorse();
		StringBuilder stringBuilder = new StringBuilder();
		for (Risorsa itRisorsa : listRisorse) {
			stringBuilder.append(jsonConverter.risorsaToJSON(itRisorsa));
			stringBuilder.append("\n");
		}
		return Response.status(200).entity(stringBuilder.toString()).build();
	}

	/**
	 * Elimina la risorsa richiesta nella query string
	 * 
	 * @param idRisorsa
	 *            Identificativo risorsa
	 * @return Response status 200
	 */
	@DELETE
	@Path("/delete/resource")
	public Response eliminaRisorsa(@QueryParam("ID") String idRisorsa) {
		dataAccessRisorse.eliminaRisorsa(idRisorsa);
		return Response.status(200).build();
	}
}
