package com.thisdatascience.portal.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.thisdatascience.portal.model.UserModel;

public interface UserRepository extends JpaRepository<UserModel, UUID> {
	Optional<UserModel> findByEmail(String email);
}
