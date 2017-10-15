package rs.mk.exception;

import org.springframework.web.bind.MethodArgumentNotValidException;

import org.springframework.web.bind.annotation.ControllerAdvice;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

@ControllerAdvice  
@RestController  
public class GlobalExceptionHandler {  
	
	private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

	@ResponseStatus(HttpStatus.NOT_FOUND)  
	@ExceptionHandler(value = CustomNotFoundException.class)  
	public String handleNotFoundException(CustomNotFoundException e){ 
		LOGGER.debug("CustomNotFoundException");
		return e.getMessage();  
	} 

} 
