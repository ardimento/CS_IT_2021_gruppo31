package it.uniba.di.prog2.cs2021.gruppo31.dado;

public class EsagonaleAlto extends AbstractDado {

	private final String denominazione = "Dado Esagonale Alto [UNI 5587]";
	
	public EsagonaleAlto() {}

	public EsagonaleAlto(String metrica, boolean tipoPasso) {
		super(metrica, tipoPasso);
	}

	@Override
	public String getDenominazione() {
		return denominazione;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((denominazione == null) ? 0 : denominazione.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Denominazione: " + denominazione + "\n" + super.toString();
	}
}
