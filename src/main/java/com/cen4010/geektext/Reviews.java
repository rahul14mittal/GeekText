package com.cen4010.geektext;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class Reviews {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer reviewID;
	private Integer bookCode;
	private Integer userID;
	private Double rating;
	private String comment;
	private Date datestamp;
	
	public Double getRating() {
		return rating;
	}
	public void setRating(Double rating) {
		this.rating = rating;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public Date getDatestamp() {
		return datestamp;
	}
	public void setDatestamp(Date datestamp) {
		this.datestamp = datestamp;
	}
	public Integer getBookCode() {
		return bookCode;
	}
	public void setBookCode(Integer bookCode) {
		this.bookCode = bookCode;
	}
	public Integer getUserID() {
		return userID;
	}
	public void setUserID(Integer userID){ 
		this.userID = userID;
	}
	
}
