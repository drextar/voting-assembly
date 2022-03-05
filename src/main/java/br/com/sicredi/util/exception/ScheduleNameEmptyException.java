package br.com.sicredi.util.exception;

public class ScheduleNameEmptyException extends RuntimeException {

	private static final long serialVersionUID = -3674471153069128436L;

	public ScheduleNameEmptyException() {
		super();
	}
	
	public ScheduleNameEmptyException(String message, Throwable cause) {
		super(message, cause);
	}
	
	public ScheduleNameEmptyException(String message) {
		super(message);
	}
	public ScheduleNameEmptyException(Throwable cause) {
		super(cause);
	}
}