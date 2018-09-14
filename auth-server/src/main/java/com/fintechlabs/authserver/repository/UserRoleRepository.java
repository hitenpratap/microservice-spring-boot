package com.fintechlabs.authserver.repository;

import com.fintechlabs.authserver.domain.Role;
import com.fintechlabs.authserver.domain.User;
import com.fintechlabs.authserver.domain.UserRole;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRoleRepository extends CrudRepository<UserRole, String> {

    Iterable<UserRole> findAllByUser(User user);

    Iterable<UserRole> findAllByRole(Role role);

}
