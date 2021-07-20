package com.vector.userservice.exception;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class InternalException extends Exception {

	private static final long serialVersionUID = 1L;

	private String code;
	private String error;

	public InternalException(String code, String error) {
		this.code = code;
		this.error = error;

	}

}
