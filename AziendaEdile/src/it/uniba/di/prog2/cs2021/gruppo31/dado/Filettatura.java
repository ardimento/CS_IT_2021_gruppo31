package it.uniba.di.prog2.cs2021.gruppo31.dado;

/**
 * Classe che si occupa di gestire la Filettatura del Dado
 * @author andrea
 * @version 1.1
 */
public class Filettatura {
	
	private String metrica;
	private boolean passoGrosso;
	private double dimensionePasso;
	private double misuraPiatti;
	private double altezza;
	
	/**
	 * costruttore 
	 * @param metrica metrica del Dado
	 * @param passoGrosso Passo grosso del dado
	 */
	public Filettatura(String metrica, boolean passoGrosso) {
		this.metrica = metrica;
		this.passoGrosso = passoGrosso;
	}
	
	/**
	 * 
	 * @return metrica del dado
	 */
	public String getMetrica() {
		return metrica;
	}
	
	/**
	 * 
	 * @return intero che indica il diametro
	 */
	public int getDiamentro() {
		String d = metrica.substring(1);
		return Integer.parseInt(d);
	}
	
	/**
	 * 
	 * @return Passo Grosso del dado
	 */
	public boolean isPassoGrosso() {
		return passoGrosso;
	}
	
	/**
	 * 
	 * @return dimensione Passo del dado
	 */
	public double getDimensionePasso() {
		return dimensionePasso;
	}
	
	/**
	 * 
	 * @return misura piatti del dado
	 */
	public double getMisuraPiatti() {
		return misuraPiatti;
	}
	
	/**
	 * 
	 * @return altezza del dado
	 */
	public double getAltezza() {
		return altezza;
	}
	
	/**
	 * 
	 * @param dimensionePasso Dimensione passo del dado
	 */
	public void setDimensionePasso(double dimensionePasso) {
		this.dimensionePasso = dimensionePasso;
	}
	
	/**
	 * 
	 * @param misuraPiatti misura piatti del dado
	 */
	public void setMisuraPiatti(double misuraPiatti) {
		this.misuraPiatti = misuraPiatti;
	}
	
	/**
	 * 
	 * @param altezza Altezza del dado
	 */
	public void setAltezza(double altezza) {
		this.altezza = altezza;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(altezza);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(dimensionePasso);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((metrica == null) ? 0 : metrica.hashCode());
		temp = Double.doubleToLongBits(misuraPiatti);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + (passoGrosso ? 1231 : 1237);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Filettatura other = (Filettatura) obj;
		if (Double.doubleToLongBits(altezza) != Double.doubleToLongBits(other.altezza))
			return false;
		if (Double.doubleToLongBits(dimensionePasso) != Double.doubleToLongBits(other.dimensionePasso))
			return false;
		if (metrica == null) {
			if (other.metrica != null)
				return false;
		} else if (!metrica.equals(other.metrica))
			return false;
		if (Double.doubleToLongBits(misuraPiatti) != Double.doubleToLongBits(other.misuraPiatti))
			return false;
		if (passoGrosso != other.passoGrosso)
			return false;
		return true;
	}

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
