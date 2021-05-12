package com.vegetableapp.feedbacktest;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.vegetableapp.entity.Feedback;
import com.vegetableapp.repository.FeedbackRepository;
import com.vegetableapp.service.FeedbackServiceImpl;

@SpringBootTest
public class FeedbackMockito {
	@Mock
	FeedbackRepository FeedRepo;
	@InjectMocks
	FeedbackServiceImpl service;

	@Test
	public void addFeedbackTest() {
		Feedback feed = new Feedback(101, 121, 171, 5, "very good");
		service.addFeedback(feed);
		verify(FeedRepo, times(1)).save(feed);

	}
}
