package com.fintechlabs.authserver.repository;

import com.fintechlabs.authserver.domain.Role;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends CrudRepository<Role,String> {

    Optional<Role> findByName(String name);

    Integer countByName(String name);

}
