package id.co.fahmikudo.shop.shopapp.exception;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ErrorResponseException extends RuntimeException {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    
    private final HttpStatus httpStatus;
    private final String message;

}
