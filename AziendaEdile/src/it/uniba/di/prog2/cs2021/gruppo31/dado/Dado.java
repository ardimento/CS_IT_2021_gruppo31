package it.uniba.di.prog2.cs2021.gruppo31.dado;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Interfaccia contenente tutti i metodi applicabili ad un generico tipo di dado.
 * @author matteo
 * @version 1.1
 */
public interface Dado {
	
	/**
	 * Restituisce il nome completo del dado con la sua norma.
	 * @return Denominazione dado con norma.
	 */
	public String getDenominazione();
	
	/**
	 * Restituisce il materiale del dado.
	 * @return Materiale del dado.
	 * @see Materiale
	 */
	public String getMateriale();
	
	/**
	 * Imposta il materiale del dado.
	 * @param materiale Materiale del dado.
	 * @return Se il materiale passato come paramentro è corretto, ritorna TRUE. Altrimenti FALSE.<br>
	 * 		   Nota: L'enum Materiale contiene tutti i tipi di materiali disponibili.
	 * @see Materiale
	 */
	public boolean setMateriale(String materiale);
	
	/**
	 * Restituisce la categoria del dado.
	 * @return Categoria del dado.
	 * @see Categoria
	 */
	public String getCategoria();
	
	/**
	 * Imposta la categoria del dado.
	 * @param categoria Categoria del dado.
	 * @return Se la categoria passata come paramentro è corretta, ritorna TRUE. Altrimenti FALSE.<br>
	 * 		   Nota: L'enum Categoria contiene tutte categorie disponibili.
	 * @see Categoria
	 */
	public boolean setCategoria(String categoria);
	
	/**
	 * Restituisce il rivestimento protettivo del dado.
	 * @return Rivestimento protettivo del dado.
	 * @see RivestimentoProtettivo
	 */
	public String getRivestimentoProtettivo();
	
	/**
	 * Imposta il rivestimento protettivo del dado.
	 * @param rivestimento Rivestimento protettivo del dado.
	 * @return Se il rivestimento passato come paramentro è corretto, ritorna TRUE. Altrimenti FALSE.<br>
	 * 		   Nota: L'enum RivestimentoProtettivo contiene tutti i tipi di rivestimenti disponibili.
	 * @see RivestimentoProtettivo
	 */
	public boolean setRivestimentoProtettivo(String rivestimento);
	
	/**
	 * Restutisce la filettatura del dado.
	 * @return Filettatura del dado.
	 * @see Filettatura
	 */
	public Filettatura getFilettatura();
	
	/**
	 * Restutisce la filettatura del dado in formato String.
	 * @return Stringa contenente le informazioni sulla filettatura.
	 * @see Filettatura
	 * @see Filettatura#toString()
	 */
	public String getFilettaturaString();
	
	/**
	 * Imposta la filettatura del dado.<br>
	 * Per ottenere tutte le informazioni, il metodo utilizza la classe ProxyDB per interfacciarsi al database
	 * e verificare che sia presente una filettatura con i parametri specificati.<br>
	 * <p>
	 * Inoltre il metodo calcola approssimativamente il peso del dado, utilizzando le informazioni sulla filettatura.<br>
	 * Formula per il calcolo del peso: <code>peso = DiametroForo * MisuraPiatti * Altezza / (100 + MisuraPiatti)</code>
	 * 
	 * @param metrica Metrica del dado.
	 * @param passoGrosso Tipo passo del dado.
	 * @return Se la metrica e il tipo di passo sono presenti nel database, ritorna TRUE. Altrimenti FALSE.
	 * @throws SQLException
	 * @see it.uniba.di.prog2.cs2021.gruppo31.database.ProxyDB#getFilettatura(String, boolean)
	 */
	public boolean setFilettatura(String metrica, boolean passoGrosso) throws SQLException;
	
	/**
	 * Restituisce il peso del dado in grammi.<br>
	 * Non esiste un metodo per impostare il peso, ma questo viene calcolato
	 * automaticamente dal metodo {@link #setFilettatura(String, boolean)}.
	 * @return Peso espresso in grammi.
	 */
	public double getPeso();
	
	/**
	 * Restituisce il numero di pezzi disponibili.
	 * @return Numero pezzi disponibili.
	 */
	public int getNumPezzi();
	
	/**
	 * Imposta il numero di pezzi disponibili.
	 * @param numPezzi Numero pezzi disponibili.
	 * @return Se il numero di pezzi fornito in input è positivo, ritorna TRUE. Altrimenti FALSE.
	 */
	public boolean setNumPezzi(int numPezzi);
	
	/**
	 * Restituisce il prezzo del dado.
	 * @return Prezzo del dado espresso in euro(€).
	 */
	public double getPrezzo();
	
	/**
	 * Imposta il prezzo del dado.
	 * @param prezzo Prezzo del dado espresso in euro(€).
	 * @return Se il prezzo fornito in input è positivo, ritorna TRUE. Altrimenti FALSE.
	 */
	public boolean setPrezzo(double prezzo);
	
	/**
	 * Restituisce il luogo di produzione del dado.
	 * @return Luogo produzione del dado.
	 */
	public String getLuogoProduzione();
	
	/**
	 * Imposta il luogo di produzione del dado.
	 * @param luogoProduzione Luogo produzione del dado.
	 */
	public void setLuogoProduzione(String luogoProduzione);
	
	/**
	 * Restutisce la data di produzione del dado.
	 * @return Data produzione del dado.
	 * @see Date
	 */
	public Date getDataProduzione();
	
	/**
	 * Imposta la data di produzione del dado.
	 * @param dataProduzione Data produzione del dado.
	 * @see Date
	 */
	public void setDataProduzione(Date dataProduzione);
	
	/**
	 * Imposta il codice identificativo del dado.<br>
	 * @see #hashCode()
	 */
	void setCodice(int codice);
	
	/**
	 * Restituisce il codice identificativo del dado.<br>
	 * @return Codice identificativo del dado.
	 * @see #hashCode()
	 */
	int getCodice();
	
	/**
	 * Calcola il codice identificativo hash del dado.<br>
	 * @return Codice hash del dado positivo: <code>(result &amp; 0xfffffff)</code>
	 */
	public int hashCode();
	
	/**
	 * {@inheritDoc}
	 */
	public boolean equals(Object obj);
	
	/**
	 * Restutisce il dado in formato String.
	 * @return Elenco di tutte le informazioni relative al tipo di dado.
	 * @see Date
	 * @see SimpleDateFormat
	 */
	public String toString();
}
