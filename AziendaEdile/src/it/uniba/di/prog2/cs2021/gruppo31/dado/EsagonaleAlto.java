package it.uniba.di.prog2.cs2021.gruppo31.dado;
import java.sql.SQLException;

/**
 * Classe concreta per dado esagonale alto.
 * @author andrea
 * @version 1.1
 */
public class EsagonaleAlto extends AbstractDado {
	
	/** Denominazione del dado: nome + norma */
	private final String denominazione = "Dado Esagonale Alto [UNI 5587]";
	
	/**
	 * Costruttore aparametrico.<br>
	 * Se viene utilizzato questo costruttore, la filettatura deve essere impostata
	 * successivamente con il metodo {@link #setFilettatura(String, boolean)}.
	 */
	public EsagonaleAlto() {}

	/**
	 * Costruttore parametrizzato.<br>
	 * Questo costruttore inizializza la filettatura del dado.
	 * @param metrica Metrica del dado.
	 * @param passoGrosso Tipo di passo del dado.
	 * @throws SQLException
	 * @see AbstractDado#setFilettatura(String, boolean)
	 */
	public EsagonaleAlto(String metrica, boolean passoGrosso) throws SQLException {
		super(metrica, passoGrosso);
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getDenominazione() {
		return denominazione;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((denominazione == null) ? 0 : denominazione.hashCode());
		return (result & 0xfffffff);
	}

	/**
	 * {@inheritDoc}
	 */
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

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String toString() {
		return "Denominazione: " + denominazione + "\n" + super.toString();
	}
}
