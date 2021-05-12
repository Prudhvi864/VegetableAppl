package com.vegetableapp.feedbacktest;

import static org.junit.Assert.assertThrows;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.vegetableapp.exception.DuplicateFeedbackIdFoundException;
import com.vegetableapp.exception.InvalidFeedbackFoundException;
import com.vegetableapp.entity.Feedback;
import com.vegetableapp.service.FeedbackService;

@SpringBootTest
public class FeedbackTest {
	@Autowired
	private FeedbackService Feeds;

	@Test
	public void testDuplicateFeedbackIdFoundExceptionShouldThrowDuplicateFeedbackIdFoundException()
			throws DuplicateFeedbackIdFoundException {
		assertThrows(DuplicateFeedbackIdFoundException.class, () -> {
			Feedback feed = new Feedback(101, 121, 171, 5, "very good");
			Feeds.readFeedId(101);
		});
	}

	@Test
	public void testInvalidFeedbackFoundExceptionShouldThrowInvalidFeedbackFoundException()
			throws InvalidFeedbackFoundException {
		assertThrows(InvalidFeedbackFoundException.class, () -> {
			Feedback feed = new Feedback(-24, 111, 131, 6, "very good");
			Feeds.createFeedback(feed);
		});
	}

}