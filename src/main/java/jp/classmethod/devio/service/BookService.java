package jp.classmethod.devio.service;

import jp.classmethod.devio.model.Book;
import jp.classmethod.devio.model.BookRepository;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by mochizukimasao on 2017/10/26.
 *
 * @author mochizukimasao
 * @since version
 */
@Service
@RequiredArgsConstructor
public class BookService {
	
	@NonNull
	BookRepository bookRepository;
	
	public List<Book> listBooks() {
		List<Book> list = new ArrayList<>();
		Iterable<Book> iterable = bookRepository.findAll();
		iterable.forEach(list::add);
		return list;
	}

	@Transactional
	public Book registerBook(Book book) {
		return bookRepository.save(book);
	}
}
