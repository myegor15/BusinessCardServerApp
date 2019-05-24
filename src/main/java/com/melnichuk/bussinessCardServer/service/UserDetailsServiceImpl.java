package com.melnichuk.bussinessCardServer.service;

import com.melnichuk.bussinessCardServer.document.Usr;
import com.melnichuk.bussinessCardServer.repository.UsrRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UsrRepository usrRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public UserDetailsServiceImpl(UsrRepository repository, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.usrRepository = repository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usr user = usrRepository.findByUsername(username);

        if (user == null) {
            throw new UsernameNotFoundException(username);
        }

        return new User(user.getUsername(), user.getPassword(), Collections.emptyList());
    }

    public void addUser(Usr usr) {
        usr.setPassword(bCryptPasswordEncoder.encode(usr.getPassword()));
        usrRepository.save(usr);
    }
}
