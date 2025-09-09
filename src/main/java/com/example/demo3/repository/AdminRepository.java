package com.example.demo3.repository;

import com.example.demo3.entity.Admin;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Long> {

    @EntityGraph(attributePaths = "roles")
    Optional<Admin> findAdminByName(String name);
}
