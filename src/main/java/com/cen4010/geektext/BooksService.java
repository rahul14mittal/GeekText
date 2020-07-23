package com.cen4010.geektext;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BooksService {

	@Autowired
	private BooksRepository booksRepository;

	public List<Books> getAllBooks() {
		List<Books> books = new ArrayList<>();
		booksRepository.findAll().forEach(books::add);
		return books;
	}

	public List<Books> getTopSellers() {
		List<Books> books = new ArrayList<>();
		booksRepository.findAll().forEach(books::add);
		return books;
	}

//	public List<Books> browseByGenre(String gen)
//	{
//		List<Books> books = new ArrayList<>();
//		booksRepository.findByGenre(gen).forEach(books::add);
//		return books;
//	}

}
