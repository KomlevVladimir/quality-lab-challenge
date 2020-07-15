package com.vladimirkomlev.qualitylabchallenge.tests;

import com.vladimirkomlev.qualitylabchallenge.model.EmailMessage;
import com.vladimirkomlev.qualitylabchallenge.pages.ComposeLetterPage;
import com.vladimirkomlev.qualitylabchallenge.pages.InboxPage;
import com.vladimirkomlev.qualitylabchallenge.pages.LoginPage;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static com.vladimirkomlev.qualitylabchallenge.data.DataGenerator.randomEmailMessage;

@SpringBootTest
class SendEmailTest extends BaseTest {
    @Autowired
    private LoginPage loginPage;
    @Autowired
    private InboxPage inboxPage;
    @Autowired
    private ComposeLetterPage composeLetterPage;

    @Test
    void sendEmailTest() {
        loginPage.open();
        loginPage.login(credentials);
        inboxPage.clickWriteEmail();
        EmailMessage emailMessage = randomEmailMessage();
        composeLetterPage.sendEmail(emailMessage);
        composeLetterPage.emailShouldBeSent();
    }
}
