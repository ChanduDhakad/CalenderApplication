package com.masai.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.masai.Entity.UserDTO;
import com.masai.Entity.Event;
import com.masai.Entity.User;
import com.masai.Exception.EventException;
import com.masai.Exception.UserException;
@Service
public interface UserService  {

	
	
	public User registerUser(User user) throws UserException;
	public User loginUser(UserDTO  userdto)throws UserException;
	public User UpdateUser(User user) throws  UserException;
	public List<Event> allEventDetails(String type)throws UserException;
	
	
}
