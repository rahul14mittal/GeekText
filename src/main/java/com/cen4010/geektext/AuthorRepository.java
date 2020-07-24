package com.cen4010.geektext;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Integer> {

	
	//Author getAuthor(String authorLast); //need this for BooksService
}
