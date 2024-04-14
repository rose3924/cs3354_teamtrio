package com.utd.cs.cprm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.utd.cs.cprm.model.User;
import com.utd.cs.cprm.repository.UserRepository;

@Service
public class UserService {

	@Autowired 
    private UserRepository uRepository; 

    public User findByLogin(String login) {
        User u = uRepository.findByLogin(login);
        return u;
    }
    public List<User> findByLastName(String lastname) {
        List<User> list = uRepository.findByLastName( lastname);
        return list;
    }
    public List<User> findAll() {
        List<User> list = uRepository.findAll();
        return list;
    }
}
