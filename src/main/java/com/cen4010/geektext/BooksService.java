package com.cen4010.geektext;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class BooksService {

	@Autowired
	private BooksRepository booksRepository;
	@Autowired
	private AuthorRepository authorsRepository;
	
	public List<Books> getAllBooks() {
		List<Books> books = new ArrayList<>();
		booksRepository.findAll().forEach(books::add);
		return books;
	}

	public List<Books> getTopSellers() {
		List<Books> books = new ArrayList<>();
		Page<Books> page = booksRepository.findAll(PageRequest.of(0, 10, Sort.by(Sort.Direction.DESC, "copiesSold")));
		books = page.getContent();
		return books;
	}

	public List<Books> getXBooks(int n) {
		List<Books> books = new ArrayList<>();
		Page<Books> page = booksRepository.findAll(PageRequest.of(0, n));
		books = page.getContent();
		return books;
	}

	public List<Books> browseByGenre(String genre) {
		List<Books> books = new ArrayList<>();
		booksRepository.findByGenreIs(genre).forEach(books::add);
		return books;
	}

	public List<Books> browseByRating(Double rating) {
		List<Books> books = new ArrayList<>();
		booksRepository.findByAverageRatingGreaterThan(rating).forEach(books::add);
		return books;
	}

	public List<Books> browseByBookCode(int bookCode) {
		List<Books> books = new ArrayList<>();
		booksRepository.findByBookCodeIs(bookCode).forEach(books::add);
		return books;
	}
	
	/*public List<Books> browseByAuthor(String authorLast) {
		List<Books> books = new ArrayList<>();
		List<Author> author = authorsRepository.findAuthorByAuthor_LastIs(authorLast);
		booksRepository.findByAuthorNumIs(author.get(0).getAuthorNum()).forEach(books::add);
		return books;
	}*/
	
	/*public void addBook(Books b) {
		booksRepository.addBook(b);
	}*/
}
