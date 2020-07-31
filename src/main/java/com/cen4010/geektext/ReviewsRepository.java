package com.cen4010.geektext;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface ReviewsRepository extends JpaRepository<Reviews, Integer> {
	
	List<Reviews> findByOrderByRatingDesc();
	
	@Transactional
	@Query(value = "INSERT INTO reviews (reviewid, book_code, comment, datestamp, rating, userid)"
	+ "VALUES (:reviewid, :book_code, :comment, :datestamp, :rating, :userid)", nativeQuery = true)
	@Modifying
	void insertReview(@Param("reviewid") Integer reviewid, @Param("book_code") Integer book_code, @Param("comment") 
	String comment, @Param("datestamp") Date datestamp, @Param("rating") Double rating, @Param("userid") Integer userID);
	
	@Transactional
	@Query(value ="SELECT AVG(rating) FROM reviews WHERE reviews.book_code = (:book_code)", nativeQuery = true) 
	List<Double> pullAvg(@Param("book_code") Integer book_code);

	
	
	
}
