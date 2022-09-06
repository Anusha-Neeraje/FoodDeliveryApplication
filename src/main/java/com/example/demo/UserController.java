package com.example.demo;

import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
	
	@Autowired
	UserRepository userRepo;
	
	Random random = new Random(1000);
	
	@Autowired
	private EmailService eservice;
	
	
	@RequestMapping(value = "/user",method=RequestMethod.POST)
	@CrossOrigin(origins="http://localhost:4200")
	public User createuser(@RequestBody User usr){
		User usr1  = new User();
		System.out.print("Controller Called");
		usr1.setId(usr.getId());
		usr1.setName(usr.getName());
		usr1.setEmail(usr.getEmail());
		usr1.setPassword(usr.getPassword());
		usr1.setCpassword(usr.getCpassword());
		userRepo.save(usr1);
		return usr1;
		
	}
	
	@RequestMapping(value = "/login",method=RequestMethod.POST)
	@CrossOrigin(origins="http://localhost:4200")
	public Optional<User> loginUser(@RequestBody User user) throws Exception {
		String tempEmail = user.getEmail();
		String tempPassword = user.getPassword();
		 Optional<User> rest1 = null;
		if(tempEmail!=null && tempPassword!=null) {
			 rest1 = userRepo.findByEmailAndPassword(user.getEmail(),user.getPassword());
		}
		if(rest1 == null) {
			throw new Exception("Bad Credentials");
		}
		return rest1;
	}
	

	@RequestMapping(value = "/forgotPass",method=RequestMethod.POST)
	@CrossOrigin(origins="http://localhost:4200")
	public String sendOTP(@RequestBody User user) {
		String email = user.getEmail();
		int otp = random.nextInt(99999);
		System.out.print(otp);
		System.out.print(email);
		String subject = "OTP From FDA";
		String message = "<h1>OTP = "+otp+"</h1>";
		String to=email;
		boolean flag = this.eservice.sendEmail(subject, message, to);
		if(flag) {
			return "ChangePassword";
		}
		else {
			return "Check your email id";
		}
		
	}
	
	@RequestMapping(value = "/updatePassword",method=RequestMethod.PUT)
	@CrossOrigin(origins="http://localhost:4200")
	public User updatePassword(@RequestBody User user) {
			System.out.println("the user password:"+user.getPassword());
		   //Optional<Restaurent> rest1  = Optional.ofNullable(restaurentRepo.findById(restaurent.getRestaurentId()).orElse(null));
		   Optional<User> user1 = userRepo.findById(user.getId());
			if(user1!=null) {
			  User  newrest= new User();
			  System.out.print("In update method");
			  newrest.setId(user.getId());
			  newrest.setEmail(user.getEmail());
			  newrest.setPassword(user.getPassword());
			  newrest.setCpassword(user.getCpassword());
		      userRepo.save(newrest);
		      return newrest;
		   }
		   else {
			   return null;
		   }
	}

}
