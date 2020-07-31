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
@Autowired
private BooksRepository booksRepository;
	public void addReview(Integer reviewID, Integer bookCode, Integer userID, Double rating, String comment, Date datestamp) {
		reviewsRepository.insertReview(reviewID, bookCode, comment, datestamp, rating, userID);
		this.updateAvgRating(bookCode, this.findAvg(bookCode));
	}
	
	public void updateAvgRating(Integer bookCode, Double rating) {
		Books books = booksRepository.getOne(bookCode);
		books.setAverageRating(rating);
		booksRepository.save(books);
		
	}
	
	public Double findAvg(Integer bookCode) {
		return reviewsRepository.pullAvg(bookCode).get(0);
	}
	
	public List<Reviews> getAllReviews() {
		List<Reviews> reviews = new ArrayList<>();
		reviewsRepository.findByOrderByRatingDesc().forEach(reviews::add);
		
		
		return reviews;
	}
	
}
