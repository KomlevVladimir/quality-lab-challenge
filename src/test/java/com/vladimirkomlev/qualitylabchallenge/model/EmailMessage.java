package com.vladimirkomlev.qualitylabchallenge.model;

public class EmailMessage {
    private String to;
    private String subject;
    private String body;

    public String getTo() {
        return to;
    }

    public EmailMessage withTo(String to) {
        this.to = to;
        return this;
    }

    public String getSubject() {
        return subject;
    }

    public EmailMessage withSubject(String subject) {
        this.subject = subject;
        return this;
    }

    public String getBody() {
        return body;
    }

    public EmailMessage withBody(String body) {
        this.body = body;
        return this;
    }
}
