package com.project.jspProject.pro.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.project.jspProject.pro.Entity.BookEntity;
import com.project.jspProject.pro.Entity.MyBookList;
import com.project.jspProject.pro.Services.BookService;
import com.project.jspProject.pro.Services.MyBookListService;





@Controller
public class BookController {
	@Autowired
	private BookService service;
	
	@Autowired 
	private MyBookListService myBookService;
	@GetMapping("/home")
	public String home() {
		return "home";
	}
	@GetMapping("/book_register")
	public String bookregister() {
		return "BookRegister";
	}
	@GetMapping("/available_books")
	public ModelAndView getAllBooks() {
		List<BookEntity> list=service.getallBook();
		return new ModelAndView("BookList","book",list);
	}
	
	@PostMapping("/save")
	public String addBook(@ModelAttribute BookEntity b) {
		service.save(b);
		return "redirect:/available_books";

	
}
	
	@GetMapping("/my_books")
	public String getMyBooks(Model model) {
		List<MyBookList>list=myBookService.getAllmyBook();
		model.addAttribute("book",list);
		return "MyBooks";
	}
	
	@RequestMapping("/mylist/{id}")
	
	public String getMyList(@PathVariable("id") int id) {
		BookEntity b=service.getBookbyid(id);
		MyBookList mb=new MyBookList(b.getId(),b.getName(),b.getAuthor(),b.getPrice());
		myBookService.saveMybook(mb);
		return "redirect:/my_books";
	}
	
	@RequestMapping("/editbook/{id}")
	public String editBook(@PathVariable("id")int id,Model model) {
		BookEntity b=  service.getBookbyid(id);
		model.addAttribute("book", b);
		return "Bookedit";
	}
	@RequestMapping("/deletebook/{id}")
	public String deleteBook(@PathVariable("id")int id) {
		service.deleteById(id);
		return"redirect:/available_books";
	}
	
	
	
	
}
