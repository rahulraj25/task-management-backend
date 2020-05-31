package com.hackerrank.stackhack.repository;

import java.util.Optional;
import org.springframework.data.mongodb.repository.MongoRepository;
import com.hackerrank.stackhack.model.ERole;
import com.hackerrank.stackhack.model.Role;


public interface RoleRepository extends MongoRepository<Role, String> {
  Optional<Role> findByName(ERole name);
}