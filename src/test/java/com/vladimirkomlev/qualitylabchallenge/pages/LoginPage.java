package com.vladimirkomlev.qualitylabchallenge.pages;

import com.vladimirkomlev.qualitylabchallenge.config.ApplicationProperties;
import com.vladimirkomlev.qualitylabchallenge.model.Credentials;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LoginPage extends BasePage {
    private static final String
        LOGIN_INPUT = "id:mailbox:login",
        PASSWORD_INPUT = "id:mailbox:password",
        SUBMIT_BUTTON = "id:mailbox:submit";

    @Autowired
    private ApplicationProperties appProperties;

    public void open() {
        this.driver.navigate().to(appProperties.getBaseUrl());
    }

    public void login(Credentials credentials) {
        this.waitElementAndSendKeys(
                LOGIN_INPUT,
                credentials.getEmail(),
                "Could not find login input"
        );
        this.waitForElementAndClick(
                SUBMIT_BUTTON,
                "Could not find submit button"
        );
        this.waitElementAndSendKeys(
                PASSWORD_INPUT,
                credentials.getPassword(),
                "Could not find password input"
        );
        this.waitForElementAndClick(
                SUBMIT_BUTTON,
                "Could not find submit button"
        );
    }
}
