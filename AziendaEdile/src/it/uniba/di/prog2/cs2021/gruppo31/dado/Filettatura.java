package it.uniba.di.prog2.cs2021.gruppo31.dado;

public class Filettatura {
	
	private String metrica;
	private boolean passoGrosso;
	private double dimensionePasso;
	private double misuraPiatti;
	private double altezza;
	
	public Filettatura(String metrica, boolean passoGrosso) {
		this.metrica = metrica;
		this.passoGrosso = passoGrosso;
		//this.dimensionePasso = dimensionePasso;
		//this.misuraPiatti = misuraPiatti;
		//this.altezza = altezza;
	}
	
	public String getMetrica() {
		return metrica;
	}
	
	public int getDiamentro() {
		String d = metrica.substring(1);
		return Integer.parseInt(d);
	}

	public boolean isPassoGrosso() {
		return passoGrosso;
	}

	public double getDimensionePasso() {
		return dimensionePasso;
	}

	public double getMisuraPiatti() {
		return misuraPiatti;
	}

	public double getAltezza() {
		return altezza;
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
