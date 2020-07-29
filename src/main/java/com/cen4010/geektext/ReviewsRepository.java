package com.cen4010.geektext;

import java.sql.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface ReviewsRepository extends JpaRepository<Reviews, Integer> {
	@Transactional
	@Query(value = "INSERT INTO reviews (reviewid, book_code, comment, datestamp, rating, userid"
	+ "VALUES (:reviewid, :book_code, :comment, :datestamp, :rating, :userid)", nativeQuery = true)
	@Modifying
	void insertReview(@Param("reviewid") Integer reviewid, @Param("book_code") Integer book_code, @Param("comment") 
	String comment, @Param("datestamp") Date datestamp, @Param("rating") Double rating, @Param("userid") Integer userID);
	
	
	
}
