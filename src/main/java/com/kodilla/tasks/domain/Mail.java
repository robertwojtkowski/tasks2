package com.kodilla.tasks.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@AllArgsConstructor
@RequiredArgsConstructor
public class Mail {
    private String mailTo;
    private String subject;
    private String message;
    private String toCc;

    public Mail(String s, String subject, String s1) {
        this.mailTo = s;
        this.subject = subject;
        this.message = s1;

    }
}
