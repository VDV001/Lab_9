package com.boots.repository;


import com.boots.entity.TablesUserRole.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
}
