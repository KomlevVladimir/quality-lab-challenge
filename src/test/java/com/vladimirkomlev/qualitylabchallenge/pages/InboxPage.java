package com.vladimirkomlev.qualitylabchallenge.pages;

import org.springframework.stereotype.Component;

@Component
public class InboxPage extends BasePage {
    private static final String COMPOSE_EMAIL_BUTTON = "css:a[title=\"Написать письмо\"]";

    public void clickWriteEmail() {
        this.waitForElementAndClick(COMPOSE_EMAIL_BUTTON, "Could not find compose email button");
    }

}
