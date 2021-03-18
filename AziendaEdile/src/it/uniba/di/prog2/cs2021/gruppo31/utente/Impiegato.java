package it.uniba.di.prog2.cs2021.gruppo31.utente;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Impiegato {
	
	private String nome;
	private String cognome;
	private Date dataNascita;
	private String mansione;
	private Date dataEntrata;
	private int stipendioMensile;
	private int maxVenditeAnno;
	public static final int MAX_VENDITE_GIORNO = 300;
	
	public Impiegato(String nome, String cognome, Date dataNascita, String mansione, Date dataEntrata, int stipendioMensile, int maxVenditeAnno) {
		this.stipendioMensile = stipendioMensile;
		this.maxVenditeAnno = maxVenditeAnno;
		this.dataEntrata = dataEntrata;
		this.nome = nome;
		this.cognome = cognome;
		this.dataNascita = dataNascita;
		this.mansione = mansione;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public Date getDataNascita() {
		return dataNascita;
	}

	public void setDataNascita(Date dataNascita) {
		this.dataNascita = dataNascita;
	}

	public String getMansione() {
		return mansione;
	}

	public void setMansione(String mansione) {
		this.mansione = mansione;
	}

	public Date getDataEntrata() {
		return dataEntrata;
	}

	public void setDataEntrata(Date dataEntrata) {
		this.dataEntrata = dataEntrata;
	}

	public int getStipendioMensile() {
		return stipendioMensile;
	}

	public void setStipendioMensile(int stipendioMensile) {
		this.stipendioMensile = stipendioMensile;
	}

	public int getMaxVenditeAnno() {
		return maxVenditeAnno;
	}

	public void setMaxVenditeAnno(int maxVenditeAnno) {
		this.maxVenditeAnno = maxVenditeAnno;
	}

	@Override
	public String toString() {
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		String s = "Nome: " + nome + "\nCognome: " + cognome + "\nData Nascita: " + formatter.format(dataNascita);
		s += "\nMansione: " + mansione + "\nData Entrata: " + formatter.format(dataEntrata) + "\nStipendio Mensile: ";
		s += + stipendioMensile + "\nLimite massimo vendite annue: " + maxVenditeAnno;
		return s;
	}
	
	
}
