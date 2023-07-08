package com.codeconnect.model;

import java.time.LocalDate;
import java.util.Date;

public class ErrorDetails {
	
	private LocalDate ld;
	private String message;
	private String details;
	public ErrorDetails() {
		
	}
	
	public ErrorDetails(LocalDate ld, String message, String details) {
		super();
		this.ld = ld;
		this.message = message;
		this.details = details;
	}

	

	public ErrorDetails(Date date, String string, String string2) {
		// TODO Auto-generated constructor stub
	}

	public LocalDate getLd() {
		return ld;
	}
	public void setLd(LocalDate ld) {
		this.ld = ld;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getDetails() {
		return details;
	}
	public void setDetails(String details) {
		this.details = details;
	}
	@Override
	public String toString() {
		return "ErrorDetails [ld=" + ld + ", message=" + message + ", details=" + details + "]";
	}
	
	

}
