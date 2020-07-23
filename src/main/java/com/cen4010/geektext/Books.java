package com.cen4010.geektext;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Books {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer bookCode;

	private Integer authorNum;

	private String title;

	private String publisherCode;

	private Double price;

	private String genre;

	private Date yearPub;

	private Integer copiesSold;

	private String bookDescription;

	private Double averageRating;

	public Integer getBookCode() {
		return bookCode;
	}

	public void setBookCode(Integer bookCode) {
		this.bookCode = bookCode;
	}

	public Integer getAuthorNum() {
		return authorNum;
	}

	public void setAuthorNum(Integer authorNum) {
		this.authorNum = authorNum;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getPublisherCode() {
		return publisherCode;
	}

	public void setPublisherCode(String publisherCode) {
		this.publisherCode = publisherCode;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public Date getYearPub() {
		return yearPub;
	}

	public void setYearPub(Date yearPub) {
		this.yearPub = yearPub;
	}

	public Integer getCopiesSold() {
		return copiesSold;
	}

	public void setCopiesSold(Integer copiesSold) {
		this.copiesSold = copiesSold;
	}

	public String getBookDescription() {
		return bookDescription;
	}

	public void setBookDescription(String bookDescription) {
		this.bookDescription = bookDescription;
	}

	public Double getAverageRating() {
		return averageRating;
	}

	public void setAverageRating(Double averageRating) {
		this.averageRating = averageRating;
	}

}
