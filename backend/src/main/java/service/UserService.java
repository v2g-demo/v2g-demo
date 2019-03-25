package com.v2gdemo.googlemap.service;

import com.v2gdemo.googlemap.dao.UserDao;
import com.v2gdemo.googlemap.dto.UserDto;
import com.v2gdemo.googlemap.entity.Role;
import com.v2gdemo.googlemap.entity.User;
import com.v2gdemo.googlemap.restcontroller.exception.ServerException;
import com.v2gdemo.googlemap.security.JwtTokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.UUID;
import java.util.stream.Collectors;

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
  return   jwtTokenProvider.createToken(user.getLogin(),user.getRoles().stream().collect(Collectors.toList()));
} catch (AuthenticationException ex){

    throw  new ServerException("Wrong data!");
}

    }

    public void saveUser(UserDto user) throws ServerException{

        if (userDao.findByLogin(user.getUsername())!=null) throw new ServerException("User already exists");
        User newUser = new User();
        newUser.setId(UUID.randomUUID().toString());
        newUser.setLogin(user.getUsername());
        newUser.setEmail(user.getEmail());
        newUser.setLocation(user.getLocation());
        newUser.setPassword(encoder.encode(user.getPassword()));
        newUser.setName(user.getName());
        newUser.setSurname(user.getSurname());
        newUser.getRoles().add(Role.USER);
        userDao.save(newUser);

    }

    public User getUser(String id) throws ServerException {
        return userDao.findById(id).orElseThrow( ()->{return new ServerException("Couldnt find user with id: "+id);});
    }
}
