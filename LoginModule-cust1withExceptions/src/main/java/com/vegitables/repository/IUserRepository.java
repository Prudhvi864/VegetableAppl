package com.vegitables.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.vegitables.entities.User;

@Repository
public interface IUserRepository extends JpaRepository<User,Integer> {

	@Query("select us from User us where us.userId=?1")
	public Optional<User> viewByUserId(String userId);

}
