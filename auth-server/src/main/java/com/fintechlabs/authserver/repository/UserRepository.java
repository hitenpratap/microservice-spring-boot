package com.fintechlabs.authserver.repository;

import com.fintechlabs.authserver.domain.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<User, String> {

    Optional<User> findByEmailAddress(String emailAddress);

    Boolean existsByEmailAddress(String emailAddress);

    Optional<User> findByUniqueId(String uniqueId);

}
