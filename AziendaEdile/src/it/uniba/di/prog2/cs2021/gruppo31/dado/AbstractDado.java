package it.uniba.di.prog2.cs2021.gruppo31.dado;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import it.uniba.di.prog2.cs2021.gruppo31.exception.AziendaException;
import it.uniba.di.prog2.cs2021.gruppo31.database.ProxyDB;;

/**
 * Classe astratta dado 
 * @author andrea
 * @version 1.1
 */
public abstract class AbstractDado implements Dado {
	
	private Materiale materiale;
	private Categoria categoria;
	private RivestimentoProtettivo rivestimento;
	private Filettatura filettatura;
	private String luogoProduzione;
	private Date dataProduzione;
	private double prezzo;
	private double peso;
	private int numPezzi = 1;
	
	public AbstractDado() {}
	
	/**
	 * @param metrica 
	 * @param passoGrosso
	 * @throws SQLException
	 */
	public AbstractDado(String metrica, boolean passoGrosso) throws SQLException{
		this.setFilettatura(metrica, passoGrosso);
	}
	
	@Override
	public String getMateriale() {
		return materiale.toString();
	}

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

	@Override
	public String getCategoria() {
		return categoria.toString();
	}

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

	@Override
	public String getRivestimentoProtettivo() {
		return rivestimento.toString();
	}

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

	@Override
	public Filettatura getFilettatura() {
		return filettatura;
	}
	
	public String getFilettaturaString() {
		return filettatura.toString();
	}

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
	
	@Override
	public double getPeso() {
		return peso;
	}

	@Override
	public int getNumPezzi() {
		return numPezzi;
	}

	@Override
	public boolean setNumPezzi(int numPezzi) {
		if(numPezzi >= 0) {
			this.numPezzi = numPezzi;
			return true;
		}
		else
			return false;
	}

	@Override
	public double getPrezzo() {
		return prezzo;
	}

	@Override
	public boolean setPrezzo(double prezzo) {
		if(prezzo >= 0) {
			this.prezzo = prezzo;
			return true;
		}
		else
			return false;
	}

	@Override
	public String getLuogoProduzione() {
		return luogoProduzione;
	}

	@Override
	public void setLuogoProduzione(String luogoProduzione) {
		this.luogoProduzione = luogoProduzione;
	}

	@Override
	public Date getDataProduzione() {
		return dataProduzione;
	}

	@Override
	public void setDataProduzione(Date dataProduzione) {
		this.dataProduzione = dataProduzione;
	}

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
		return (result & 0xfffffff);
	}

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

	@Override
	public String toString() {
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		String s = "Filettatura: " + filettatura.toString();
		s += "\nCategoria: " + categoria;
		s += "\nPrezzo: € " + prezzo;
		s += "\nNumero Pezzi: " + numPezzi;
		s += "\nMateriale: " + materiale;
		s += "\nRivestimento Protettivo: " + rivestimento;
		s += String.format("\nPeso: %.3f grammi",peso);
		s += "\nLuogo Produzione: " + luogoProduzione;
		s += "\nData Produzione: " + formatter.format(dataProduzione);
		return s;
	}
}
