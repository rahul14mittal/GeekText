package com.cen4010.geektext;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

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
		booksRepository.findAll().forEach(books::add);
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
	
	public List<Books> browseByAuthor(String author_last) {
		List<Books> books = new ArrayList<>();
		List<Author> author = authorsRepository.findAuthorByAuthorLastIs(author_last);
		booksRepository.findByAuthorNumIs(author.get(0).getAuthorNum()).forEach(books::add);
		return books;
	}
	
	public void addBook(Integer bookCode, Integer authorNum, String title, String publisherCode, 
			Double price, String genre, Date yearPub, Integer copiesSold, String bookDescription, Double averageRating) {
		booksRepository.insertBook(bookCode, authorNum, title, publisherCode, price, genre, yearPub, 
				copiesSold, bookDescription, averageRating);
	}
}
