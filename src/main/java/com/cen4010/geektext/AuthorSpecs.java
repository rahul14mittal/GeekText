package com.cen4010.geektext;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

public class AuthorSpecs {

	private AuthorRepository authorRepository;
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
