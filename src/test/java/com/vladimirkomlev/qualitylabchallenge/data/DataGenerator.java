package com.vladimirkomlev.qualitylabchallenge.data;

import com.github.javafaker.Faker;
import com.vladimirkomlev.qualitylabchallenge.model.EmailMessage;

public class DataGenerator {
    private static Faker faker = new Faker();
    private static final int SUBJECT_SYMBOLS_QUANTITY = 50;
    private static final int BODY_SYMBOLS_QUANTITY = 255;

    private static String randomString(int length) {
        return faker.regexify("[A-Za-z0-9]{" + length + "}");
    }

    private static String randomEmail() {
        return faker.bothify("????##@mailinator.com");
    }

    public static EmailMessage randomEmailMessage() {
        return new EmailMessage()
                .withTo(randomEmail())
                .withSubject(randomString(SUBJECT_SYMBOLS_QUANTITY))
                .withBody(randomString(BODY_SYMBOLS_QUANTITY));
    }
}
