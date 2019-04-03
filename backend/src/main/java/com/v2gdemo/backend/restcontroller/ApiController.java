package com.v2gdemo.backend.restcontroller;

import com.v2gdemo.backend.entity.Object;
import com.v2gdemo.backend.entity.ObjectRepository;
import com.v2gdemo.backend.restcontroller.exception.ServerException;
import com.v2gdemo.backend.service.ApiService;
import com.v2gdemo.places.FindRouteObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ApiController {
  @Autowired
  private ApiService apiService;

  @Autowired
  private FindRouteObject findRoute;
   @GetMapping("/buildroute")
  public String buildRoute(@RequestParam(name = "from") long from,@RequestParam("to") long to) throws ServerException{
return apiService.buildRoute(from,to);
   }
}
