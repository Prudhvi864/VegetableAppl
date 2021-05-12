package com.vegitables.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.vegitables.entities.Admin;

@Repository
public interface IAdminRepository extends JpaRepository<Admin, Integer> {

}
