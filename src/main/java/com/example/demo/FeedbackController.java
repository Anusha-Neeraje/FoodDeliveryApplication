package com.example.demo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FeedbackController {
	
	@Autowired
	FeedbackRepository feedbackRepo;
	
	@RequestMapping(value = "/feedback",method=RequestMethod.POST)
	@CrossOrigin(origins="http://localhost:4200")
	public Feedback createfeedback(@RequestBody Feedback feedback) {
		Feedback feedback1  = new Feedback();
		System.out.print("Controller Called");
		feedback1.setId(feedback.getId());
		feedback1.setRestaurentName(feedback.getRestaurentName());
		feedback1.setUserName(feedback.getUserName());
		feedback1.setRating(feedback.getRating());
		feedback1.setFeedback(feedback.getFeedback());
		feedbackRepo.save(feedback1);
		return feedback1;
		
	}
}
