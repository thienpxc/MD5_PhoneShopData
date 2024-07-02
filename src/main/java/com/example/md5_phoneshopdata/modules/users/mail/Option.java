package com.example.md5_phoneshopdata.modules.users.mail;

import lombok.Data;

import java.util.ArrayList;

@Data
public class Option {
    String subject;
    String text;
    ArrayList<String> to;

    public  Option (String subject, String text, ArrayList<String> to) {
        this.subject = subject;
        this.text = text;
        this.to = to;
    }
}
