package br.com.learning.customermaintainer.domain;

import java.time.LocalDate;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import br.com.learning.customermaintainer.dto.CustomerDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
@Document
public class Customer {

	@Id
	private String id;
	private String name;
	private String document;
	private LocalDate recordDate;

	public Customer(CustomerDTO dto) {
		this.name = dto.getName();
		this.document = dto.getDocument();
	}
}
