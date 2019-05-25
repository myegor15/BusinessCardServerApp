package com.melnichuk.bussinessCardServer.document;

import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
public class Card {

    @Id
    private ObjectId id;

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