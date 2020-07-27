package com.cen4010.geektext;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface BooksRepository extends JpaRepository<Books, Integer> {

	List<Books> findByGenreIs(String genre);

	List<Books> findByAverageRatingGreaterThan(Double rating);
	
	List<Books> findByBookCodeIs(Integer isbn);
	
	List<Books> findByAuthorNumIs(Integer authorNum);
	

	/*@Transactional
	@Query(value = "INSERT INTO books (book_code, author_num, average_rating, book_description, copies_sold, genre, price, publisher_code)"
			+ "VALUES (:book_code, :author_num, :average_rating, :book_description, :copies_sold, :genre, :price, :publisher_code)", nativeQuery = true)
	@Modifying
	void insertBook(@Param ("book_code") Integer book_code, @Param("author_num") Integer author_num, @Param ("average_rating") Double average_rating, @Param ("book_description") String book_description,
			@Param ("copies_sold") Integer copies_sold, @Param ("genre") String genre, @Param ("price") Double price, @Param ("publisher_code") Integer publisher_code);*/

}
