package com.example.demo;

import javax.persistence.*;

@Entity
@Table(name="restaurent")
public class Restaurent {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(nullable=false, length=20)
	private String restaurentName;
	
	@Column(nullable=false, length=512)
	private String restaurentContact;
	
	@Column(nullable=false, length=512)
	private String restaurentAddress;
	

	@Column(nullable=false)
	private String restaurentRating;
	
	@Column(nullable=false)
	private String restaurentMenu;
	
	
public Restaurent() {
		
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

public String getRestaurentContact() {
	return restaurentContact;
}

public void setRestaurentContact(String restaurentContact) {
	this.restaurentContact = restaurentContact;
}

public String getRestaurentAddress() {
	return restaurentAddress;
}

public void setRestaurentAddress(String restaurentAddress) {
	this.restaurentAddress = restaurentAddress;
}

public String getRestaurentRating() {
	return restaurentRating;
}

public void setRestaurentRating(String restaurentRating) {
	this.restaurentRating = restaurentRating;
}


public String getRestaurentMenu() {
	return restaurentMenu;
}

public void setRestaurentMenu(String restaurentMenu) {
	this.restaurentMenu = restaurentMenu;
}


	

}
