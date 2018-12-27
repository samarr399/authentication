package com.crud.example.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import com.crud.example.Debug;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Size(min = 2)
	private String name;
	@Size(max = 5)
	private String school;

	@Past
	private Date dob;

	private String password;

	@Column(name = "active")
	private int active;
	@ManyToMany
	@JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
	private List<Role> roles = new ArrayList<>();

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public User(User user) {
		this.name = user.getName();
		this.school = user.getSchool();
		this.dob = user.getDob();
		this.password = user.getPassword();
		this.active = user.getActive();
		this.roles = user.getRoles();
	}

	public User(@Size(min = 2) String name, @Size(max = 5) String school, @Past Date dob, String password, int active,
			List<Role> roles) {
		super();
		this.name = name;
		this.school = school;
		this.dob = dob;
		this.password = password;
		this.active = active;
		this.roles = roles;
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

	public String getSchool() {
		return school;
	}

	public void setSchool(String school) {
		this.school = school;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getActive() {
		return active;
	}

	public void setActive(int active) {
		this.active = active;
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void addRole(Role role) {
		this.roles.add(role);
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", school=" + school + ", dob=" + dob + ", password=" + password
				+ ", active=" + active + ", roles=" + roles + "]";
	}

}
