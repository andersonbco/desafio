package com.andersonbco.desafio.domain;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
public class User {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	
	private String email;
	
	private String password;
	
	@OneToMany(mappedBy="user")
	private List<Phone> phones;
	
	private LocalDateTime created;
	
	private LocalDateTime modified;
	
	private LocalDateTime last_login;
	
	private UUID token;
	
	public User() {
	}
	
	public User(String name) {
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
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

	public UUID getToken() {
		return token;
	}

	public void setToken(UUID token) {
		this.token = token;
	}
	
	
}
