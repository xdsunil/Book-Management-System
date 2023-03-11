package com.bookStore.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookStore.Dao.MyBookDao;
import com.bookStore.Entity.MyBookList;

@Service
public class MyBookService {

	@Autowired
	private MyBookDao mybook;

	public void saveMyBook(MyBookList book) {
		mybook.save(book);
	}

	public List<MyBookList> getAllMyBooks() {
		return mybook.findAll();

	}

	public void deleteById(int id) {
		mybook.deleteById(id);
	}
}
