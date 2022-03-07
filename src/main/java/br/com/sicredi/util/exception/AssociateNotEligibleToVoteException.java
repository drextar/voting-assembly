package br.com.sicredi.util.exception;

public class AssociateNotEligibleToVoteException extends RuntimeException {

	private static final long serialVersionUID = -9177823348401351768L;

	public AssociateNotEligibleToVoteException() {
		super();
	}

	public AssociateNotEligibleToVoteException(String message, Throwable cause) {
		super(message, cause);
	}

	public AssociateNotEligibleToVoteException(String message) {
		super(message);
	}
	public AssociateNotEligibleToVoteException(Throwable cause) {
		super(cause);
	}
}
