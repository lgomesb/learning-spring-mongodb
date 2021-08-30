package br.com.learning.customermaintainer.resources.advice;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import br.com.learning.customermaintainer.resources.exception.ApiErros;
import br.com.learning.customermaintainer.resources.exception.ObjectNotFoundException;

@RestControllerAdvice
public class CustomerControllerAdvice {

	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus( code = HttpStatus.BAD_REQUEST)
	public ApiErros handleValidationErros( MethodArgumentNotValidException ex ) {
		BindingResult bindingResult = ex.getBindingResult();
		List<String> messages = bindingResult.getAllErrors()
				.stream()
				.map(objectError -> objectError.getDefaultMessage())
				.collect(Collectors.toList());
		
		return new ApiErros(messages);
	}
	
	@ExceptionHandler(ObjectNotFoundException.class)
	@ResponseStatus( code = HttpStatus.NOT_FOUND)
	public ApiErros notFoundException( ObjectNotFoundException ex ) {		
		return new ApiErros(ex.getMessage());
	}
	
}
