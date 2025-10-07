package com.ujcompany.journalApp.service;

import com.ujcompany.journalApp.entity.User;
import com.ujcompany.journalApp.repositery.UserRepo;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Component;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class UserServiceTests {

    @Autowired
    private UserRepo userRepo;

    @Disabled
    @Test
    public void testAdd() {
        assertNotNull(userRepo.findByUsername("ram"));
    }


    @Disabled
    @ParameterizedTest
    @ValueSource(strings = {
            "ram",
            "shyam",
            "vipul"
    })
    public void testFindByUsername(String username){
        User user = userRepo.findByUsername(username);
        assertNotNull(user,"User not found " + username);
    }

    @Disabled
    @ParameterizedTest
    @CsvSource({
            "1,2,3",
            "2,3,5",
            "3,4,5"
    })
    public void testing(int a,int b,int expected) {
        assertEquals(expected,a+b);
    }
}
