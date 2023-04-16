package com.masai.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.TemporalField;
import java.time.temporal.WeekFields;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.Entity.CurrentSession;
import com.masai.Entity.UserDTO;
import com.masai.Entity.Event;
import com.masai.Entity.User;
import com.masai.Exception.EventException;
import com.masai.Exception.UserException;
import com.masai.Repository.EventRepo;
import com.masai.Repository.SessionRepo;
import com.masai.Repository.UserRepo;

import net.bytebuddy.utility.RandomString;
@Service
public class UserServiceImpl implements UserService {


	@Autowired
	private UserRepo userRepo;
	
	@Autowired 
	private EventRepo eventRepo;
	
	
	@Autowired 
	private SessionRepo sessionRepo;

	@Override
	public User registerUser(User user) throws UserException {
		User u=userRepo.findByEmail(user.getEmail());
		if(u==null) {
		 User nu=userRepo.save(user);
		 return nu;	
		}
		else {
			throw new UserException("User Already Registered with Given Email ID ");
		}
	}

	@Override
	public User loginUser(UserDTO userDTO) throws UserException {
	
		User u=userRepo.findByEmail(userDTO.getEmail());
		
		if(u != null) {
			if(userDTO.getPassword().equals(u.getPassword())) {
			 String key=RandomString.make(6);
			 CurrentSession cu=new CurrentSession(u.getUserId(), key, LocalDateTime.now());
		      
			  sessionRepo.save(cu);  
			 return u;
			}else {
				 
				throw new UserException("Password is Wrong Please Enter Correct Password");
				
			}
			
			
		}
		else {
			throw new UserException("Email Id Is Wrong  Please Enter Correct Email");
		}
		
		
		
		
	}

	
	
	
	
	@Override
	public User UpdateUser(User user) throws UserException {
	
		Optional<User> u=userRepo.findById(user.getUserId());
	 
		
		if(u.isPresent()) {
			User nu=u.get();
			return userRepo.save(nu);
		}
		else {
			throw new UserException("User is not Present with Given Email ID ");
		}
	
	}

	@Override
	public List<Event> allEventDetails(String type) throws UserException {
	
		List<Event> list=eventRepo.findAll();
		List<Event> newList=new ArrayList<>();
		
		if(type.equalsIgnoreCase("month")) {
		
			int monthNumber=LocalDate.now().getMonthValue();
					
				for(Event event:list) {
		
					if(event.getTime_begin().getMonthValue()== monthNumber || event.getTime_end().getMonthValue()== monthNumber) {
						newList.add(event);
					}	
				}
		}
		
		
		if(type.equalsIgnoreCase("week")) {
			
			LocalDate date = LocalDate.now();
			TemporalField woy = WeekFields.of(Locale.getDefault()).weekOfWeekBasedYear(); 
			int weeks = date.get(woy);
			
					
				for(Event event:list) {
		
					LocalDate dateStart = LocalDate.now();
					TemporalField woy1 = WeekFields.of(Locale.getDefault()).weekOfWeekBasedYear(); 
					int weekDateBegin = date.get(woy1);
					
					
					LocalDate dateEnd = LocalDate.now();
					TemporalField woy2 = WeekFields.of(Locale.getDefault()).weekOfWeekBasedYear(); 
					int weekDateend = date.get(woy2);
					
					
					if(weekDateBegin==weeks || weekDateend==weeks) {
						list.add(event);
					}	
				}
		}
		
		
		if(type.equalsIgnoreCase("day")) {
			
			int DayNumber =( LocalDate.now().getDayOfMonth());
					
				for(Event event:list) {
		
					if(event.getTime_begin().getDayOfMonth()== DayNumber || event.getTime_end().getMonthValue()== DayNumber) {
						newList.add(event);
					}	
				}
		}
		

		return newList;
		
	}

	
	
	
	

}
