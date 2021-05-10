package com.example.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.entity.Feedback;

@Repository
public interface IFeedbackRepository extends JpaRepository<Feedback,Integer>{

//	 @Query("SELECT fd FROM Feedback fd where fd.vegetableId=:vegetableId")
//	    public List<Feedback> viewAllFeedbacks(@Param("vegetableId") int vegetableId);
	 
//	    @Query("SELECT fd FROM Feedback fd where fd.customerId=:customerId")
//	    public List<Feedback> viewFeedback(@Param("customerId") int customerId);
	
	
}
