package com.cen4010.geektext;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository<Author, Integer> {

}
