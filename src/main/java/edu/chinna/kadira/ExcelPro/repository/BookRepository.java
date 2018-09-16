package edu.chinna.kadira.ExcelPro.repository;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 
 * @author rakondapalli
 *
 */
public interface BookRepository {

	Set<Book> books = Collections.synchronizedSet(new HashSet<Book>());

	Book findBook(String isbn, Book book);

	Book createBook(Book book);

	boolean deleteBook(String isbn, Book book);

	List<Book> findBooks();
}
