package com.project.jspProject.pro.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.jspProject.pro.Entity.BookEntity;
import com.project.jspProject.pro.repository.BookRepository;
@Service
public class BookService {
	
	@Autowired
	private BookRepository bRepo;
	
	public void save(BookEntity b) {
		 bRepo.save(b);
		
	}
	
	public List<BookEntity> getallBook(){
		return bRepo.findAll();
		
	}
	
	public BookEntity getBookbyid(int id) {
		return bRepo.findById(id).get();
		
	}
	public void deleteById(int id) {
		bRepo.deleteById(id);
	}

}
