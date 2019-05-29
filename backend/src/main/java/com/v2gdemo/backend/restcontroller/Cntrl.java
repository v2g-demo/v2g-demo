package com.v2gdemo.backend.restcontroller;

import com.v2gdemo.backend.dao.UserDao;
import com.v2gdemo.backend.entity.User;
import com.v2gdemo.backend.restcontroller.exception.ServerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.PersistentEntityResource;
import org.springframework.data.rest.webmvc.PersistentEntityResourceAssembler;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@RepositoryRestController
public class Cntrl {
@Autowired
private UserDao userDao;


@RequestMapping(name = "users/{id}/ff",method = RequestMethod.GET)
@ResponseBody
  public PersistentEntityResource setNameOne(@PathVariable("id") Long id, PersistentEntityResourceAssembler persistentEntityResourceAssembler){
  User user = userDao.findById(id).orElseThrow(()->{
    throw new ServerException("Wrong id");
  });

  user.setLogin("One");
  userDao.save(user);
  return persistentEntityResourceAssembler.toFullResource(user);
}
}
