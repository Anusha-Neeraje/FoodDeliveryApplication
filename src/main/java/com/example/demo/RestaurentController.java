package com.example.demo;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.Optional;

import javax.persistence.criteria.Path;

import org.apache.tomcat.jni.File;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class RestaurentController {
	
	@Autowired
	RestaurentRepository restaurentRepo;
	
	@RequestMapping(value = "/restaurent",method=RequestMethod.POST)
	@CrossOrigin(origins="http://localhost:4200")
	public Restaurent addrestaurent(@RequestBody Restaurent restaurent){
		Restaurent restaurent1  = new Restaurent();
		//restaurent1.setId(restaurent.getId());
		restaurent1.setRestaurentName(restaurent.getRestaurentName());
		restaurent1.setRestaurentContact(restaurent.getRestaurentContact());
		restaurent1.setRestaurentAddress(restaurent.getRestaurentAddress());
		restaurent1.setRestaurentRating(restaurent.getRestaurentRating());
		restaurent1.setRestaurentMenu(restaurent.getRestaurentMenu());
		restaurentRepo.save(restaurent1);
		return restaurent1;
		
	}
	
	@RequestMapping(value = "/all",method=RequestMethod.GET)
	@CrossOrigin(origins="http://localhost:4200")
	public List<Restaurent> getRestaurent() {
		return restaurentRepo.findAll();
		
	}
	
	@RequestMapping(value = "/update",method=RequestMethod.PUT)
	@CrossOrigin(origins="http://localhost:4200")
	public Restaurent updaterestaurent(@RequestBody Restaurent restaurent) {
			System.out.println("the restaurant id"+restaurent.getId());
		   //Optional<Restaurent> rest1  = Optional.ofNullable(restaurentRepo.findById(restaurent.getRestaurentId()).orElse(null));
		   Optional<Restaurent> rest1 = restaurentRepo.findById(restaurent.getId());
			if(rest1!=null) {
			  Restaurent  newrest= new Restaurent();
			  System.out.print("In update method");
			  newrest.setId(restaurent.getId());
			  newrest.setRestaurentName(restaurent.getRestaurentName());
			  newrest.setRestaurentContact(restaurent.getRestaurentContact());
			  newrest.setRestaurentAddress(restaurent.getRestaurentAddress());
			  newrest.setRestaurentRating(restaurent.getRestaurentRating());
			  newrest.setRestaurentMenu(restaurent.getRestaurentMenu());
		      restaurentRepo.save(newrest);
		      return newrest;
		   }
		   else {
			   return null;
		   }
	}
	
	@DeleteMapping(value = "/delete/{id}")
	@CrossOrigin(origins="http://localhost:4200")
	public void deleteRestaurent(@PathVariable(value="id") Integer Id) {
		System.out.print("In delete method");
		restaurentRepo.deleteById(Id);
		
	}

}
