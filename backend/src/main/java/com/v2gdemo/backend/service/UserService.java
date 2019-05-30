package com.v2gdemo.backend.service;

import com.v2gdemo.backend.dao.UserDao;
import com.v2gdemo.backend.dto.UserDto;
import com.v2gdemo.backend.entity.User;
import com.v2gdemo.backend.restcontroller.exception.ServerException;
import com.v2gdemo.backend.security.JwtTokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserService {
    @Autowired
    private UserDao userDao;
    @Autowired
    private PasswordEncoder encoder;
    @Autowired
    private AuthenticationManager manager;
    @Autowired
    private JwtTokenProvider jwtTokenProvider;
    public String signIn(String username,String password) throws ServerException {
        User user = userDao.findByLogin(username);
try {
    manager.authenticate(new UsernamePasswordAuthenticationToken(username,password));
  return   jwtTokenProvider.createToken(user.getLogin(),user.getRole());
} catch (AuthenticationException ex){

    throw  new ServerException("Wrong data!");
}

    }

    public void saveUser(UserDto user) throws ServerException{

        if (userDao.findByLogin(user.getUsername())!=null) throw new ServerException("User already exists");
        User newUser = new User();
        newUser.setLogin(user.getUsername());
        newUser.setEmail(user.getEmail());
        newUser.setPassword(encoder.encode(user.getPassword()));
        newUser.setName(user.getName());
        newUser.setRole(User.Role.PLAYER);
        userDao.save(newUser);

    }

    public User getUser(long id) throws ServerException {
        return userDao.findById(id).orElseThrow( ()->{return new ServerException("Couldnt find user with id: "+id);});
    }
}
