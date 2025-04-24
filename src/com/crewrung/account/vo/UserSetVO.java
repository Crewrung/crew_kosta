package com.crewrung.account.vo;

public class UserSetVO {
	
    private String password; 
    private String email; 
    private String phoneNumber;  
    private String nickname;   
    private String location;
    
    
	public UserSetVO(){}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPhoneNumber() {
		return phoneNumber;
	}


	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}


	public String getNickname() {
		return nickname;
	}


	public void setNickname(String nickname) {
		this.nickname = nickname;
	}


	public String getLocation() {
		return location;
	}


	public void setLocation(String location) {
		this.location = location;
	}


	@Override
	public String toString() {
		return "UserUpdateVO [password=" + password + ", email=" + email + ", phoneNumber=" + phoneNumber
				+ ", nickname=" + nickname + ", location=" + location + "]";
	}  
	
	
    
    
    

}
