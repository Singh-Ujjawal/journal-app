package com.ujcompany.journalApp.service;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.javamail.JavaMailSender;

@SpringBootTest
public class EmailServiceTest {

    @Autowired
    private EmailService emailService;

    @Disabled
    @Test
    public void testSendMail() {
        emailService.sendEmail("singhujjawal9096@gmail.com",
                "Testing java mail sender",
                "Hi , How are you :)");
    }
//    https://github.com/Singh-Ujjawal/journal-app.git

}
