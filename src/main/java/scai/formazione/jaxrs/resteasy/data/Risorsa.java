package scai.formazione.jaxrs.resteasy.data;

import java.util.Date;

/**
 * Classe esempio per descrivere una qualsiasi risorsa del web
 * 
 * @author Rosario
 *
 */
public class Risorsa {

	private String idRisorsa;
	private String valueRisorsa;
	private Date lastModifiedRisorsa;

	public Risorsa(String idRisorsa, String valueRisorsa) {
		this.idRisorsa = idRisorsa;
		this.valueRisorsa = valueRisorsa;
		this.lastModifiedRisorsa = new Date();
	}

	@Override
	public String toString() {
		return "<pre>" + "Risorsa\n" + "[\n" + "\tidRisorsa=" + idRisorsa + ",\n" + "\tvalueRisorsa=" + valueRisorsa
				+ ",\n" + "\tlastModifiedRisorsa=" + lastModifiedRisorsa + "\n]" + "</pre>";
	}
}
