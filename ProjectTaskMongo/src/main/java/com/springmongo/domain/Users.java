package com.springmongo.domain;

//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.Table;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;



@Document(collection="Users")
//@({"hibernateLazyInitializer","handler"}) 
public class Users {
	@Id
	//@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long userId;
	private String userName;
	
	public Users() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Users(Long userId, String userName) {
		super();
		this.userId = userId;
		this.userName = userName;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	

}
