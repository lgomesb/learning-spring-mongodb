package br.com.learning.customermaintainer.resources.exception;

public class ObjectNotFoundException extends Exception {
	
	private static final long serialVersionUID = 1L;

	public ObjectNotFoundException(String message) {
		super(message);
	}
	
}
