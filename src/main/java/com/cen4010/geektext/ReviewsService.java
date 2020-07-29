package com.cen4010.geektext;

import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReviewsService {
@Autowired
private ReviewsRepository reviewsRepository;
	public void addReview(Integer reviewID, Integer bookCode, Integer userID, Double rating, String comment, Date datestamp) {
		reviewsRepository.insertReview(reviewID, bookCode, comment, datestamp, rating, userID);
	}

}
