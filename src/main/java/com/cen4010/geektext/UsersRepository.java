package com.cen4010.geektext;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UsersRepository extends JpaRepository<Users, Integer> {

List<Users> findUserByUserNameIs(String userName); 
	
	@Transactional
	@Query(value = "INSERT INTO users (user_id, user_name, user_pass, user_card)"
			+ "VALUES (:user_id, :user_name, :user_pass, :user_card)", nativeQuery = true)
	@Modifying
	void insertUser(@Param("user_id") Integer userId, @Param("user_name") String userName, 
			@Param("user_pass") String userPass, @Param("user_card") String userCard);
}
