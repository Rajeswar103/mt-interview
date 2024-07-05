package com.mouritech.appointmentscheduling.globalexceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.mouritech.appointmentscheduling.exceptions.ApprovedDetailsExcepection;
import com.mouritech.appointmentscheduling.exceptions.DetailsNotFoundException;
import com.mouritech.appointmentscheduling.exceptions.EmptyException;
import com.mouritech.appointmentscheduling.exceptions.IdNotFoundException;
import com.mouritech.appointmentscheduling.exceptions.NotEligibleException;
import com.mouritech.appointmentscheduling.exceptions.NotEligibleRegisterException;
import com.mouritech.appointmentscheduling.exceptions.SearchNotFoundException;
import com.mouritech.appointmentscheduling.exceptions.UserNameExistsException;
import com.mouritech.appointmentscheduling.exceptions.UserNameNotExist;

import io.jsonwebtoken.security.SignatureException;

@RestControllerAdvice
public class GlobalExceptions {
	
	
	
	@ExceptionHandler(DetailsNotFoundException.class)
	public ResponseEntity<String> handleExceptions(DetailsNotFoundException exception)
	{
		return new ResponseEntity<String>(exception.getMessage(),HttpStatus.BAD_REQUEST);
		
	}
	@ExceptionHandler(NotEligibleException.class)
	public ResponseEntity<String> handleExceptions(NotEligibleException exception)
	{
		return new ResponseEntity<String>(exception.getMessage(),HttpStatus.BAD_REQUEST);
		
	}
	@ExceptionHandler(EmptyException.class)
	public ResponseEntity<String> handleExceptions(EmptyException exception)
	{
		return new ResponseEntity<String>(exception.getMessage(),HttpStatus.BAD_REQUEST);
		
	}
	@ExceptionHandler(IdNotFoundException.class)
	public ResponseEntity<String> handleExceptions(IdNotFoundException exception)
	{
		return new ResponseEntity<String>(exception.getMessage(),HttpStatus.BAD_REQUEST);
		
	}
	@ExceptionHandler(SearchNotFoundException.class)
	public ResponseEntity<String> handleExceptions(SearchNotFoundException exception)
	{
		return new ResponseEntity<String>(exception.getMessage(),HttpStatus.BAD_REQUEST);
		
	}
	@ExceptionHandler(ApprovedDetailsExcepection.class)
	public ResponseEntity<String> handleExceptions(ApprovedDetailsExcepection exception)
	{
		return new ResponseEntity<String>(exception.getMessage(),HttpStatus.BAD_REQUEST);
		
	}
	@ExceptionHandler(NotEligibleRegisterException.class)
	public ResponseEntity<String> handleExceptions(NotEligibleRegisterException exception)
	{
		return new ResponseEntity<String>(exception.getMessage(),HttpStatus.BAD_REQUEST);
		
	}
	@ExceptionHandler(UserNameExistsException.class)
	public ResponseEntity<String> handleExceptions(UserNameExistsException exception)
	{
		return new ResponseEntity<String>(exception.getMessage(),HttpStatus.BAD_REQUEST);
		
	}
	
	    @ExceptionHandler(SignatureException.class)
	    public ResponseEntity<String> handleSignatureException(SignatureException ex) {
	        return new ResponseEntity<String>("your token is InCorrect", HttpStatus.UNAUTHORIZED);
	    }
//	@ExceptionHandler(UsernameNotFoundException.class)
//	public ResponseEntity<String> handleExceptions(UsernameNotFoundException exception)
//	{
//		return new ResponseEntity<String>(exception.getMessage(),HttpStatus.BAD_REQUEST);
//		
//	}
	    @ExceptionHandler(UserNameNotExist.class)
		public ResponseEntity<String> handleExceptions(UserNameNotExist exception)
		{
			return new ResponseEntity<String>(exception.getMessage(),HttpStatus.BAD_REQUEST);
			
		}
}
