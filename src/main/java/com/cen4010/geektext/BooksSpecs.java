package com.cen4010.geektext;



import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

public class BooksSpecs {
	
	private BooksRepository booksRepository;

	
	@PostMapping(path="/addBook")
	public @ResponseBody String addNewBook ()
	{
		Books b = new Books();
		
		booksRepository.save(b);
		return "Added new book";
	}
	
	@GetMapping(path="/getAllBooks")
	public @ResponseBody Iterable<Books> getAllBooks()
	{
		return booksRepository.findAll();
	}
	
	

	@GetMapping(path="/getBook")
	public @ResponseBody Iterable<Books> getBookByISBN(@RequestParam Integer ISBN)
	{
		@Query("SELECT e from Employee e where e.joinedDate between :startDate and :endDate")
		;
		return booksRepository.findAll();
	}
	
//	@GetMapping(path="/browseByGenre")
//	public @ResponseBody Iterable<Books> browseByGenre()
//	{
//		return booksRepository.findAll();
//	}
//	

}
