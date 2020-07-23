package com.cen4010.geektext;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/demo")
public class MainController {

	@Autowired
	private BooksService booksService;

	@Autowired
	private AuthorService authorService;

	// Book Browsing Feature Calls
	@GetMapping("/getAllBooks")
	public List<Books> getAllBooks() {
		return booksService.getAllBooks();
	}

	@GetMapping("/topSellers")
	public List<Books> getTopSellers() {
		return booksService.getTopSellers();
	}

	@GetMapping("/browseByNum")
	public List<Books> getXBooks(@RequestParam int x) {
		return booksService.getXBooks(x);
	}

	@GetMapping("/browseByGenre")
	public List<Books> browseByGenre(@RequestParam String genre) {
		return booksService.browseByGenre(genre);
	}

	@GetMapping("/browseByRating")
	public List<Books> browseByRating(@RequestParam Double rating) {
		return booksService.browseByRating(rating);
	}

	// -------------------------------------------

	// Book Details Feature Calls

	@GetMapping("/getAllAuthors")
	public List<Author> getAllAuthors() {
		return authorService.getAllAuthors();
	}

	@PostMapping(path = "/addAuthor")
	public @ResponseBody String addNewAuthor(@RequestParam Integer authorNum, @RequestParam String authorLast,
			@RequestParam String authorFirst, @RequestParam String authorBio) {
		Author a = new Author();
		a.setAuthorNum(authorNum);
		a.setAuthorLast(authorLast);
		a.setAuthorFirst(authorFirst);
		a.setAuthorBio(authorBio);

		authorService.addAuthor(a);
		return "Added new author";
	}

	// -------------------------------------------

	// User Review Feature Calls

	// -------------------------------------------

	// Shopping Cart Feature Calls

	// -------------------------------------------

}
