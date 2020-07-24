package com.cen4010.geektext;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BooksRepository extends JpaRepository<Books, Integer> {

	List<Books> findByGenreIs(String genre);

	List<Books> findByAverageRatingGreaterThan(Double rating);
	
	List<Books> findByBookCodeIs(Integer isbn);
	
	List<Books> findByAuthorNumIs(Integer authorNum);
	
	///void addBook(Books book);
	

}
