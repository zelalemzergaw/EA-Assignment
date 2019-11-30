package edu.mum.domain;


import javax.persistence.*;

@Entity(name = "authority")
public class Authority {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name ="id",nullable = false)
 	private long id;

	@Column(name ="Username",nullable = true)
	private String username;

	@Column(name ="authority",nullable = false)
 	private String authority;
 	
	 public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getAuthority() {
		return authority;
	}
	public void setAuthority(String authority) {
		this.authority = authority;
	}
 
 	
}
