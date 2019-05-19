package com.melnichuk.bussinessCardServer.service;

import com.melnichuk.bussinessCardServer.document.Card;
import com.melnichuk.bussinessCardServer.repository.CardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CardService {

    private final CardRepository repository;

    @Autowired
    public CardService(CardRepository repository) {
        this.repository = repository;
    }

//    @PostConstruct
//    public void init(){
//        Card item = new Card();
//        //item.setId(2L);
//        item.setFirstName("goh");
//        item.setPhoneNum1("09534624");
//        repository.save(item);
//    }

    public List<Card> findAll(){
        return repository.findAll();
    }
}
