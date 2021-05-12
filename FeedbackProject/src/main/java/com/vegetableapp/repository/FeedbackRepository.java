package com.vegetableapp.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.vegetableapp.entity.Customer;
import com.vegetableapp.entity.Feedback;
/*
 * @Repository annotation is used to indicate that the class provides the mechanism 
 * for storage, retrieval, search, update and delete operation on objects.
 *
 *
 * JpaRepository (Defined in Spring Data JPA) is the JPA specific Repository interface. 
 * 
 * Feedback  is the entity that is being managed and the primary key of VegetableID and Customer is Integer.
 */

@Repository
public interface FeedbackRepository extends JpaRepository<Feedback, Integer> {

	@Query("SELECT fd FROM Feedback fd where fd.vegetableId=:vegetableId")
	public List<Feedback> viewAllFeedbacks(@Param("vegetableId") int vegetableId);

	@Query("SELECT b FROM Feedback b where b.customerId.customerId=:customerId")
	public List<Feedback> viewFeedback(@Param("customerId") int customerId);
	
	@Query("SELECT fr FROM Feedback fr where fr.rating=:rating")
	public List<Feedback> viewRating(@Param("rating") int rating);
}
