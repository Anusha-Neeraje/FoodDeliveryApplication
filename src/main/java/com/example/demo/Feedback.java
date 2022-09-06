package com.example.demo;

import javax.persistence.*;

@Entity
@Table(name="feedback")
public class Feedback {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(nullable=false, length=20)
	private String restaurentName;
	
	@Column(nullable=false, length=10)
	private String userName;
	
	@Column(nullable=false)
	private Integer rating;
	
	private String feedback;

	public Feedback() {
		
	}

	public Integer getId() {
		return id;
	}



	public void setId(Integer id) {
		this.id = id;
	}



	public String getRestaurentName() {
		return restaurentName;
	}

	public void setRestaurentName(String restaurentName) {
		this.restaurentName = restaurentName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Integer getRating() {
		return rating;
	}

	public void setRating(Integer rating) {
		this.rating = rating;
	}

	public String getFeedback() {
		return feedback;
	}

	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}
	
	

}
