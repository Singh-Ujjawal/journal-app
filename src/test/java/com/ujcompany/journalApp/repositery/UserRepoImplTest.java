package com.ujcompany.journalApp.repositery;

import com.ujcompany.journalApp.entity.ConfigJournalAppEntity;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UserRepoImplTest {

    @Autowired
    UserRepoImpl userRepo;

    @Test
    public void testSaveNewUser() {
        Assertions.assertNotNull(userRepo.getForSA());
    }
}
