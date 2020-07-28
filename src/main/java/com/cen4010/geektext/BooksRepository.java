package com.cen4010.geektext;

import java.sql.Date;
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
	
	List<Books> findByBookCodeIs(Integer book_code);
	
	//List<Books> findByAuthor_NumIs(Integer author_num);
	

	@Transactional
	@Query(value = "INSERT INTO books (book_code, author_num, title, publisher_code, price, genre, year_pub, copies_sold, book_description, average_rating)"
			+ "VALUES (:book_code, :author_num, :title, :publisher_code, :price, :genre, :year_pub, :copies_sold, :book_description, :average_rating)", nativeQuery = true)
	@Modifying
	void insertBook(@Param("book_code") Integer book_code, @Param("author_num") Integer author_num, @Param("title") String title, @Param("publisher_code") String publisher_code, @Param("price") Double price, @Param("genre") String genre,
			@Param("year_pub") Date year_pub, @Param("copies_sold") Integer copies_sold, @Param("book_description") String book_description, @Param("average_rating") Double average_rating);

}
