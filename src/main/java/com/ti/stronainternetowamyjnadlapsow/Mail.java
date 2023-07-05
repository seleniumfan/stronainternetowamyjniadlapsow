package com.ti.stronainternetowamyjnadlapsow;

public class Mail {
    private String senderName;
    private String email;
    private String content;

    public Mail(String sender, String email, String content) {
        this.senderName = sender;
        this.email = email;
        this.content = content;
    }

    public String getSender() {
        return senderName;
    }

    public void setSender(String sender) {
        this.senderName = sender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
