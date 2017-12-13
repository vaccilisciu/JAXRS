package scai.formazione.jaxrs.resteasy.data.doa;

import scai.formazione.jaxrs.resteasy.data.Risorsa;
import scai.formazione.jaxrs.resteasy.data.Singleton;

/**
 * Implementazione accesso alla mia collezione di risorse 
 * 
 * @author Rosario
 *
 */
public class DOAImpl implements DOA {

	private Singleton mySingleton;

	/**
	 * Inizializzazione collezione di risorse attraverso la build() di
	 * Singleton.class
	 */
	public DOAImpl() {
		mySingleton = Singleton.build();
	}

	/**
	 * Restituisce la risorsa richiesta attraverso la specifica dell'identificativo
	 * 
	 * @param idRisorsa
	 *            Identificativo risorsa
	 * @return Risorsa richiesta
	 */
	public Risorsa leggiRisorsa(String idRisorsa) {
		return mySingleton.accessoCollectionRisorse().get(idRisorsa);
	}
}
