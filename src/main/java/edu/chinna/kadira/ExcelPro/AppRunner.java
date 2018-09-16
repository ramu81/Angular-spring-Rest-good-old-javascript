package edu.chinna.kadira.ExcelPro;

import static java.util.UUID.randomUUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import edu.chinna.kadira.ExcelPro.repository.Book;
import edu.chinna.kadira.ExcelPro.repository.BookRepository;

@Component
public class AppRunner implements CommandLineRunner {

	private static final Logger logger = LoggerFactory.getLogger(AppRunner.class);

	private final BookRepository bookRepository;

	public AppRunner(BookRepository bookRepository) {
		this.bookRepository = bookRepository;
	}

	@Override
	public void run(String... args) throws Exception {
		Book book = new Book(randomUUID().toString(), "Spring & Angular", "Ram Kondapalli(RK)", "O'relly", "Link ");
		logger.info(bookRepository.findBook(book.getIsbn(), book).toString());
		book = new Book(randomUUID().toString(), " Java & Scala ", " Vasantha Kondapalli (VK) ", "O'relly", "Link ");
		logger.info(bookRepository.findBook(book.getIsbn(), book).toString());
		book = new Book(randomUUID().toString(), " Java & Scala ", " Sai Charan Kondapalli (CK) ", "O'relly", "Link ");
		logger.info(bookRepository.findBook(book.getIsbn(), book).toString());
	}

}
