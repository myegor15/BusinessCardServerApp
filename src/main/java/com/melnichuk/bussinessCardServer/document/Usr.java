package com.melnichuk.bussinessCardServer.document;

import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
public class Usr {

    @Id
    private ObjectId id;

    private String username;
    private String password;
}