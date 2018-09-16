package edu.chinna.kadira.ExcelPro.repository;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class SimpleBookRepository implements BookRepository {

	private static final Logger logger = LoggerFactory.getLogger(SimpleBookRepository.class);

	@Cacheable(value = "books", key = "#isbn")
	@Transactional
	public Book findBook(final String isbn, final Book book) {
		logger.info(".... find a book " + isbn);
		return createBook(book);
	}

	@CacheEvict(value = "books", key = "#isbn")
	@Transactional
	public boolean deleteBook(final String isbn, Book book) {
		logger.info(".... delete a book " + isbn);
		for (Book lBook : books) {
			if (lBook.getIsbn().equals(isbn)) {
				book = lBook;
				break;
			}
		}
		return books.remove(book);
	}

	@Transactional
	public Book createBook(final Book book) {
		logger.info(".... create a book " + book.getIsbn());
		books.add(book);
		return book;
	}

	@Override
	@Transactional
	public List<Book> findBooks() {
		List<Book> list = new ArrayList<>();
		for (Book book : books) {
			logger.info(".... book " + book);
			list.add(findBook(book.getIsbn(), book));
		}
		return list;
	}
}
