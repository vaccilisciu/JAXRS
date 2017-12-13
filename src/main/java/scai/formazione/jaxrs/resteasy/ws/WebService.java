package scai.formazione.jaxrs.resteasy.ws;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/WebService")
public class WebService {

	@GET
	@Path("/lettura")
	public String leggiRisorsa() {
		return "Hello WebService";
	}
}
