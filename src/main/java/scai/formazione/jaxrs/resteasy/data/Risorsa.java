package scai.formazione.jaxrs.resteasy.data;

import java.util.Date;

/**
 * Classe esempio per descrivere una generica risorsa del web
 * 
 * @author Rosario
 *
 */
public class Risorsa {

	private String idRisorsa;
	private String valueRisorsa;
	private String lastModifiedRisorsa;

	public Risorsa(String idRisorsa, String valueRisorsa) {
		this.idRisorsa = idRisorsa;
		this.valueRisorsa = valueRisorsa;
		this.lastModifiedRisorsa = new Date().toString();
	}

	public Risorsa() {
		this.idRisorsa = "";
		this.valueRisorsa = "";
		this.lastModifiedRisorsa = new Date().toString();
	}

	public String getIdRisorsa() {
		return idRisorsa;
	}

	public void setIdRisorsa(String idRisorsa) {
		this.idRisorsa = idRisorsa;
	}

	public String getValueRisorsa() {
		return valueRisorsa;
	}

	public void setValueRisorsa(String valueRisorsa) {
		this.valueRisorsa = valueRisorsa;
	}

	public String getLastModifiedRisorsa() {
		return lastModifiedRisorsa;
	}

	public void setLastModifiedRisorsa(String lastModifiedRisorsa) {
		this.lastModifiedRisorsa = lastModifiedRisorsa;
	}

	@Override
	public String toString() {
		return "Risorsa" + "{" + "[" + "idRisorsa=" + idRisorsa + "][" + "valueRisorsa=" + valueRisorsa + "]["
				+ "lastModifiedRisorsa=" + lastModifiedRisorsa + "]" + "}";
	}
}
