package com.project.jspProject.pro.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.jspProject.pro.Entity.MyBookList;
import com.project.jspProject.pro.repository.MyBookRepository;

@Service
public class MyBookListService {
	@Autowired
	private MyBookRepository mybook;
	
	public void saveMybook(MyBookList book) {
		mybook.save(book);
	}
	
	public List<MyBookList> getAllmyBook(){
		return mybook.findAll();
	}
	
	public void deleteById(int id) {
		mybook.deleteById(id);
	}

}
