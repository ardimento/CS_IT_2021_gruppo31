package it.uniba.di.prog2.cs2021.gruppo31.exception;

public class AziendaException extends Exception {

	private static final long serialVersionUID = 1L;

	public AziendaException() {
		super();
	}

	public AziendaException(String message) {
		super(message);
	}

	public AziendaException(Throwable cause) {
		super(cause);
	}
	
	public AziendaException(String message, Throwable cause) {
		super(message, cause);
	}
}
