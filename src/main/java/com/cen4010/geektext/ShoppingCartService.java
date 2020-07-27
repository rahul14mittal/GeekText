package com.cen4010.geektext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.ArrayList;
import java.util.List;

@Service
@RestController
public class ShoppingCartService {

	@Autowired
	private ShoppingCartRepository shoppingCartRepository;

	public void addItem(CartItem item) {
		shoppingCartRepository.insertItem(item.getUserId(), item.getBookCode());
	}
		
	public void removeItem(CartItem item) {
		shoppingCartRepository.delete(item);
	}
	
	public List<CartItem> listItems(int userId) {
		List<CartItem> shoppingCart = new ArrayList<>();
		shoppingCartRepository.findByUserIdIs(userId).forEach(shoppingCart::add);
		return shoppingCart; 
	}
}
