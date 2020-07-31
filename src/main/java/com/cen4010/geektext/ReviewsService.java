package com.cen4010.geektext;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class ReviewsService {
@Autowired
private ReviewsRepository reviewsRepository;
private Books books;
	public void addReview(Integer reviewID, Integer bookCode, Integer userID, Double rating, String comment, Date datestamp) {
		reviewsRepository.insertReview(reviewID, bookCode, comment, datestamp, rating, userID);
		//books.setAverageRating(reviewsRepository.pullAvg(bookCode));
	}
	
	public void findAvg(Integer bookCode) {
		reviewsRepository.pullAvg(bookCode);
	}
	
	public List<Reviews> getAllReviews() {
		List<Reviews> reviews = new ArrayList<>();
		reviewsRepository.findByOrderByRatingDesc().forEach(reviews::add);
		
		
		return reviews;
	}
	
}
