package br.com.learning.customermaintainer.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CustomerDTO {

	@NotNull(message = "Nome é obrigatório")
	@NotEmpty( message = "Nome é obrigatório" )
	private String name;	
	
	@NotNull(message = "Documeto é obrigatório")
	@NotEmpty( message = "Documeto é obrigatório" )
	private String document;

}
