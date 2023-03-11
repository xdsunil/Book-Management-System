package com.bookStore.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.bookStore.Entity.Book;
import com.bookStore.Entity.MyBookList;
import com.bookStore.Service.BookService;
import com.bookStore.Service.MyBookService;

@Controller
public class BookController {

	@Autowired
	private BookService service;

	@Autowired
	private MyBookService myBookService;

	@GetMapping("/")
	public String home() {

		return "home";
	}

	@GetMapping("/book_register")
	public String bookRegister() {
		return "bookRegister";
	}

	@GetMapping("/available_book")
	public ModelAndView getAllBooks() {
		List<Book> list = service.getAllBooks();

		// ModelAndView m=new ModelAndView();
		// m.setViewName("bookList");
		// m.addObject("book", list);

		return new ModelAndView("bookListPage", "book", list);
	}

	@PostMapping("/save")
	public String addBook(@ModelAttribute Book b) {
		service.save(b);
		return "redirect:/available_book";
	}

	@GetMapping("/my_books")
	public String getMyBooks(Model model) {
		List<MyBookList> list = myBookService.getAllMyBooks();
		model.addAttribute("book", list);
		return "myBook"; // return in myBook.html
	}

	@RequestMapping("/myList/{id}")
	public String getMyList(@PathVariable("id") int id) {
		Book b = service.getBookById(id);
		MyBookList mb = new MyBookList(b.getId(), b.getName(), b.getAuthor(), b.getPrice());
		myBookService.saveMyBook(mb);
		return "redirect:/my_books";
	}

	@RequestMapping("/editBook/{id}")
	public String editBook(@PathVariable("id") int id, Model model) {
		Book b = service.getBookById(id);
		model.addAttribute("book", b);
		return "bookEdit";
	}

	@RequestMapping("/deleteBook/{id}")
	public String deleteBook(@PathVariable("id") int id) {
		service.deleteById(id);
		return "redirect:/available_book";
	}
}
