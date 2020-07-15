package com.vladimirkomlev.qualitylabchallenge.tests;

import com.vladimirkomlev.qualitylabchallenge.config.ApplicationProperties;
import com.vladimirkomlev.qualitylabchallenge.model.Credentials;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;

public class BaseTest {
    protected Credentials credentials;
    @Autowired
    private WebDriver driver;
    @Autowired
    private ApplicationProperties appProperties;

    @BeforeEach
    public void setUp() {
        credentials = new Credentials()
                .withEmail(appProperties.getEmail())
                .withPassword(appProperties.getPassword());
    }

    @AfterEach()
    public void stop() {
        driver.quit();
    }
}
