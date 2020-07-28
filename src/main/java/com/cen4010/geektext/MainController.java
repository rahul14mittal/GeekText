package com.cen4010.geektext;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
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
	
	@Autowired
	private ShoppingCartService shoppingCart;
	
	@Autowired
	private ReviewsService reviewsService;
	
	@Autowired
	private UsersService userService;

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

	@GetMapping("/getBookByISBN")
	public List<Books> getBookByISBN(@RequestParam int isbn) {
		return booksService.browseByBookCode(isbn);
	}

	/*@GetMapping("/getBookByAuthor")
	public List<Books> getBookByAuthor(@RequestParam String authorLast) {
		return booksService.browseByAuthor(authorLast);
	}*/
	
	@PostMapping(path = "/addAuthor")
	public @ResponseBody String addNewAuthor(@RequestParam Integer author_num, @RequestParam String author_bio,
			@RequestParam String author_first, @RequestParam String author_last) {
		Author a = new Author();
		a.setAuthorNum(author_num);
		a.setAuthorBio(author_bio);
		a.setAuthorFirst(author_first);
		a.setAuthorLast(author_last);
		
		authorService.addAuthor(author_num, author_bio, author_first, author_last);
		return "Added new author";
	}
	
	@PostMapping(path = "/addBook")
	public @ResponseBody String addNewBook(@RequestParam Integer book_code, @RequestParam Integer author_num, @RequestParam String title, 
			@RequestParam String publisher_code, @RequestParam Double price, @RequestParam String genre, @RequestParam Date year_pub,
			@RequestParam Integer copies_sold, @RequestParam String book_description, @RequestParam Double average_rating) {
		Books b = new Books();
		b.setBookCode(book_code);
		b.setAuthorNum(author_num);
		b.setTitle(title);
		b.setPublisherCode(publisher_code);
		b.setPrice(price);
		b.setGenre(genre);
		b.setYearPub(year_pub);
		b.setCopiesSold(copies_sold);
		b.setBookDescription(book_description);
		b.setAverageRating(average_rating);
		
	    booksService.addBook(book_code, author_num, title, publisher_code, price, genre, year_pub, copies_sold, book_description, average_rating);
		return "Added new book";
	}
	
	

	// -------------------------------------------

	// User Review Feature Calls

	
	@PostMapping("/addReview")
	@ResponseBody
	public String addReview(@RequestParam Integer reviewID, @RequestParam Integer bookCode, @RequestParam Integer userID, 
			@RequestParam Double rating, @RequestParam String comment, @RequestParam Date datestamp) {
		
		return "Review Added";
	}
	
	
	
	
	// -------------------------------------------

	// Shopping Cart Feature Calls
	@PostMapping("/addItem")
	@ResponseBody
	public String addItem(@RequestParam(name = "userId") Integer userId, @RequestParam(name = "bookCode") Integer bookCode) {
		CartItem item = new CartItem();
		item.setUserId(userId);
		item.setBookCode(bookCode);
		shoppingCart.addItem(item);
		
		return "Added item to cart";
	}
	
	@DeleteMapping("/removeItem")
	@ResponseBody
	public String removeItem(@RequestParam(name = "userId") Integer userId, @RequestParam(name = "bookCode") Integer bookCode) {
		CartItem item = new CartItem();
		item.setUserId(userId);
		item.setBookCode(bookCode);
		shoppingCart.removeItem(item);
		
		return "Removed item from cart";
	}
	
	@GetMapping("/listItems")
	@ResponseBody
	public List<CartItem> listItems(@RequestParam Integer userId){
		return shoppingCart.listItems(userId);
	}

	// -------------------------------------------
	// Users feature calls
	@GetMapping("/getAllUsers")
	public List<Users> getAllUsers() {
		return userService.getAllUsers();
	}
}
