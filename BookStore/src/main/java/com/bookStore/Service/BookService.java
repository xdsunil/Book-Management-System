package com.bookStore.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookStore.Dao.BookDao;
import com.bookStore.Entity.Book;

@Service
public class BookService {

	@Autowired
	private BookDao bDao;

	public void save(Book b) {
		bDao.save(b); // to save the particular data to the DB
	}

	public List<Book> getAllBooks() {
		return bDao.findAll(); // find all method returns the all data from DB
	}

	public Book getBookById(int id) {
		return bDao.findById(id).get();

	}

	public void deleteById(int id) {
		bDao.deleteById(id);

	}
}
