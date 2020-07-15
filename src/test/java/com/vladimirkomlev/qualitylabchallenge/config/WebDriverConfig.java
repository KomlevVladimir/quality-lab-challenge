package com.vladimirkomlev.qualitylabchallenge.config;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WebDriverConfig {
    private static final String CHROME = "chrome";
    private static final int TIMEOUT_IN_SECONDS = 40;

    @Qualifier(CHROME)
    @Bean
    public WebDriver chromeDriver() {
        WebDriverManager.chromedriver().setup();
        return new ChromeDriver();
    }

    @Bean
    public WebDriverWait wait(WebDriver driver) {
        return new WebDriverWait(driver, TIMEOUT_IN_SECONDS);
    }




}
