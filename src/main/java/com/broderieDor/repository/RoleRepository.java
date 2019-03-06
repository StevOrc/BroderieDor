package com.broderieDor.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.broderieDor.model.user.Role;
import com.broderieDor.model.user.RoleName;

public interface RoleRepository extends JpaRepository<Role, Long> {
	Optional<Role> findByName(RoleName roleName);
}
