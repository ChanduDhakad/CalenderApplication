package com.masai.Service;

import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.Entity.UserDTO;
import com.masai.Entity.Event;
import com.masai.Entity.User;
import com.masai.Exception.EventException;
import com.masai.Exception.UserException;
import com.masai.Repository.EventRepo;
import com.masai.Repository.UserRepo;

@Service
public class EventServiceImpl implements EventService{


	@Autowired
	private UserRepo userRepo;
	
	@Autowired 
	private EventRepo eventRepo;

	@Override
	public Event craeteEvent(Event event, Integer UserId) throws EventException,UserException {
		// TODO Auto-generated method stub
		
		Optional<User> opt=userRepo.findById(UserId);
		
		if(opt.isPresent()) {
          
			User user=opt.get();
			
		long timeDiff=ChronoUnit.DAYS.between(event.getTime_begin(),event.getTime_end());

		 if(timeDiff>=1) {
			 event.setEventType("Recurring Event");
		 }
		 else {
			 event.setEventType("Non-Recurring Event");
		
		 }
		
		  user.getEvents().add(event);
		  event.setUser(user);
		  
		  userRepo.save(user);      
		return eventRepo.save(event);
	
		 
		}
		else {
				
			throw new UserException("User Not Found By Given Id");
			
		}
	
	}

	@Override
	public Event updateEvent(Event event, Integer UserId) throws EventException ,UserException{
		Optional<User> opt=userRepo.findById(UserId);
		
		if(opt.isPresent()) {
          
			User user=opt.get();
			
			Optional<Event> optEvent=eventRepo.findById(event.getEvantId());
			if(optEvent.isPresent()) {
			
								long datediff=ChronoUnit.DAYS.between(event.getTime_begin(),event.getTime_end());
						
								 if(datediff>=1) {
									 event.setEventType("Recurring Event");
								 }
								 else {
									 event.setEventType("Non-Recurring Event");
								
								 }
								
								 
								  event.setUser(user);
								return eventRepo.save(event);
							
		 
								
			}
			else {
				
				throw new EventException("Event Not Exist wit given  Id");
			}
		}
		else {
				
			throw new UserException("User Not Exist With Given Id");
			
		}
	
	}

	@Override
	public Event deleteEvent(int eventId, Integer userId) throws EventException ,UserException{
	Optional<User> opt=userRepo.findById(userId);
		
		if(opt.isPresent()) {
          
			User user=opt.get();
			
			Optional<Event>Eventopt=eventRepo.findById(eventId);
			if(Eventopt.isPresent()) {
                   
				Event event=Eventopt.get();
				List<Event>  events=user.getEvents();
				
				List<Event> list=new ArrayList<>();
				
				
				
				for(Event event2:events) {
					if(event2.getEvantId()!=eventId) {
						list.add(event2);
					}
				}
				
				user.setEvents(list);
				
				userRepo.save(user);
				eventRepo.delete(event);
				
				return event;	
			}
			else {
				
				throw new EventException("Event Not Found By Given Id");
			}
		}
		else {
				
			throw new UserException("User Not Found By Given Id");
			
		}
		
	
	}



	
	
}
