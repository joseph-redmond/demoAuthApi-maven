package com.josephredmond.demoauthapi.email;

public interface EmailSender {
    void send(String to, String email);
}
