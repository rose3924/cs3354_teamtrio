package com.utd.cs.cprm.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.utd.cs.cprm.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, String>{

	public List<User> findAll();
    public List<User> findByLastName(String lastname);
    public User findByLogin(String login);
}
