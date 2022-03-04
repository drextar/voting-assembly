package br.com.sicredi.exception;

public class ScheduleInvalidIdException extends RuntimeException {

	private static final long serialVersionUID = -3674471153069128436L;

	public ScheduleInvalidIdException() {
		super();
	}
	
	public ScheduleInvalidIdException(String message, Throwable cause) {
		super(message, cause);
	}
	
	public ScheduleInvalidIdException(String message) {
		super(message);
	}
	public ScheduleInvalidIdException(Throwable cause) {
		super(cause);
	}
}