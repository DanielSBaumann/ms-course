package com.github.danielsbaumann.hroauth.services;

import com.github.danielsbaumann.hroauth.entities.User;
import com.github.danielsbaumann.hroauth.feignclients.UserFeignClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserFeignClient userFeignClient;

    private static Logger log = LoggerFactory.getLogger(UserService.class);

    public User findByEmail(String email) {
        User user = userFeignClient
                .findByEmail(email)
                .getBody();
        if (user == null) {
            log.error("Email not found : " + email);
            throw new IllegalArgumentException("Email not found");
        }
        log.error("Email found : " + email);
        return user;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userFeignClient
                .findByEmail(username)
                .getBody();
        if (user == null) {
            log.error("Email not found : " + username);
            throw new UsernameNotFoundException("Email not found");
        }
        log.error("Email found : " + username);
        return user;
    }
}
