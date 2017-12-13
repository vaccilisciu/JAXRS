package scai.formazione.jaxrs.resteasy.data.doa;

import java.util.ArrayList;

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

	/**
	 * Restituisce tutte le risorse
	 * 
	 * @return Risorse richieste
	 */
	public ArrayList<Risorsa> leggiTutteRisorse();

	/**
	 * Elimina la risorsa richiesta attraverso la specifica dell'identificativo
	 * 
	 * @param idRisorsa
	 *            Identificativo risorsa
	 */
	public void eliminaRisorsa(String idRisorsa);
}
