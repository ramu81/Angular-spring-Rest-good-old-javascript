package edu.chinna.kadira.ExcelPro.repository;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Data
@AllArgsConstructor
@ToString
public class Book {
	@Setter
	@Getter
	private String isbn;
	
	@Setter
	@Getter
	private String name;
	
	@Setter
	@Getter
	private String author;
	@Setter
	@Getter
	private String publisher;
	@Setter
	@Getter
	private String link;

}
