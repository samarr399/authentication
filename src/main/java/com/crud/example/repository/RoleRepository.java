package com.crud.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crud.example.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Integer> {
	public Role findByRole(String role);
}
