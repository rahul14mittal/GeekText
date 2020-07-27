package com.cen4010.geektext;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;


@Entity
@IdClass(CartItemId.class)
public class CartItem {
	
	@Id
	private Integer userId;	
	@Id
	private Integer bookCode;	

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getBookCode() {
		return bookCode;
	}

	public void setBookCode(Integer bookCode) {	
		this.bookCode = bookCode;
	}
}