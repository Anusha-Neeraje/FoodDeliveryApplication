package com.example.demo;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class FeedbackTest {
	
	@Autowired
	private FeedbackRepository feedbackRepo;
	
	@Test
	public void testCreateFeedback() {
		Feedback feedback1 = new Feedback();
		feedback1.setRestaurentName("Disha");
		feedback1.setUserName("Anu");
		feedback1.setRating(4);
		feedback1.setFeedback("Good");
		feedbackRepo.save(feedback1);
		Assertions.assertThat(feedback1.getId()).isGreaterThan(0);
	}
	
	@Test
	public void testNCreateFeedback() {
		Feedback feedback1 = new Feedback();
		feedback1.setRestaurentName("Disha");
		feedback1.setUserName("AnuAnuAnuAnu");
		feedback1.setRating(4);
		feedback1.setFeedback("Good");
		feedbackRepo.save(feedback1);
		Assertions.assertThat(feedback1.getUserName()).hasSizeLessThan(10);
	}

}
