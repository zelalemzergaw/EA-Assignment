package edu.mum.domain;

import javax.persistence.*;


@Entity(name = "authentication")
public class UserCredentials {

 	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

 	@Column(name="USER",nullable = false)
  	String username;

	@Column(name="PASSWORD",nullable = false)
 	String password;

	@Transient
 	String verifyPassword;

	@Column(name="enabled",nullable = true)
	Boolean enabled;

 	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getVerifyPassword() {
		return verifyPassword;
	}
	public void setVerifyPassword(String verifyPassword) {
		this.verifyPassword = verifyPassword;
	}
	public Boolean getEnabled() {
		return enabled;
	}
	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}
 	
}
