package edu.mum.domain;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;
import javax.transaction.Transactional;

@Entity(name = "Users")
  public class User implements Serializable  {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable = false, length = 20)
	private Long id = null;


	@Column(name = "FIRSTNAME",nullable = false)
     private String firstName;

	@Column(name = "LASTNAME",nullable = false)
     private String lastName;

	@Column(name = "EMAIL",nullable = false)
     private String email;

	@Column(name = "RATING",nullable = false,length = 11)
     private int rating = 0;

	@Column(name = "IS_ADMIN",nullable = false)
     private boolean admin = false;
     
     @Version
	 @Column(name = "version",nullable = false,length = 11)
     private int version = 0;

     @Temporal(TemporalType.DATE)
	 @Column(name = "last_login",nullable = true)
     private Date lastLogin;
     
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstname) {
		this.firstName = firstname;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastname) {
		this.lastName = lastname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public boolean isAdmin() {
		return admin;
	}

	public void setAdmin(boolean admin) {
		this.admin = admin;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public Date getLastLogin() {
		return lastLogin;
	}

	public void setLastLogin(Date lastLogin) {
		this.lastLogin = lastLogin;
	}

}