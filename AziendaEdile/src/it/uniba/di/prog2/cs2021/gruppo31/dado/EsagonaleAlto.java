package it.uniba.di.prog2.cs2021.gruppo31.dado;

import java.sql.SQLException;

/**
 * Estensione della classe abstractDado 
 * @author andrea
 * @version 1.1
 */
public class EsagonaleAlto extends AbstractDado {

	private final String denominazione = "Dado Esagonale Alto [UNI 5587]";
	
	public EsagonaleAlto() {}
/**
 * 
 * @param metrica
 * @param passoGrosso
 * @throws SQLException
 */
	public EsagonaleAlto(String metrica, boolean passoGrosso) throws SQLException {
		super(metrica, passoGrosso);
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
		return (result & 0xfffffff);
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
