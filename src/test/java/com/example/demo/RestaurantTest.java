package com.example.demo;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.util.*;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class RestaurantTest {
	
	@Autowired
	private RestaurentRepository restaurentRepo;
	
	@Test
	@Order(1)
	@Rollback(value=false)
	public void testCreateRestaurent() {
		Restaurent rest1 = new Restaurent();
		rest1.setRestaurentName("Disha");
		rest1.setRestaurentAddress("Ujire");
		rest1.setRestaurentContact("anu12@gmail.com");
		rest1.setRestaurentRating("4");
		//rest1.setRestaurentMenu("Lunch");
		restaurentRepo.save(rest1);
		System.out.print("Resttaurent Id Is:"+rest1.getId()+"\n");
		Assertions.assertThat(rest1.getId()).isGreaterThan(0);
	}
	
	@Test
	@Order(2)
	public void getRestaurant() {
		Restaurent restaurent= restaurentRepo.findById(18).get();
		Assertions.assertThat(restaurent.getId()).isEqualTo(18);
	}
	
	@Test
	@Order(3)
	public void getListRestaurant() {
		List<Restaurent> restaurents=restaurentRepo.findAll();
		Assertions.assertThat(restaurents.size()).isGreaterThan(0);
	}
	
	@Test
	@Order(4)
	@Rollback(value=false)
	public void updateRestaurant() {
		Restaurent restaurent= restaurentRepo.findById(18).get();
		restaurent.setRestaurentName("Disha");
		restaurent.setRestaurentContact("disha12@gmail.com");
		restaurent.setRestaurentAddress("Ujire");
		restaurent.setRestaurentRating("5");
		restaurent.setRestaurentMenu("Buffet");
		Restaurent rest=restaurentRepo.save(restaurent);
		Assertions.assertThat(rest.getRestaurentRating()).isEqualTo("5");
	}
	
	@Test
	@Order(5)
	@Rollback(value=false)
	public void deleteRestaurant() {
		Restaurent restaurant = restaurentRepo.findById(18).get();
		restaurentRepo.delete(restaurant);
		
		Optional<Restaurent> optional= restaurentRepo.findById(18);
		if(optional.isPresent()) {
			Restaurent rest1=optional.get();		
			}
		Assertions.assertThat(optional.isEmpty());
	}
	
}
