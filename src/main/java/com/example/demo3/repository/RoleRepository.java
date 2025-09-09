package com.example.demo3.repository;

import com.example.demo3.entity.Role;
import com.example.demo3.entity.User;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

    @Query("SELECT r FROM Role r WHERE r.name = 'ROLE_USER'")
    Role findRoleUser();

    Optional<Role> findByName(String name);
}