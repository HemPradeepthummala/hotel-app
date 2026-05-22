package org.example.hotelapp.repository;

import org.example.hotelapp.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.security.core.userdetails.UserDetails;

public interface UserRepository extends MongoRepository<User, String> {
	UserDetails findUserByUsername(String username);

	@Query(value = "{ 'username' : ?0 }", fields = "{ '_id' : 1 }")
	String findUserIdByUsername(String username);
}
