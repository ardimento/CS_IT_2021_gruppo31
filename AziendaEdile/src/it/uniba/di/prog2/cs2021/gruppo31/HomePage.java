package it.uniba.di.prog2.cs2021.gruppo31;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import it.uniba.di.prog2.cs2021.gruppo31.dado.Dado;
import it.uniba.di.prog2.cs2021.gruppo31.database.AdminQuery;
import it.uniba.di.prog2.cs2021.gruppo31.database.ProxyDB;
import it.uniba.di.prog2.cs2021.gruppo31.database.UserQuery;
import it.uniba.di.prog2.cs2021.gruppo31.exception.AziendaException;
import it.uniba.di.prog2.cs2021.gruppo31.exception.ErroriDB;
import it.uniba.di.prog2.cs2021.gruppo31.exception.ErroriUtente;
import it.uniba.di.prog2.cs2021.gruppo31.utente.Impiegato;
import it.uniba.di.prog2.cs2021.gruppo31.utente.Utente;

/**
 * Classe contenente tutte le operazioni che un utente può eseguire nel sistema.<br>
 * Questa classe è stata implementata per i seguenti motivi:
 * <ul>
 * <li>Implementare il controllo di accesso al sistema attraverso la classe Token.</li>
 * <li>Iniettare la dipendenda di accesso al package database nella classe HomePage,
 * 		invece di accedervi direttamente dalla classe Client.</li>
 * <li>Fornire una classe comune sia per utenti standard che amministratori.</li>
 * </ul>
 * <p>
 * La classe utilizza le interfacce UserQuery e AdminQuery per accedere alle operazioni
 * definite nella classe ProxyDB, e ne gestisce le eccezioni.<br>
 * @author matteo
 * @version 1.1
 */
public class HomePage {
	
	private Utente utente; // Utente nella sessione corrente
	
	/**
	 * Costruttore parametrico.<br>
	 * Controlla che l'utente ricevuto in input abbia effettuato il login
	 * attraverso il metodo {@link it.uniba.di.prog2.cs2021.gruppo31.utente.Utility_Utente#checkUtente(String, String)}.
	 * @param utente Utente con cui è stato effettuato l'accesso.
	 * @throws AziendaException Eccezione: USERNAME_NOT_LOGGED.
	 * @see it.uniba.di.prog2.cs2021.gruppo31.Token
	 * @see it.uniba.di.prog2.cs2021.gruppo31.utente.Utente
	 */
	public HomePage(Utente utente) throws AziendaException {
		this.utente = utente;
		if(Token.getIstance().getHashPassword().equals(utente.getHashPassword()));
		else
			throw new AziendaException(ErroriUtente.USERNAME_NOT_LOGGED);
	}
	
	/**
	 * Aggiunge una vendita alla lista delle vendite.<br>
	 * Vengono effettuati prima dei controlli sui limiti delle vendite
	 * dell'utente, sul numero di pezzi disponibili e sul formato delle date.
	 * Successivamente su procede a validare ed aggiungere la vendita al database,
	 * attraverso l'interfaccia UserQuery della classe ProxyDB.
	 * @param vendita Vendita da aggiungere alla lista.
	 * @throws SQLException
	 * @throws ParseException
	 * @throws AziendaException Possibili eccezioni:<br>
	 * 		USERNAME_NOT_FOUND, INCORRECT_PASSWORD, DADO_NOT_FOUND,<br>
	 * 		MAX_VENDITE_ANNO, MAX_VENDITE_GIORNO, NUMPEZZI_NOT_VALID, DATA_NOT_VALID.
	 * @see Dado
	 * @see Calendar
	 * @see it.uniba.di.prog2.cs2021.gruppo31.database.UserQuery#addVendita(Vendita)
	 */
	public void addVendita(Vendita vendita) throws SQLException,AziendaException,ParseException {
		if(getVenditeAnno(vendita.getUtente().getUsername()) >= vendita.getUtente().getImpiegato().getMaxVenditeAnno())
			throw new AziendaException(ErroriUtente.MAX_VENDITE_ANNO);
		if(getVenditeGiorno(vendita.getUtente().getUsername()) >= Impiegato.MAX_VENDITE_GIORNO)
			throw new AziendaException(ErroriUtente.MAX_VENDITE_GIORNO);
		
		UserQuery uq = ProxyDB.getIstance();
		Dado dado = uq.getDado(Integer.toString(vendita.getDado().getCodice()));
		int pezzi = dado.getNumPezzi();
		if(pezzi < vendita.getNumPezzi())
			throw new AziendaException(ErroriUtente.NUMPEZZI_NOT_VALID);
		
		Calendar c = Calendar.getInstance();
		Date temp = c.getTime();
		if(vendita.getData().compareTo(temp) > 0) //Vendita nel futuro
			throw new AziendaException(ErroriUtente.DATA_NOT_VALID);
		if(vendita.getData().compareTo(vendita.getDado().getDataProduzione()) < 0) //Vendita prima della produzione
			throw new AziendaException(ErroriUtente.DATA_NOT_VALID);
		if(vendita.getData().compareTo(vendita.getUtente().getImpiegato().getDataEntrata()) < 0) //Vendita prima dell'entrata in azienda
			throw new AziendaException(ErroriUtente.DATA_NOT_VALID);
		uq.addVendita(vendita);
	}
	
	/**
	 * Restituisce le informazioni relative all'utente loggato.<br>
	 * @return Oggetto Impiegato costruito con le informazioni presenti sul database.
	 * @throws SQLException
	 * @throws ParseException
	 * @throws AziendaException Eccezione: USERNAME_NOT_FOUND.
	 * @see it.uniba.di.prog2.cs2021.gruppo31.database.UserQuery#getInfoImpiegato(String)
	 */
	public Impiegato getInfoImpiegato() throws SQLException,AziendaException,ParseException {
		UserQuery uq = ProxyDB.getIstance();
		return uq.getInfoImpiegato(utente.getUsername());
	}
	
	/**
	 * Restituisce l'utente che ha effettuato l'accesso.<br>
	 * @return Utente che ha effettuato l'accesso.
	 * @see it.uniba.di.prog2.cs2021.gruppo31.utente.Utente
	 */
	public Utente getUtente() {
		return utente;
	}
	
	/**
	 * Restituisce la lista di tutte le vendite relative all'utente loggato.
	 * @return Lista di vendite effettuate dall'impiegato.
	 * @throws SQLException
	 * @throws ParseException
	 * @throws AziendaException Eccezione: EMPTY_LIST.
	 * @see it.uniba.di.prog2.cs2021.gruppo31.database.UserQuery#getVenditeImpiegato(String)
	 */
	public ArrayList<Vendita> getVenditeImpiegato() throws SQLException,AziendaException,ParseException {
		UserQuery uq = ProxyDB.getIstance();
		return uq.getVenditeImpiegato(utente.getUsername());
	}

	/**
	 * Restituisce il catalogo di tutti i dadi presenti nel database.
	 * @return Catalogo dei dadi attualmente presenti.
	 * @throws SQLException
	 * @throws ParseException
	 * @throws AziendaException Eccezione: EMPTY_LIST.
	 * @see it.uniba.di.prog2.cs2021.gruppo31.database.UserQuery#getCatalogoDadi()
	 */
	public ArrayList<Dado> getCatalogoDadi() throws SQLException,AziendaException,ParseException {
		UserQuery uq = ProxyDB.getIstance();
		return uq.getCatalogoDadi();
	}
	
	/**
	 * Aggiunge un dado al catalogo del database.<br>
	 * @param dado Dado da aggiungere al catalogo.
	 * @throws SQLException
	 * @throws AziendaException Possibili eccezioni:<br>
	 * 		USERNAME_NOT_FOUND, USERNAME_NOT_ADMIN, FILETTATTURA_NOT_FOUND, DADO_ALREADY_EXISTS.
	 * @see it.uniba.di.prog2.cs2021.gruppo31.database.AdminQuery#addDado(String, Dado)
	 */
	public void addDado(Dado dado) throws SQLException,AziendaException {
		AdminQuery aq = ProxyDB.getIstance();
		aq.addDado(utente.getUsername(),dado);
	}
	
	/**
	 * Elimina un dado dal catalogo del database.<br>
	 * @param hashDado Dado da eliminare dal catalogo.
	 * @throws SQLException
	 * @throws ParseException
	 * @throws AziendaException Possibili eccezioni:<br>
	 * 		USERNAME_NOT_FOUND, USERNAME_NOT_ADMIN, DADO_NOT_FOUND.
	 * @see it.uniba.di.prog2.cs2021.gruppo31.database.AdminQuery#deleteDado(String, int)
	 */
	public void deleteDado(int hashDado) throws SQLException,AziendaException,ParseException {
		AdminQuery aq = ProxyDB.getIstance();
		aq.deleteDado(utente.getUsername(),hashDado);
	}
	
	/**
	 * Aggiorna il numero di pezzi di un dado nel catalogo.<br>
	 * Il metodo permette ad un amministratore di modificare il numero di pezzi
	 * di un dado, senza che questo sia stato venduto. Può essere utilizzato ad esempio
	 * quando sono stati comprati nuovi pezzi di un dado, oppure alcuni pezzi sono andati persi.<br>
	 * Inoltre il metodo genera un'eccezione se il nuovo numero di pezzi è negativo.
	 * @param hashDado Codice hash del dado da aggiornare.
	 * @param numPezzi Nuovo numero di pezzi del dado.
	 * @throws SQLException
	 * @throws ParseException
	 * @throws AziendaException Possibili eccezioni:<br>
	 * 		USERNAME_NOT_FOUND, USERNAME_NOT_ADMIN, DADO_NOT_FOUND, NUMPEZZI_NOT_VALID.
	 * @see it.uniba.di.prog2.cs2021.gruppo31.database.AdminQuery#updatePezziDado(String, int, int)
	 */
	public void updatePezziDado(int hashDado, int numPezzi) throws SQLException,AziendaException,ParseException {
		AdminQuery aq = ProxyDB.getIstance();
		if(numPezzi < 0)
			throw new AziendaException(ErroriUtente.NUMPEZZI_NOT_VALID);
		aq.updatePezziDado(utente.getUsername(),hashDado,numPezzi);
	}
	
	/**
	 * Aggiorna il prezzo di un dado nel catalogo.<br>
	 * Il metodo genera un'eccezione se il nuovo prezzo inserito è negativo.
	 * @param hashDado Codice hash del dado da aggiornare.
	 * @param prezzo Nuovo prezzo del dado.
	 * @throws SQLException
	 * @throws AziendaException Possibili eccezioni:<br>
	 * 		USERNAME_NOT_FOUND, USERNAME_NOT_ADMIN, DADO_NOT_FOUND, PREZZO_NOT_VALID.
	 * @see it.uniba.di.prog2.cs2021.gruppo31.database.AdminQuery#updatePrezzoDado(String, int, double)
	 */
	public void updatePrezzoDado(int hashDado, double prezzo) throws SQLException, AziendaException {
		AdminQuery aq = ProxyDB.getIstance();
		if(prezzo <= 0)
			throw new AziendaException(ErroriUtente.PREZZO_NOT_VALID);
		aq.updatePrezzoDado(utente.getUsername(),hashDado,prezzo);
		
	}
	
	/**
	 * Effettua il logout dell'utente dal sistema.
	 * @see Token
	 */
	public void logOut() {
		Token.getIstance().setHashPassword(null);
	}

	/**
	 * Restituisce il numero di vendite dell'utente nell'anno corrente.<br>
	 * Viene utilizzato per controllare il limite massimo di vendite all'anno.
	 * @param username Username utente di cui controllare le vendite.
	 * @return Numero di vendite effettuate nell'anno corrente.
	 * @throws SQLException
	 * @throws ParseException
	 * @throws AziendaException Eccezione: EMPTY_LIST.
	 * @see Calendar
	 * @see Vendita
	 * @see it.uniba.di.prog2.cs2021.gruppo31.database.UserQuery#getVenditeImpiegato(String)
	 */
	public int getVenditeAnno(String username) throws SQLException,AziendaException,ParseException {
		UserQuery uq = ProxyDB.getIstance();
		try {
			ArrayList<Vendita> vendite = uq.getVenditeImpiegato(username);
			int anno = Calendar.getInstance().get(Calendar.YEAR);
			int count = 0;
			
			for(Vendita i : vendite) {
				Calendar c = Calendar.getInstance();
				c.setTime(i.getData());
				if(c.get(Calendar.YEAR) == anno)	count++;
			}
			return count;
		}
		catch(AziendaException ex) {
			if(ex.getMessage() == ErroriDB.EMPTY_LIST)	return 0;
			else
				throw new AziendaException(ex.getMessage());
		}
	}
	
	/**
	 * Restituisce il numero di vendite dell'utente nel giorno corrente.<br>
	 * Viene utilizzato per controllare il limite massimo di vendite al giorno.
	 * @param username Username utente di cui controllare le vendite.
	 * @return Numero di vendite effettuate nel giorno corrente.
	 * @throws SQLException
	 * @throws ParseException
	 * @throws AziendaException Eccezione: EMPTY_LIST.
	 * @see Calendar
	 * @see Vendita
	 * @see it.uniba.di.prog2.cs2021.gruppo31.database.UserQuery#getVenditeImpiegato(String)
	 */
	public int getVenditeGiorno(String username) throws SQLException,AziendaException,ParseException {
		UserQuery uq = ProxyDB.getIstance();
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		try {
			ArrayList<Vendita> vendite = uq.getVenditeImpiegato(username);
			Date tmp = Calendar.getInstance().getTime();
			String data = formatter.format(tmp);
			int count = 0;
			
			for(Vendita i : vendite)
				if(formatter.format(i.getData()).equals(data))	count++;
			
			return count;
		}
		catch(AziendaException ex) {
			if(ex.getMessage() == ErroriDB.EMPTY_LIST)	return 0;
			else
				throw new AziendaException(ex.getMessage());
		}
	}
}
