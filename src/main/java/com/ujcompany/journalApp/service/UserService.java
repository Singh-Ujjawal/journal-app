package com.ujcompany.journalApp.service;

import com.ujcompany.journalApp.entity.User;
import com.ujcompany.journalApp.repositery.UserRepo;
import lombok.extern.slf4j.Slf4j;
import org.bson.types.ObjectId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Slf4j
@Component
public class UserService {

    @Autowired
    private UserRepo userEntryRepo;

    private static final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

//    private static final Logger logger = LoggerFactory.getLogger(UserService.class);


    public void saveEntry(User journalEntry) {
        userEntryRepo.save(journalEntry);
    }

    public boolean saveNewEntry(User journalEntry) {
        try {
            journalEntry.setPassword(passwordEncoder.encode(journalEntry.getPassword()));
            journalEntry.setRoles(Arrays.asList("ROLE_USER"));
            userEntryRepo.save(journalEntry);
            return true;
        }
        catch (Exception e) {
            log.error("hahahahahahaha");
//            logger is used with Logger
            log.info("hahahahahahaha");
            log.trace("hahahahahahaha");
            log.warn("hahahahahahaha");
            log.debug("hahahahahahaha");
            return false;
        }
    }

    public List<User> getAll() {
        return userEntryRepo.findAll();
    }

    public Optional<User> getById(ObjectId id) {
        return userEntryRepo.findById(id);
    }

    public void deleteById(ObjectId id) {
        userEntryRepo.deleteById(id);
    }

    public User findByUsername(String username) {
        return userEntryRepo.findByUsername(username);
    }

}
