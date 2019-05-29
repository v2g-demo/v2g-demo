package com.v2gdemo.backend.restcontroller;

import com.v2gdemo.backend.dto.UserDto;
import com.v2gdemo.backend.entity.User;
import com.v2gdemo.backend.restcontroller.exception.ServerException;
import com.v2gdemo.backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService dao;
    @PostMapping("/login")
    private ResponseEntity<String> login(@RequestBody UserDto userDto, HttpServletResponse response) throws ServerException {
        String token = dao.signIn(userDto.getUsername(),userDto.getPassword());
      response.addHeader("Authorization","Bearer "+token);

       return new ResponseEntity<>("Logged in! \n Bearer "+token,HttpStatus.ACCEPTED);

    }
    @PostMapping("/add")
    public void addUser(@RequestBody UserDto userDto) throws ServerException {
        dao.saveUser(userDto);

    }
    @GetMapping("get/{userId}")
    public User getUser(@PathVariable(name = "userId") long id)throws ServerException{
        return dao.getUser(id);
    }


}
