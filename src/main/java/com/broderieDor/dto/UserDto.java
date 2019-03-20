package com.broderieDor.dto;


public class UserDto {
	
	private long idUser;

	private String lastName;
	
	private String firstName;
	
	private String email;
	
	private String phone;
	
	private String username;
	

	//Constructor
	public UserDto() {
		
	}
	
	public UserDto(String lastName, String firstName, String email, String phone, String username) {
		this.lastName = lastName;
		this.firstName = firstName;
		this.email = email;
		this.phone = phone;
		this.username = username;
	}

	//GETTER - SETTERS
	
	public long getIdUser() {
		return idUser;
	}

	public void setIdUser(long idUser) {
		this.idUser = idUser;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

}
