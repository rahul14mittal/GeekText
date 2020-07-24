package com.cen4010.geektext;

import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;

@Entity
@IdClass (ShoppingCartID.class)
public class ShoppingCart {
		
	@Id
	private Integer userID;
	
	@Id
	private Integer bookCode; 
	
	private Integer quantity;
	
	public Integer getUserID() {
		return userID;
	}

	public void setUserID(Integer userID) {
		this.userID = userID;
	}

	public Integer getBookCode() {
		return bookCode;
	}

	public void setBookCode(Integer bookCode) {
		this.bookCode = bookCode;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	
}
