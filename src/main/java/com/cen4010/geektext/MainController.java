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
	
	@PostMapping(path="/addBook")
	public @ResponseBody String addNewBook ()
	{
		Books b = new Books();
		
		booksRepository.save(b);
		return "Saved";
	}
	
	@GetMapping(path="/getBook")
	public @ResponseBody Iterable<Books> getAllBooks()
	{
		return booksRepository.findAll();
	}
}
