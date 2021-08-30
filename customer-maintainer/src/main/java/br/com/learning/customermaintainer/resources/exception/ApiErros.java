package br.com.learning.customermaintainer.resources.exception;

import java.util.Arrays;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ApiErros {

	private List<String> errors;

	public ApiErros(String message) {
		this.errors = Arrays.asList(message);
	}
	
}
