package com.example.Exception;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class MyErrorDetails {

	
	private LocalDateTime timestamp;
	private String messsage;
	private String details;
	public MyErrorDetails() {
		//super();
		// TODO Auto-generated constructor stub
	}
	public LocalDateTime getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}
	public String getMesssage() {
		return messsage;
	}
	public void setMesssage(String messsage) {
		this.messsage = messsage;
	}
	public String getDetails() {
		return details;
	}
	public void setDetails(String details) {
		this.details = details;
	}
	public MyErrorDetails(LocalDateTime timestamp, String messsage, String details) {
		super();
		this.timestamp = timestamp;
		this.messsage = messsage;
		this.details = details;
	}

	
	
	
}

