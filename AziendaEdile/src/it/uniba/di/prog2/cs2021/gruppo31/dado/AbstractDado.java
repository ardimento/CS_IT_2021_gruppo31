package it.uniba.di.prog2.cs2021.gruppo31.dado;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import it.uniba.di.prog2.cs2021.gruppo31.exception.AziendaException;
import it.uniba.di.prog2.cs2021.gruppo31.database.ProxyDB;;

/**
 * Classe astratta contenente tutti i metodi definiti nell'interfaccia Dado.<br>
 * La classe fattorizza i metodi dell'interfaccia Dado e fornisce un'implementazione comune per tutti i tipi di dado.
 * Il metodo {@link Dado#getDenominazione()} ha un'implementazione specifica per ogni dado, quindi non viene implementato.
 * Inoltre i metodi {@link Dado#hashCode()}, {@link Dado#equals(Object)} e {@link Dado#toString()} verranno sovrascritti in ogni sottoclasse.<br>
 * Attualmente (versione 1.1) è presente un unico tipo di dado, ossia il dado esagonale alto.
 * @author matteo
 * @version 1.1
 */
public abstract class AbstractDado implements Dado {
	
	private int codice;
	private Materiale materiale;
	private Categoria categoria;
	private RivestimentoProtettivo rivestimento;
	private Filettatura filettatura;
	private String luogoProduzione;
	private Date dataProduzione;
	private double prezzo;
	private double peso;
	private int numPezzi = 1;
	
	/**
	 * Costruttore aparametrico.<br>
	 * Se viene utilizzato questo costruttore, la filettatura deve essere impostata
	 * successivamente con il metodo {@link #setFilettatura(String, boolean)}.
	 */
	public AbstractDado() {}
	
	/**
	 * Costruttore parametrico.<br>
	 * @param metrica Metrica del dado.
	 * @param passoGrosso Tipo di passo del dado.
	 * @throws SQLException
	 * @see #setFilettatura(String, boolean)
	 */
	public AbstractDado(String metrica, boolean passoGrosso) throws SQLException{
		this.setFilettatura(metrica, passoGrosso);
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getMateriale() {
		return materiale.toString();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean setMateriale(String materiale) {
		try {
			this.materiale = Materiale.valueOf(materiale);
		}
		catch(IllegalArgumentException e) {
			return false;
		}
		return true;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getCategoria() {
		return categoria.toString();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean setCategoria(String categoria) {
		try {
			this.categoria = Categoria.valueOf(categoria);
		}
		catch(IllegalArgumentException e) {
			return false;
		}
		return true;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getRivestimentoProtettivo() {
		return rivestimento.toString();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean setRivestimentoProtettivo(String rivestimento) {
		try {
			this.rivestimento = RivestimentoProtettivo.valueOf(rivestimento);
		}
		catch(IllegalArgumentException e) {
			return false;
		}
		return true;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Filettatura getFilettatura() {
		return filettatura;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getFilettaturaString() {
		return filettatura.toString();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean setFilettatura(String metrica, boolean passoGrosso) throws SQLException {
		try {
			filettatura = ProxyDB.getIstance().getFilettatura(metrica,passoGrosso);
			peso = 0;
			if(filettatura != null) {
				peso = filettatura.getDiamentro() * filettatura.getMisuraPiatti() * filettatura.getAltezza();
				peso /= (100 + filettatura.getMisuraPiatti());
			}
		}
		catch(AziendaException e) {
			return false; //Metrica non valida
		}
		return true;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public double getPeso() {
		return peso;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int getNumPezzi() {
		return numPezzi;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean setNumPezzi(int numPezzi) {
		if(numPezzi >= 0) {
			this.numPezzi = numPezzi;
			return true;
		}
		else
			return false;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public double getPrezzo() {
		return prezzo;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean setPrezzo(double prezzo) {
		if(prezzo >= 0) {
			this.prezzo = prezzo;
			return true;
		}
		else
			return false;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getLuogoProduzione() {
		return luogoProduzione;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setLuogoProduzione(String luogoProduzione) {
		this.luogoProduzione = luogoProduzione;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Date getDataProduzione() {
		return dataProduzione;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setDataProduzione(Date dataProduzione) {
		this.dataProduzione = dataProduzione;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setCodice(int codice) {
		this.codice = codice;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public int getCodice() {
		return codice;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((categoria == null) ? 0 : categoria.hashCode());
		result = prime * result + ((dataProduzione == null) ? 0 : dataProduzione.hashCode());
		result = prime * result + ((filettatura == null) ? 0 : filettatura.hashCode());
		result = prime * result + ((luogoProduzione == null) ? 0 : luogoProduzione.hashCode());
		result = prime * result + ((materiale == null) ? 0 : materiale.hashCode());
		result = prime * result + numPezzi;
		long temp;
		temp = Double.doubleToLongBits(peso);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(prezzo);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((rivestimento == null) ? 0 : rivestimento.hashCode());
		codice = (result & 0xfffffff);
		return codice;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AbstractDado other = (AbstractDado) obj;
		if (categoria != other.categoria)
			return false;
		if (dataProduzione == null) {
			if (other.dataProduzione != null)
				return false;
		} else if (!dataProduzione.equals(other.dataProduzione))
			return false;
		if (filettatura == null) {
			if (other.filettatura != null)
				return false;
		} else if (!filettatura.equals(other.filettatura))
			return false;
		if (luogoProduzione == null) {
			if (other.luogoProduzione != null)
				return false;
		} else if (!luogoProduzione.equals(other.luogoProduzione))
			return false;
		if (materiale != other.materiale)
			return false;
		if (numPezzi != other.numPezzi)
			return false;
		if (Double.doubleToLongBits(peso) != Double.doubleToLongBits(other.peso))
			return false;
		if (Double.doubleToLongBits(prezzo) != Double.doubleToLongBits(other.prezzo))
			return false;
		if (rivestimento != other.rivestimento)
			return false;
		return true;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String toString() {
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		String s = "Filettatura:\n" + filettatura.toString() + "\n";
		String tmpMateriale = null,tmpRivestimento = null;
		
		switch(materiale) {
		case Acciaio_5:
			tmpMateriale = "Acciaio 5";
			break;
		case Acciaio_8:
			tmpMateriale = "Acciaio 8";
			break;
		case Acciaio_10:
			tmpMateriale = "Acciaio 10";
			break;
		case AcciaioInox_A2:
			tmpMateriale = "Acciaio Inox A2";
			break;
		case AcciaioInox_A4:
			tmpMateriale = "Acciaio Inox A4";
			break;
		case Ottone_OT58:
			tmpMateriale = "Ottone OT58";
			break;
		case Ottone_OT63:
			tmpMateriale = "Ottone OT63";
			break;
		}
	
		switch(rivestimento) {
		case Nessuno:
			tmpRivestimento = "Nessuno";
			break;
		case Brunitura:
			tmpRivestimento = "Brunitura";
			break;
		case Fosfatazione:
			tmpRivestimento = "Fosfatazione";
			break;
		case Zinco_Nichel:
			tmpRivestimento = "Zinco-Nichel";
			break;
		case Zincatura_a_caldo:
			tmpRivestimento = "Zincatura a caldo";
			break;
		}
		
		s += "\nCategoria: " + categoria;
		s += String.format("\nPrezzo: %.2f euro",prezzo);
		s += "\nNumero Pezzi: " + numPezzi;
		s += "\nMateriale: " + tmpMateriale;
		s += "\nRivestimento Protettivo: " + tmpRivestimento;
		s += String.format("\nPeso: %.2f grammi",peso);
		s += "\nLuogo Produzione: " + luogoProduzione;
		s += "\nData Produzione: " + formatter.format(dataProduzione);
		return s;
	}
}
