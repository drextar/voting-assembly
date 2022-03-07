package br.com.sicredi.util.exception;

public class AssociateCpfInvalidException extends RuntimeException {

	private static final long serialVersionUID = -9177823348401351768L;

	public AssociateCpfInvalidException() {
		super();
	}

	public AssociateCpfInvalidException(String message, Throwable cause) {
		super(message, cause);
	}

	public AssociateCpfInvalidException(String message) {
		super(message);
	}
	public AssociateCpfInvalidException(Throwable cause) {
		super(cause);
	}
}
