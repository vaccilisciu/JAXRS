package scai.formazione.jaxrs.resteasy.data;

import java.util.HashMap;

/**
 * Classe pattern Singleton contenente la mia collezione di risorse
 * 
 * @author Rosario
 *
 */
public class Singleton {

	private HashMap<String, Risorsa> collectionRisorse = new HashMap<String, Risorsa>();
	private static Singleton mySingleton;
	private int keyCollectionRisorse = 0;

	/**
	 * Inserimento statico di risorse per i primi testd di lettura dopo
	 * inizializzazione Singleton
	 */
	private Singleton() {
		collectionRisorse.put(String.valueOf(keyCollectionRisorse),
				new Risorsa(String.valueOf(keyCollectionRisorse), "Risorsa 0"));
		collectionRisorse.put(String.valueOf(++keyCollectionRisorse),
				new Risorsa(String.valueOf(keyCollectionRisorse), "Risorsa 1"));
		collectionRisorse.put(String.valueOf(++keyCollectionRisorse),
				new Risorsa(String.valueOf(keyCollectionRisorse), "Risorsa 2"));
	}

	/**
	 * Metodo di build della mia classe Singleton
	 * 
	 * @return Inizializzazione unica (statica) per la mia collezione di risorse
	 */
	public static Singleton build() {
		if (mySingleton == null) {
			mySingleton = new Singleton();
		}
		return mySingleton;
	}

	/**
	 * Offre accesso alla mia collezione di risorse
	 * 
	 * @return HashMap contente le risorse richieste
	 */
	public HashMap<String, Risorsa> accessoCollectionRisorse() {
		return collectionRisorse;
	}
}
