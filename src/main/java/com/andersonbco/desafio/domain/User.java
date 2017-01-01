package com.andersonbco.desafio.domain;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class User {

	@Id
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name="system-uuid", strategy = "uuid")
	private String id;
	
	private String name;
	
	private String email;
	
	private String password;
	
	@OneToMany(mappedBy="user")
	private List<Phone> phones;
	
	@JsonFormat(pattern="dd-MM-yyyy")
	@DateTimeFormat(iso = DateTimeFormat.ISO.TIME)
	private LocalDateTime created;
	
	@JsonFormat(pattern="dd-MM-yyyy")
	@DateTimeFormat(iso = DateTimeFormat.ISO.TIME)
	private LocalDateTime modified;
	
	@JsonFormat(pattern="dd-MM-yyyy")
	@DateTimeFormat(iso = DateTimeFormat.ISO.TIME)
	private LocalDateTime last_login;
	
	private String token;
	
	public User() {
	}
	
	public User(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Phone> getPhones() {
		return phones;
	}

	public void setPhones(List<Phone> phones) {
		this.phones = phones;
	}

	public LocalDateTime getCreated() {
		return created;
	}

	public void setCreated(LocalDateTime created) {
		this.created = created;
	}

	public LocalDateTime getModified() {
		return modified;
	}

	public void setModified(LocalDateTime modified) {
		this.modified = modified;
	}

	public LocalDateTime getLast_login() {
		return last_login;
	}

	public void setLast_login(LocalDateTime last_login) {
		this.last_login = last_login;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}
	
}
