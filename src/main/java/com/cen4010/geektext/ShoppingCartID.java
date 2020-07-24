package com.cen4010.geektext;

import java.io.Serializable;

import javax.persistence.Id;

public class ShoppingCartID implements Serializable {
	
	private Integer userID;
	
	private Integer bookCode;
	
	public ShoppingCartID(Integer userID, Integer bookCode) {
		this.userID = userID;
		this.bookCode = bookCode;
	}
	
	
}
