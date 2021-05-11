package com.vegetableapp.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.vegetableapp.entity.Customer;
import com.vegetableapp.entity.Feedback;
@Repository
public interface FeedbackRepository extends JpaRepository<Feedback,Integer>{

	@Query("SELECT fd FROM Feedback fd where fd.vegetableId=:vegetableId")
	public List<Feedback> viewAllFeedbacks(@Param("vegetableId") int vegetableId);
	@Query("SELECT b FROM Feedback b where b.customerId.customerId=:customerId")
	public List<Feedback> viewFeedback(@Param("customerId") int customerId);
	//@Query("select fd.Customer from  Feedback fd inner join fd.customerId );
}
