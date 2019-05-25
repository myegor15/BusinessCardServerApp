package com.melnichuk.bussinessCardServer.document;

import lombok.Data;

@Data
public class Card {
    private long id;
    private String firstName;
    private String secondName;
    private String lastName;
    private String phoneNum1;
    private String phoneNum2;
    private String fax;
    private String email;
    private String company;
    private String profession;
    private String address;
    private String web;
    private String facebook;
    private String twitter;
    private String instagram;
}