package scai.formazione.jaxrs.resteasy.data.doa;

import scai.formazione.jaxrs.resteasy.data.Risorsa;

/**
 * Interfaccia di accesso alla mia collezione di risorse (DOA)
 * 
 * @author Rosario
 *
 */
public interface DOA {

	/**
	 * Restituisce la risorsa richiesta attraverso la specifica dell'identificativo
	 * 
	 * @param idRisorsa
	 *            Identificativo risorsa
	 * @return Risorsa richiesta
	 */
	public Risorsa leggiRisorsa(String idRisorsa);
}
