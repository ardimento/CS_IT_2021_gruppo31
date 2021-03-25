package it.uniba.di.prog2.cs2021.gruppo31.exception;

/**
 * Classe 
 * @author andrea
 * @version 1.1
 */
public class AziendaException extends Exception {

	private static final long serialVersionUID = 1L;

	/**
	 * classe costruttore
	 */
	public AziendaException() {
		super();
	}

	/**
	 * @param message messaggio di errore
	 */
	public AziendaException(String message) {
		super(message);
	}

	/**
	 * @param cause
	 */
	public AziendaException(Throwable cause) {
		super(cause);
	}
	
	/**
	 * @param message
	 * @param cause
	 */
	public AziendaException(String message, Throwable cause) {
		super(message, cause);
	}
}
