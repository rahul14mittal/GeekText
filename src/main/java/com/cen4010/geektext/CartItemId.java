package com.cen4010.geektext;

import java.io.Serializable;

public class CartItemId implements Serializable {
	private Integer userId;
	
	private Integer bookCode;
	
	public CartItemId() {}
	
	public CartItemId(Integer userId, Integer bookCode) {
		this.userId = userId;
		this.bookCode = bookCode;
	}
}
