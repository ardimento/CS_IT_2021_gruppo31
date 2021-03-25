package it.uniba.di.prog2.cs2021.gruppo31;
import java.sql.SQLException;
import java.text.ParseException;
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
 * Classe che si occupa di gestire la homepage del programma 
 * @author andrea
 * @version 1.1
 */
public class HomePage {
	private Utente utente;
	
	/**
	 * 
	 * @param utente Utente 
	 * @throws AziendaException
	 */
	public HomePage(Utente utente) throws AziendaException {
		this.utente = utente;
		if(Token.getIstance().getHashPassword().equals(utente.getHashPassword()));
		else
			throw new AziendaException(ErroriUtente.USERNAME_NOT_LOGGED);
	}
	
	/**
	 * Metodo per aggiungere una vendita 
	 * @param vendita Vendita 
	 * @throws SQLException
	 * @throws AziendaException
	 * @throws ParseException
	 */
	public void addVendita(Vendita vendita) throws SQLException,AziendaException,ParseException {
		if(getVenditeAnno(vendita.getUtente().getUsername()) >= vendita.getUtente().getImpiegato().getMaxVenditeAnno())
			throw new AziendaException(ErroriUtente.MAX_VENDITE_ANNO);
		if(getVenditeGiorno(vendita.getUtente().getUsername()) >= Impiegato.MAX_VENDITE_GIORNO)
			throw new AziendaException(ErroriUtente.MAX_VENDITE_GIORNO);
		
		UserQuery uq = ProxyDB.getIstance();
		Dado dado = uq.getDado(Integer.toString(vendita.getDado().hashCode()));
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
	 * 
	 * @return 
	 * @throws SQLException
	 * @throws AziendaException
	 * @throws ParseException
	 */
	public Impiegato getInfoImpiegato() throws SQLException,AziendaException,ParseException {
		UserQuery uq = ProxyDB.getIstance();
		return uq.getInfoImpiegato(utente.getUsername());
	}
	
	/**
	 * 
	 * @return
	 * @throws SQLException
	 * @throws AziendaException
	 * @throws ParseException
	 */
	public ArrayList<Vendita> getVenditeImpiegato() throws SQLException,AziendaException,ParseException {
		UserQuery uq = ProxyDB.getIstance();
		return uq.getVenditeImpiegato(utente.getUsername());
	}

	/**
	 * 
	 * @return 
	 * @throws SQLException
	 * @throws AziendaException
	 * @throws ParseException
	 */
	public ArrayList<Dado> getCatalogoDadi() throws SQLException,AziendaException,ParseException {
		UserQuery uq = ProxyDB.getIstance();
		return uq.getCatalogoDadi();
	}
	
	/**
	 * 
	 * @param dado
	 * @throws SQLException
	 * @throws AziendaException
	 */
	public void addDado(Dado dado) throws SQLException,AziendaException {
		AdminQuery aq = ProxyDB.getIstance();
		aq.addDado(utente.getUsername(),dado);
	}
	
	/**
	 * 
	 * @param hashDado
	 * @throws SQLException
	 * @throws AziendaException
	 * @throws ParseException
	 */
	public void deleteDado(int hashDado) throws SQLException,AziendaException,ParseException {
		AdminQuery aq = ProxyDB.getIstance();
		aq.deleteDado(utente.getUsername(),hashDado);
	}
	
	/*
	 * Sistema di gestione delle vendite, questo metodo permette di modificare il numero di pezzi
	 * Esempio: comprati nuovi dadi, oppure alcuni dadi sono stati persi.
	 *<p> 
	 * @param hashDado 
	 * @param numPezzi Numero pezzi dadi
	 * @throws SQLException
	 * @throws AziendaException
	 * @throws ParseException
	 */
	public void updatePezziDado(int hashDado, int numPezzi) throws SQLException,AziendaException,ParseException {
		AdminQuery aq = ProxyDB.getIstance();
		if(numPezzi < 0)
			throw new AziendaException(ErroriUtente.NUMPEZZI_NOT_VALID);
		aq.updatePezziDado(utente.getUsername(),hashDado,numPezzi);
	}
	
	/**
	 * 
	 * @param hashDado
	 * @param prezzo
	 * @throws SQLException
	 * @throws AziendaException
	 */
	public void updatePrezzoDado(int hashDado, double prezzo) throws SQLException, AziendaException {
		AdminQuery aq = ProxyDB.getIstance();
		if(prezzo <= 0)
			throw new AziendaException(ErroriUtente.PREZZO_NOT_VALID);
		aq.updatePrezzoDado(utente.getUsername(),hashDado,prezzo);
		
	}
	
	/**
	 * 
	 */
	public void logOut() {
		Token.getIstance().setHashPassword(null);
	}

	/**
	 * 
	 * @param username Nickname 
	 * @return 
	 * @throws SQLException
	 * @throws AziendaException
	 * @throws ParseException
	 */
	private int getVenditeAnno(String username) throws SQLException,AziendaException,ParseException {
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
	 * 
	 * @param username Nickname utente 
	 * @return 
	 * @throws SQLException
	 * @throws AziendaException
	 * @throws ParseException
	 */
	private int getVenditeGiorno(String username) throws SQLException,AziendaException,ParseException {
		UserQuery uq = ProxyDB.getIstance();
		try {
			ArrayList<Vendita> vendite = uq.getVenditeImpiegato(username);
			Date data = Calendar.getInstance().getTime();
			int count = 0;
			
			for(Vendita i : vendite)
				if(i.getData().compareTo(data) == 0)	count++;
			
			return count;
		}
		catch(AziendaException ex) {
			if(ex.getMessage() == ErroriDB.EMPTY_LIST)	return 0;
			else
				throw new AziendaException(ex.getMessage());
		}
		

	}
}
