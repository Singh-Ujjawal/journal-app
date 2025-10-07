package com.ujcompany.journalApp.controller;

import com.ujcompany.journalApp.cache.AppCache;
import com.ujcompany.journalApp.entity.User;
import com.ujcompany.journalApp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    UserService userService;

    @Autowired
    AppCache appCache;

    @GetMapping("all-users")
    public ResponseEntity<?> getAllUsers() {
        List<User> all = userService.getAll();
        if(all!=null && !all.isEmpty()){
            return new  ResponseEntity<>(all, HttpStatus.OK);
        }
        return new  ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("clear-app-cache")
    public void clearAppCache() {
        appCache.init();
    }

}
