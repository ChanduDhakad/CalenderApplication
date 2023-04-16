package com.masai.Service;

import java.util.List;

import com.masai.Entity.UserDTO;
import com.masai.Entity.Event;
import com.masai.Entity.User;
import com.masai.Exception.EventException;
import com.masai.Exception.UserException;

public interface EventService {

	
	
	public Event craeteEvent(Event event,Integer UserId) throws EventException,UserException;
	public Event updateEvent(Event event,Integer UserId)throws EventException,UserException;
	public Event deleteEvent(int eventId,Integer userId) throws EventException,UserException;
	
}
