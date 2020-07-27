package com.cen4010.geektext;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ShoppingCartRepository extends JpaRepository<CartItem, Integer>{
	@Transactional
	@Query(
			value = "INSERT INTO cart_item (user_id, book_code) values (:userId, :bookCode)", nativeQuery = true)
			@Modifying void insertItem(@Param("userId") Integer userId, @Param("bookCode") Integer bookCode);
	
	@Transactional
	@Query(
			value = "INSERT INTO cart_item (user_id, book_code) values (:userId, :bookCode)", nativeQuery = true)
			@Modifying void removeItem(@Param("userId") Integer userId, @Param("bookCode") Integer bookCode);
	
	List<CartItem> findByUserIdIs(Integer userId);
}
