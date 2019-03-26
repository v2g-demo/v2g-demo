package com.v2gdemo.googlemap.security;

import com.v2gdemo.googlemap.dao.UserDao;
import com.v2gdemo.googlemap.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;


public class UserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService {
    @Autowired
    private UserDao userDao;
    @Autowired
    private PasswordEncoder encoder;
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
          User user = userDao.findByLogin(s);
        org.springframework.security.core.userdetails.User.UserBuilder userBuilder = null;
          if (user != null){
              userBuilder = org.springframework.security.core.userdetails.User.withUsername(s);
              userBuilder.password(user.getPassword());
              userBuilder.roles(user.getRoles().toString());
          }
        return userBuilder.build();
    }
}
