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
import it.uniba.di.prog2.cs2021.gruppo31.exception.ErroriUtente;
import it.uniba.di.prog2.cs2021.gruppo31.utente.Impiegato;
import it.uniba.di.prog2.cs2021.gruppo31.utente.Utente;

public class HomePage {
	private Utente utente;
	private boolean accesso = false;
	
	public HomePage(Utente utente) {
		this.utente = utente;
		//Token
	}
	
	public void addVendita(Vendita vendita) throws SQLException,AziendaException,ParseException {
		UserQuery uq = ProxyDB.getIstance();
		Dado dado = uq.getDado(Integer.toString(vendita.getDado().hashCode()));
		int pezzi = dado.getNumPezzi();
		if(pezzi < vendita.getNumPezzi())
			throw new AziendaException(ErroriUtente.NUMPEZZI_NOT_VALID);
		
		Calendar c = Calendar.getInstance();
		Date temp = c.getTime();
		if(vendita.getData().compareTo(temp) > 0)
			throw new AziendaException(ErroriUtente.DATA_NOT_VALID);
		uq.addVendita(vendita);
	}
	
	public Impiegato getInfoImpiegato() throws SQLException,AziendaException,ParseException {
		UserQuery uq = ProxyDB.getIstance();
		return uq.getInfoImpiegato(utente.getUsername());
	}
	
	public ArrayList<Vendita> getVenditeImpiegato() throws SQLException,AziendaException,ParseException {
		UserQuery uq = ProxyDB.getIstance();
		return uq.getVenditeImpiegato(utente.getUsername());
	}
	
	public ArrayList<Dado> getCatalogoDadi() throws SQLException,AziendaException,ParseException {
		UserQuery uq = ProxyDB.getIstance();
		return uq.getCatalogoDadi();
	}
	
	public void addDado(Dado dado) throws SQLException,AziendaException {
		AdminQuery aq = ProxyDB.getIstance();
		aq.addDado(utente.getUsername(),dado);
	}
	
	public void deleteDado(int hashDado) throws SQLException,AziendaException,ParseException {
		AdminQuery aq = ProxyDB.getIstance();
		aq.deleteDado(utente.getUsername(),hashDado);
	}
	
	/*
	 * Sistema di gestione delle vendite, questo metodo permette di modificare il numero di pezzi
	 * Esempio: comprati nuovi dadi, oppure alcuni dadi sono stati persi.
	 */
	public void updatePezziDado(int hashDado, int numPezzi) throws SQLException,AziendaException,ParseException {
		AdminQuery aq = ProxyDB.getIstance();
		if(numPezzi < 0)
			throw new AziendaException(ErroriUtente.NUMPEZZI_NOT_VALID);
		aq.updatePezziDado(utente.getUsername(),hashDado,numPezzi);
	}
	
	public void updatePrezzoDado(int hashDado, double prezzo) throws SQLException, AziendaException {
		AdminQuery aq = ProxyDB.getIstance();
		if(prezzo <= 0)
			throw new AziendaException(ErroriUtente.PREZZO_NOT_VALID);
		aq.updatePrezzoDado(utente.getUsername(),hashDado,prezzo);
		
	}
}
