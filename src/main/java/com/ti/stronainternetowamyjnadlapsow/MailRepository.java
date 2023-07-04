package com.ti.stronainternetowamyjnadlapsow;

import java.util.ArrayList;
import java.util.List;

public class MailRepository {
    private List<Mail> mails;

    public MailRepository() {
        mails = new ArrayList<>();
    }

    public void add(Mail mail) {
        mails.add(mail);
    }

    public List<Mail> findAll() {
        return mails;
    }
}
