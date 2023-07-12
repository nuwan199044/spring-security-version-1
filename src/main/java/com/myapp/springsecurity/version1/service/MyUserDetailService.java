package com.myapp.springsecurity.version1.service;

import com.myapp.springsecurity.version1.model.MyUserDetail;
import com.myapp.springsecurity.version1.model.User;
import com.myapp.springsecurity.version1.repository.MyUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MyUserDetailService implements UserDetailsService {

    @Autowired
    MyUserRepository myUserRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = myUserRepository.findUserByUserName(username);
        user.orElseThrow(() -> new UsernameNotFoundException("user not found"));
        return user.map(MyUserDetail::new).get();
    }
}
