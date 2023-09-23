package com.api.book.bootrestbook.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.api.book.bootrestbook.dao.BookRepository;
import com.api.book.bootrestbook.entities.Book;

@Component
public class BookService {
//	private static List<Book> list = new ArrayList<>();
//	static {
//		list.add(new Book(12, "Chemistry"));
//		list.add(new Book(13, "Java For DP"));
//		list.add(new Book(14, "Python For ABC"));
//		list.add(new Book(15, "DBMS"));
//	}
	
	@Autowired
	private BookRepository bookRepository;

	public List<Book> getAllBook() {
		List <Book> list=(List<Book>) this.bookRepository.findAll();
		return list;
	}

	public Book getBookById(int id) {
		Book book = null;
		try {
//			book = list.stream().filter(e -> e.getId() == id).findFirst().get();
			book = this.bookRepository.findById(id);

		} catch (Exception e2) {
			e2.printStackTrace();
		}

		return book;
	}

	public Book addBook(Book book) {
//		list.add(book);
		Book b=bookRepository.save(book);
		return b;
	}

	public void deleteBook(int deleteId) {
//		list = list.stream().filter(e -> e.getId() != deleteId).collect(Collectors.toList());
		bookRepository.deleteById(deleteId);
	}

	public Book updateBook(Book book, int bookId) {
//		Book b = list.stream().filter(e -> e.getId() == bookId).findFirst().get();
//		b.setId(book.getId());
//		b.setName(book.getName());
		book.setId(bookId);
		Book b=bookRepository.save(book);
		return b;
	}

}
