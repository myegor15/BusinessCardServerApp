package com.melnichuk.bussinessCardServer.document;

import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;

@Document
@Data
public class Usr {

    @Id
    private ObjectId id;

    @Indexed(unique = true)
    private String username;

    private String password;

    private Date personalCardLastUpdate;
    private Card personalCard;

    private Date allCardsLastUpdate;
    private List<Card> allCards;
}