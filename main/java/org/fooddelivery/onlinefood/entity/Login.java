package org.fooddelivery.onlinefood.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.*;

@Entity
@Table(name="login")
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode

public class Login {
	
	// define fields
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="userid")
	private int userid;
	
	@Column(name="userName")
	private String userName;
	
	@Column(name="password")
	private String password;

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
