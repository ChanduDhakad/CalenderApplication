package com.masai.Entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CurrentSession {

	@Id
	@Column(unique = true)
	private Integer id;
	
	private String uuid;
	
	private LocalDateTime timeStamp;
}
