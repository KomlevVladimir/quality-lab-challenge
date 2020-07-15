package com.vladimirkomlev.qualitylabchallenge;

import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.test.context.TestPropertySource;

@SpringBootConfiguration
@SpringBootApplication
@TestPropertySource(locations = "classpath:application.properties")
public class ApplicationTest {
}
