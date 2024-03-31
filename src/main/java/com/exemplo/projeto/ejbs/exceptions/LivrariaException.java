package com.exemplo.projeto.ejbs.exceptions;

import javax.ejb.ApplicationException;

@ApplicationException(rollback = true)
public class LivrariaException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
