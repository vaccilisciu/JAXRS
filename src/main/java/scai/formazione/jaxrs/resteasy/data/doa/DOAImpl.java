package scai.formazione.jaxrs.resteasy.data.doa;

import java.util.ArrayList;

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

	/**
	 * Restituisce tutte le risorse
	 * 
	 * @return Risorse richieste
	 */
	public ArrayList<Risorsa> leggiTutteRisorse() {
		Risorsa risorsa;
		ArrayList<Risorsa> listRisorse = new ArrayList<>();
		for (String idRisorsa : mySingleton.accessoCollectionRisorse().keySet()) {
			risorsa = mySingleton.accessoCollectionRisorse().get(String.valueOf(idRisorsa));
			listRisorse.add(risorsa);
		}
		return listRisorse;
	}

	/**
	 * Elimina la risorsa richiesta attraverso la specifica dell'identificativo
	 * 
	 * @param idRisorsa
	 *            Identificativo risorsa
	 */
	public void eliminaRisorsa(String idRisorsa) {
		mySingleton.accessoCollectionRisorse().remove(idRisorsa);
	}
}
