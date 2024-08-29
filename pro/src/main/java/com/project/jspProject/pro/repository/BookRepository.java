package com.project.jspProject.pro.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.jspProject.pro.Entity.BookEntity;

@Repository
public interface BookRepository extends JpaRepository<BookEntity,Integer>{

}
