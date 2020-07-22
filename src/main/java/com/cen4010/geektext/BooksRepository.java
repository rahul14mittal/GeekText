package com.cen4010.geektext;

import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.data.repository.CrudRepository;

public interface BooksRepository extends CrudRepository<User, Integer> {

}
