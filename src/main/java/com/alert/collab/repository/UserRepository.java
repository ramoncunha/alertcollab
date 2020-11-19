package com.alert.collab.repository;

import com.alert.collab.security.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<Long, User> {

    User findByUsername(String username);
}
