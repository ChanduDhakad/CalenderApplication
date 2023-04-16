package com.masai.Entity;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Event {

	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
 	private Integer evantId;
	 
  	private String title;

  	private String description;
	
  	private LocalDate time_begin;
	
	private LocalDate time_end;
	
	@JsonIgnore
	private String eventType;
	
	@ManyToOne()
	private User user;

}
