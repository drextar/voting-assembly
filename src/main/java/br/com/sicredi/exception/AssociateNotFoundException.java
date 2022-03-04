package br.com.sicredi.exception;

public class AssociateNotFoundException extends RuntimeException {

	private static final long serialVersionUID = -9177823348401351768L;

	public AssociateNotFoundException() {
		super();
	}
	
	public AssociateNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}
	
	public AssociateNotFoundException(String message) {
		super(message);
	}
	public AssociateNotFoundException(Throwable cause) {
		super(cause);
	}
}
