package com.cen4010.geektext;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BooksRepository extends JpaRepository<Books, Integer> {

//	@Query("SELECT b FROM Books b where b.genre = :gen")
//	public List<Books> findByGenre(@Param("gen") String genre);
}
