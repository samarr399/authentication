package com.crud.example.entity;

import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "role")
public class Role {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private int id;
	@Column(name = "role")
	private String role;
	/*@ManyToMany(mappedBy = "roles",fetch=FetchType.LAZY)
	private List<User> users;*/

	public Role() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Role(String role, List<User> users) {
		super();
		this.role = role;
//		this.users = users;
	}
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	/*public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}*/

	@Override
	public String toString() {
		return "Role [id=" + id + ", role=" + role + /*", users=" + users + */"]";
	}

}
