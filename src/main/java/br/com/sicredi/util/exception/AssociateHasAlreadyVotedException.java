package br.com.sicredi.util.exception;

public class AssociateHasAlreadyVotedException extends RuntimeException {

	private static final long serialVersionUID = -9177823348401351768L;

	public AssociateHasAlreadyVotedException() {
		super();
	}
	
	public AssociateHasAlreadyVotedException(String message, Throwable cause) {
		super(message, cause);
	}
	
	public AssociateHasAlreadyVotedException(String message) {
		super(message);
	}
	public AssociateHasAlreadyVotedException(Throwable cause) {
		super(cause);
	}
}
