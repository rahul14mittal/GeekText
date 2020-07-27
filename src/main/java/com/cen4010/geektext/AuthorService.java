package com.cen4010.geektext;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthorService {

	@Autowired
	private AuthorRepository authorRepository;

	public List<Author> getAllAuthors() {
		List<Author> authors = new ArrayList<>();
		authorRepository.findAll().forEach(authors::add);
		return authors;
	}

	public void addAuthor(Integer author_num, String author_bio , String author_first, String author_last) {
		authorRepository.insertAuthor(author_num, author_bio, author_first, author_last);
	}
}
