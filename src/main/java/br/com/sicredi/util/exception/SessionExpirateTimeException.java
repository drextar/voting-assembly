package br.com.sicredi.util.exception;

public class SessionExpirateTimeException extends RuntimeException {

	private static final long serialVersionUID = -3674471153069128436L;

	public SessionExpirateTimeException() {
		super();
	}
	
	public SessionExpirateTimeException(String message, Throwable cause) {
		super(message, cause);
	}
	
	public SessionExpirateTimeException(String message) {
		super(message);
	}
	public SessionExpirateTimeException(Throwable cause) {
		super(cause);
	}
}