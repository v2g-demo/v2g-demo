package com.v2gdemo.api;

import com.v2gdemo.api.data.ObjectModel;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class ApiController {

    @GetMapping("/objects")
    public List<ObjectModel> getObjects() {
        return null;
    }
}
