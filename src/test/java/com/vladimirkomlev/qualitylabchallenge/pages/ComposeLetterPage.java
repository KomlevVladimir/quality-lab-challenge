package com.vladimirkomlev.qualitylabchallenge.pages;

import com.vladimirkomlev.qualitylabchallenge.model.EmailMessage;
import org.junit.jupiter.api.Assertions;
import org.springframework.stereotype.Component;

@Component
public class ComposeLetterPage extends BasePage {
    private static final String
        TO_INPUT = "css:.compose-app__compose div label input",
        SUBJECT_INPUT = "css:.compose-app__compose div>div>div>input",
        BODY_AREA = "css:div[role=\"textbox\"]",
        SEND_BUTTON = "css:span[title=\"Отправить\"]",
        EMAIL_SENT_TEXT = "css:a.layer__link";

    public void sendEmail(EmailMessage emailMessage) {
        this.waitElementAndSendKeys(
                TO_INPUT,
                emailMessage.getTo(),
                "Could not find to input"
        );
        this.waitElementAndSendKeys(
                SUBJECT_INPUT,
                emailMessage.getSubject(),
                "Could not find subject input"
        );
        this.waitElementAndSendKeys(
                BODY_AREA,
                emailMessage.getBody(),
                "Could not find body area"
        );
        this.waitForElementAndClick(SEND_BUTTON, "Could not find send button");
    }

    public void emailShouldBeSent() {
        String text = this.waitForElementPresent(
                EMAIL_SENT_TEXT,
                "Could not find email sent text"
        ).getText();
        Assertions.assertEquals("Письмо отправлено", text, "Email not sent");
    }
}

