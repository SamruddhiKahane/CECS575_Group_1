package com.group1.theBookSpot;
import java.io.File;
import java.util.EventListener;

public class EmailNotification implements EventListener {
    private String email;

    public EmailNotification(String email) {
        this.email = email;
    }

    //@Override
    public void update(String eventType, File file) {
        System.out.println("Email to " + email + ": Book is available");
    }
}
