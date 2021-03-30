package it.uniba.di.prog2.cs2021.gruppo31.database;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import it.uniba.di.prog2.cs2021.gruppo31.Vendita;
import it.uniba.di.prog2.cs2021.gruppo31.dado.Dado;
import it.uniba.di.prog2.cs2021.gruppo31.exception.AziendaException;
import it.uniba.di.prog2.cs2021.gruppo31.utente.Impiegato;

/**
 * Interfaccia utente standard.<br>
 * Contiene tutte le funzionalità che sia un utente standard
 * sia un admin possono eseguire sul database.
 * @author matteo
 * @version 1.1
 */
public interface UserQuery {
	
	/**
	 * Aggiunge una vendita alla lista delle vendite.<br>
	 * Vengono effettuati prima dei controlli su utente e dado a cui
	 * la vendita fa riferimento. Successivamente si procede a validare
	 * ed aggiungere la vendita al database.
	 * @param vendita Vendita da aggiungere alla lista.
	 * @throws SQLException
	 * @throws ParseException
	 * @throws AziendaException Possibili eccezioni:<br>
	 * 		USERNAME_NOT_FOUND, INCORRECT_PASSWORD, DADO_NOT_FOUND.
	 * @see ProxyDB#checkUtente(String, String)
	 * @see ProxyDB#getDado(String)
	 * @see it.uniba.di.prog2.cs2021.gruppo31.Vendita
	 * @see ConnectorDB
	 */
	public void addVendita(Vendita vendita) throws SQLException,AziendaException,ParseException;
	
	/**
	 * Restituisce l'impiegato relativo ad un utente.<br>
	 * @param username Username utente da cui reperire le informazioni.
	 * @return Oggetto Impiegato costruito con le informazioni presenti sul database.
	 * @throws SQLException
	 * @throws ParseException
	 * @throws AziendaException Eccezione: USERNAME_NOT_FOUND.
	 * @see it.uniba.di.prog2.cs2021.gruppo31.utente.Impiegato
	 * @see ConnectorDB
	 */
	public Impiegato getInfoImpiegato(String username) throws SQLException,AziendaException,ParseException;
	
	/**
	 * Restituisce la lista di tutte le vendite relative ad un impiegato.
	 * @param username Username utente da cui scaricare la lista.
	 * @return Lista di vendite effettuate dall'impiegato.
	 * @throws SQLException
	 * @throws ParseException
	 * @throws AziendaException Possibili eccezioni: EMPTY_LIST.
	 * @see it.uniba.di.prog2.cs2021.gruppo31.Vendita
	 * @see ConnectorDB
	 */
	public ArrayList<Vendita> getVenditeImpiegato(String username) throws SQLException,AziendaException,ParseException;
	
	/**
	 * Restituisce il catalogo di tutti i dadi presenti nel database.
	 * @return Catalogo dei dadi attualmente presenti.
	 * @throws SQLException
	 * @throws ParseException
	 * @throws AziendaException Possibili eccezioni: EMPTY_LIST.
	 * @see it.uniba.di.prog2.cs2021.gruppo31.dado.Dado
	 * @see ConnectorDB
	 */
	public ArrayList<Dado> getCatalogoDadi() throws SQLException,AziendaException,ParseException;
	
	/**
	 * Restituisce un tipo di dado memorizzato sul database.<br>
	 * @param hashDado Stringa contenente il codice hash del dado cercato.
	 * @return Oggetto Dado costrutito con le informazioni presenti sul database.
	 * @throws SQLException
	 * @throws ParseException
	 * @throws AziendaException Eccezione: DADO_NOT_FOUND.
	 * @see it.uniba.di.prog2.cs2021.gruppo31.dado.Dado
	 * @see it.uniba.di.prog2.cs2021.gruppo31.dado.Filettatura
	 * @see ConnectorDB
	 */
	public Dado getDado(String hashDado) throws SQLException,AziendaException,ParseException;
}
