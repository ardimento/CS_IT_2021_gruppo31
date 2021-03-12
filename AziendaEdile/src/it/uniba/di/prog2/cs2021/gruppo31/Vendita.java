package it.uniba.di.prog2.cs2021.gruppo31;
import java.util.Date;
import it.uniba.di.prog2.cs2021.gruppo31.dado.Dado;
import it.uniba.di.prog2.cs2021.gruppo31.utente.Utente;

public class Vendita {
	
	private Utente utente;
	private Dado dado;
	private Date data;
	private int numPezzi;
	
	public Vendita(Utente utente, Dado dado, Date data, int numPezzi) {
		this.utente = utente;
		this.dado = dado;
		this.data = data;
		this.numPezzi = numPezzi;
	}

	public Utente getUtente() {
		return utente;
	}

	public Dado getDado() {
		return dado;
	}

	public Date getData() {
		return data;
	}

	public int getNumPezzi() {
		return numPezzi;
	}
}
