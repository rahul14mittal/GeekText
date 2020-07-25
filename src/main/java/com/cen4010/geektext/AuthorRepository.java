package com.cen4010.geektext;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface AuthorRepository extends JpaRepository<Author, Integer> {

	
	//List<Author> findAuthorByAuthor_LastIs(String authorLast); 
	
	@Query(value = "INSERT INTO authors (author_num, age, author_bio, author_first, author_last)"
			+ "VALUES (:author_num, :author_bio, :author_first, :author_last)", nativeQuery = true)
	@Modifying
	void insertAuthor(@Param("author_num") Integer author_num, @Param("author_bio") String author_bio, 
			@Param("author_first") String author_first, @Param("author_last") String author_last);
	

}
