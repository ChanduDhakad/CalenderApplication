package com.masai.Controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.masai.Entity.UserDTO;
import com.masai.Entity.Event;
import com.masai.Entity.User;
import com.masai.Exception.EventException;
import com.masai.Exception.UserException;
import com.masai.Service.EventService;
import com.masai.Service.UserService;

@RestController
@RequestMapping("/masaicalender")
public class MasaicalenderController {

	
	@Autowired
	private UserService us;
	
	@Autowired 
	private EventService es;
	
	

      @PostMapping("/register")
	public ResponseEntity<User> registeredUser(@Valid @RequestBody User user) throws UserException {
    	  User usr=us.registerUser(user);
    	  return new ResponseEntity<User>(usr,HttpStatus.CREATED);
	}

	
     @PostMapping("/login")
	public ResponseEntity<User> loginUser(@RequestBody UserDTO userdto) throws UserException {
    		User user = us.loginUser(userdto); 			
    		return new ResponseEntity<User>(user , HttpStatus.ACCEPTED);
    			
	}

	@PutMapping("/user")
	public  ResponseEntity<User>  UpdateUser(@Valid @RequestBody User user) throws UserException {
		
		  User use=us.UpdateUser(user);
    	  return new ResponseEntity<User>(use ,HttpStatus.OK);
	}

	@GetMapping("/event/{type}")
	public ResponseEntity<List<Event>> eventDetails(@PathVariable("type") String type) throws UserException {
          	List<Event> list=us.allEventDetails(type);
          	return new ResponseEntity<List<Event>>(list,HttpStatus.OK);
          	       
	}
	
	
	@PostMapping("/event/{UserId}")
	public ResponseEntity<Event> craeteEvent(@RequestBody Event event,@PathVariable("UserId") Integer userId) throws EventException,UserException {
		  Event events=es.craeteEvent(event, userId);
    	  return new ResponseEntity<Event>(events,HttpStatus.CREATED);
	}

	@PutMapping("/event/{UserId}")
	public  ResponseEntity<Event>  updateEvent(@RequestBody Event event,@PathVariable("UserId") Integer userId) throws EventException ,UserException{
		  Event events=es.updateEvent(event, userId);
    	  return new ResponseEntity<Event>(events,HttpStatus.OK);
	}
	
	@DeleteMapping("/event/{EventId}/{UserId}")
	public ResponseEntity<Event> deleteEvent(@PathVariable("EventId")Integer eventId ,@PathVariable("UserId") Integer userId) throws EventException,UserException {
		  Event events=es.deleteEvent(eventId, userId);
    	  return new ResponseEntity<Event>(events,HttpStatus.OK);
	}
	

}
