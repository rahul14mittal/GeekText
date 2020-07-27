package com.cen4010.geektext;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Author {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer author_num;
	
	private String author_bio;

	private String author_first;
	
	private String author_last;
	

	public Integer getAuthorNum() {
		return author_num;
	}

	public void setAuthorNum(Integer authorNum) {
		this.author_num = authorNum;
	}

	public String getAuthorLast() {
		return author_last;
	}

	public void setAuthorLast(String authorLast) {
		this.author_last = authorLast;
	}

	public String getAuthorFirst() {
		return author_first;
	}

	public void setAuthorFirst(String authorFirst) {
		this.author_first = authorFirst;
	}

	public String getAuthorBio() {
		return author_bio;
	}

	public void setAuthorBio(String authorBio) {
		this.author_bio = authorBio;
	}

}
