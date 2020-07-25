package com.cen4010.geektext;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BooksRepository extends JpaRepository<Books, Integer> {

	List<Books> findByGenreIs(String genre);

	List<Books> findByAverageRatingGreaterThan(Double rating);
	
	List<Books> findByBookCodeIs(Integer isbn);
	
	List<Books> findByAuthorNumIs(Integer authorNum);
	
	//insert here
	

}
