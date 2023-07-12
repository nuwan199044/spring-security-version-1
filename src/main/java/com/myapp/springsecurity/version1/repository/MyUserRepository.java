package com.myapp.springsecurity.version1.repository;

import com.myapp.springsecurity.version1.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MyUserRepository extends JpaRepository<User, Integer> {

    Optional<User> findUserByUserName(String userName);

}
