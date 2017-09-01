package com.cust.common;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author Inderjit
 *
 */
public class ApplicationException extends Exception
{

	private static final long serialVersionUID = 1L;

	private List<String> errorMessages;
	private Exception exception;

	public ApplicationException() {

		errorMessages = new ArrayList<String>();
		this.exception = null;
	}

	public Exception getException() {
		return exception;
	}

	public ApplicationException(String message) {
		super(message);
	}

	public ApplicationException(Exception exception) {
		super(exception.getMessage(), exception);
	}

	public ApplicationException(String message, Exception exception) {
		errorMessages = new ArrayList<String>();
		errorMessages.add(message);
		this.exception = exception;
	}

	public List<String> getErrorMessages() {
		return this.errorMessages;
	}

	public void addErrorMessage(String string) {
		errorMessages.add(string);
	}
}
