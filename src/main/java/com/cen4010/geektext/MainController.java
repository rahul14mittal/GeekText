package com.cen4010.geektext;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller	// This means that this class is a Controller
@RequestMapping(path="/demo") 
public class MainController {

	@Autowired
	
	private BooksRepository booksRepository;
	private AuthorRepository authorRepository;
	
	@PostMapping(path="/addBook")
	public @ResponseBody String addNewBook ()
	{
		Books b = new Books();
		
		booksRepository.save(b);
		return "Added new book";
	}
	
	@GetMapping(path="/getBook")
	public @ResponseBody Iterable<Books> getAllBooks()
	{
		return booksRepository.findAll();
	}
	
	@GetMapping(path="/getAuthor")
	public @ResponseBody Iterable<Author> getAuthors()
	{
		return authorRepository.findAll();
	}

	@PostMapping(path="/addAuthor")
	public @ResponseBody String addNewAuthor (@RequestParam Integer authorNum, @RequestParam String authorLast,@RequestParam String authorFirst,@RequestParam String authorBio  )
	{
		Author a = new Author();
		a.setAuthorNum(authorNum);
		a.setAuthorLast(authorLast);
		a.setAuthorFirst(authorFirst);
		a.setAuthorBio(authorBio);
		
		authorRepository.save(a);
		return "Added new author";
	}
}
