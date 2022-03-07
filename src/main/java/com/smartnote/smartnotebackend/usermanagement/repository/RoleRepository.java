package com.smartnote.smartnotebackend.usermanagement.repository;

import java.util.Optional;

import com.smartnote.smartnotebackend.usermanagement.entity.ERole;
import com.smartnote.smartnotebackend.usermanagement.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(ERole name);
}