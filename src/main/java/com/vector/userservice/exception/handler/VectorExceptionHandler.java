package com.vector.userservice.exception.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import com.vector.userservice.exception.BaseResp;
import com.vector.userservice.exception.InternalException;

import lombok.extern.slf4j.Slf4j;

@ControllerAdvice
@Slf4j
public class VectorExceptionHandler {
	
	  @SuppressWarnings("unchecked")
	  @ExceptionHandler({InternalException.class})
	  protected ResponseEntity<BaseResp> handleOutcomeCode(Exception e, WebRequest request){
		  BaseResp errorResponse = new BaseResp();
	        InternalException re = (InternalException) e;

	        errorResponse.setCode(re.getCode());
	        errorResponse.setError(re.getError());
	  

	        log.error("Internal Exception - OutcomeCode: " + re.getCode() + " Message: " + re.getError() );
	        return new ResponseEntity(errorResponse, HttpStatus.BAD_REQUEST);
	    }

}
