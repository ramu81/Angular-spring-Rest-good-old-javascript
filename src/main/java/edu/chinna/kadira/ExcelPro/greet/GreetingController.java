package edu.chinna.kadira.ExcelPro.greet;

import static java.util.UUID.randomUUID;
import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.chinna.kadira.ExcelPro.repository.Book;
import edu.chinna.kadira.ExcelPro.repository.BookRepository;

@RestController
public class GreetingController {
	private static final Logger logger = LoggerFactory.getLogger(GreetingController.class);

	private final BookRepository bookRepository;

	public GreetingController(BookRepository bookRepository) {
		this.bookRepository = bookRepository;
	}

	@PostMapping("/addBook")
	public ResponseEntity<Object> addBook(@RequestBody Book book) {
		logger.info(".... Add a book ");
		book.setIsbn(randomUUID().toString());
		bookRepository.findBook(book.getIsbn(), book);
		return new ResponseEntity<Object>(book.getName() + " Added ", CREATED);
	}

	@RequestMapping("/books")
	public List<Book> findBooks() {
		logger.info(".... Fetching books");
		return bookRepository.findBooks();
	}

	@DeleteMapping("/deleteBook/{isbn}")
	public ResponseEntity<Object> deleteBook(@PathVariable(value="isbn") String isbn) {
		logger.info(".... delete a book ");
		bookRepository.deleteBook(isbn, null);
		return new ResponseEntity<Object>(" Book Deleted ", OK);
	}
}
