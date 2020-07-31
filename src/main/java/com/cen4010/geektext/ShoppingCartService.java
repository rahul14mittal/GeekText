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
	@Autowired
	private BooksRepository booksRepository;

	public void addItem(CartItem item) {
		shoppingCartRepository.insertItem(item.getUserId(), item.getBookCode());
	}
		
	public void removeItem(CartItem item) {
		shoppingCartRepository.delete(item);
	}
	
	public List<Books> listItems(int userId) {
		List<CartItem> shoppingCartBookCodes = new ArrayList<>();
		List<Books> shoppingCart = new ArrayList<>();
		
		shoppingCartRepository.findByUserIdIs(userId).forEach(shoppingCartBookCodes::add);
		
		for (int i = 0; i < shoppingCartBookCodes.size(); i++) {
			booksRepository.findByBookCodeIs(shoppingCartBookCodes.get(i).getBookCode()).forEach(shoppingCart::add);
		}
		
		return shoppingCart; 
	}
}
