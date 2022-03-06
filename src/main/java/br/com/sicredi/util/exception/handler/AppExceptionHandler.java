package br.com.sicredi.util.exception.handler;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import br.com.sicredi.util.exception.ScheduleNameEmptyException;
import br.com.sicredi.util.exception.AssociateHasAlreadyVotedException;
import br.com.sicredi.util.exception.AssociateNotFoundException;
import br.com.sicredi.util.exception.ScheduleInvalidIdException;
import br.com.sicredi.util.exception.SessionExpirateTimeException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


@ControllerAdvice
public class AppExceptionHandler extends ResponseEntityExceptionHandler {
	
	final String timeStamp = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	

	@ExceptionHandler(value = {Exception.class})
	public ResponseEntity<Object> handleAnyException(Exception e, WebRequest request) {
				
		String errorDescription = e.getLocalizedMessage();
		if(errorDescription == null) errorDescription = e.toString();
		
		ErrorMessage errorMessage = new ErrorMessage(timeStamp, errorDescription);
		return new ResponseEntity<>(errorMessage, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(value = {AssociateNotFoundException.class})
	public ResponseEntity<Object> associateNotFoundException(Exception e, WebRequest request) {
						
		String errorDescription = e.getLocalizedMessage();
		if(errorDescription == null) errorDescription = e.toString();
		
		ErrorMessage errorMessage = new ErrorMessage(timeStamp, errorDescription);
		return new ResponseEntity<>(errorMessage, new HttpHeaders(), HttpStatus.NOT_ACCEPTABLE);
	}
	
	@ExceptionHandler(value = {SessionExpirateTimeException.class})
	public ResponseEntity<Object> sessionExpirateTimeException(Exception e, WebRequest request) {
						
		String errorDescription = e.getLocalizedMessage();
		if(errorDescription == null) errorDescription = e.toString();
		
		ErrorMessage errorMessage = new ErrorMessage(timeStamp, errorDescription);
		return new ResponseEntity<>(errorMessage, new HttpHeaders(), HttpStatus.NOT_ACCEPTABLE);
	}
	
	@ExceptionHandler(value = {ScheduleNameEmptyException.class})
	public ResponseEntity<Object> scheduleNameEmpty(Exception e, WebRequest request) {
						
		String errorDescription = e.getLocalizedMessage();
		if(errorDescription == null) errorDescription = e.toString();
		
		ErrorMessage errorMessage = new ErrorMessage(timeStamp, errorDescription);
		return new ResponseEntity<>(errorMessage, new HttpHeaders(), HttpStatus.NOT_ACCEPTABLE);
	}
	
	@ExceptionHandler(value = {ScheduleInvalidIdException.class})
	public ResponseEntity<Object> scheduleInvalidIdException(Exception e, WebRequest request) {
						
		String errorDescription = e.getLocalizedMessage();
		if(errorDescription == null) errorDescription = e.toString();
		
		ErrorMessage errorMessage = new ErrorMessage(timeStamp, errorDescription);
		return new ResponseEntity<>(errorMessage, new HttpHeaders(), HttpStatus.NOT_ACCEPTABLE);
	}
	
	@ExceptionHandler(value = {AssociateHasAlreadyVotedException.class})
	public ResponseEntity<Object> associateHasAlreadyVotedException(Exception e, WebRequest request) {
						
		String errorDescription = e.getLocalizedMessage();
		if(errorDescription == null) errorDescription = e.toString();
		
		ErrorMessage errorMessage = new ErrorMessage(timeStamp, errorDescription);
		return new ResponseEntity<>(errorMessage, new HttpHeaders(), HttpStatus.NOT_ACCEPTABLE);
	}
	
}
