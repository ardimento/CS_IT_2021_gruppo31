package it.uniba.di.prog2.cs2021.gruppo31.dado;

/**
 * Classe che si occupa di gestire la filettatura di un dado.
 * <p>
 * Tutti i tipi di filettatura disponibili per un dado sono memorizzati sul database.<br>
 * Tutti i tipi di filettatura presenti seguono la norma EN ISO 898-2.
 * @author matteo
 * @version 1.1
 */
public class Filettatura {
	
	/** Diametro foro espresso in mm, range: [M3-M60] */
	private String metrica;
	
	/** Passo grosso (true) / passo fine (false) */
	private boolean passoGrosso;
	
	/** Dimensione passo espressa in mm */
	private double dimensionePasso;
	
	/** Dimensione apertura chiave espressa in mm */
	private double misuraPiatti; 
	
	/** Altezza espressa in mm */
	private double altezza;
	
	/**
	 * Il costruttore riceve il diamentro del foro e il tipo di passo.<br>
	 * Attraverso questi due paramentri è possibile reperire dal database le restanti informazioni.
	 * @param metrica Diametro del foro.
	 * @param passoGrosso Tipo di passo.
	 */
	public Filettatura(String metrica, boolean passoGrosso) {
		this.metrica = metrica;
		this.passoGrosso = passoGrosso;
	}
	
	/**
	 * Restituisce la metrica del dado.<br>
	 * Formato: Mxx, con xx in [3,60].
	 * @return Metrica dado.
	 */
	public String getMetrica() {
		return metrica;
	}
	
	/**
	 * Restituisce il diametro del foro del dado.
	 * @return Diametro foro espressa in mm.
	 */
	public int getDiamentro() {
		String d = metrica.substring(1);
		return Integer.parseInt(d);
	}
	
	/**
	 * Restituisce il tipo di passo del dado.
	 * @return Tipo passo.
	 */
	public boolean isPassoGrosso() {
		return passoGrosso;
	}
	
	/**
	 * Restituisce la dimensione del passo del dado.
	 * @return Dimesione passo espressa in mm.
	 */
	public double getDimensionePasso() {
		return dimensionePasso;
	}
	
	/**
	 * Restituisce la dimensione dell'apertura della chiave del dado.
	 * @return Dimensione apertura chiave espressa in mm.
	 */
	public double getMisuraPiatti() {
		return misuraPiatti;
	}
	
	/**
	 * Restituisce l'altezza del dado.
	 * @return Altezza espressa in mm.
	 */
	public double getAltezza() {
		return altezza;
	}
	
	/**
	 * Imposta la dimensione del passo.
	 * @param dimensionePasso Dimensione passo espressa in mm.
	 */
	public void setDimensionePasso(double dimensionePasso) {
		this.dimensionePasso = dimensionePasso;
	}
	
	/**
	 * Imposta la dimensione dell'apertura della chiave.
	 * @param misuraPiatti Apertura chiave espressa in mm.
	 */
	public void setMisuraPiatti(double misuraPiatti) {
		this.misuraPiatti = misuraPiatti;
	}
	
	/**
	 * Imposta l'altezza.
	 * @param altezza Altezza espressa in mm.
	 */
	public void setAltezza(double altezza) {
		this.altezza = altezza;
	}
	
	/**
	 * Restituisce la filettatura in formato String.
	 * @return Elenco di tutte le informazioni sul tipo di filettatura.
	 */
	@Override
	public String toString()
	{
		String s = "[Metrica: " + metrica;
		if(passoGrosso == false)
			s += " - Passo grosso: " + dimensionePasso;
		else
			s += " - Passo fine: " + dimensionePasso;
		s += " - MisuraPiatti: " + misuraPiatti;
		s += " - Altezza : " + altezza + "]";
		return s;
	}
}
