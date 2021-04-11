package id.co.fahmikudo.shop.shopapp.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ErrorResponseHandler {
    
    @ExceptionHandler(ErrorResponseException.class)
	public ResponseEntity<?> handleControllerException(ErrorResponseException ex) {
		return new ResponseEntity<>(ex.getMessage(), ex.getHttpStatus());
	}


}
