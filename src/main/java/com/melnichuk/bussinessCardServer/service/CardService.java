package com.melnichuk.bussinessCardServer.service;

import com.melnichuk.bussinessCardServer.document.Card;
import com.melnichuk.bussinessCardServer.document.Usr;
import com.melnichuk.bussinessCardServer.repository.UsrRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class CardService {

    private final UsrRepository repository;

    @Autowired
    public CardService(UsrRepository repository) {
        this.repository = repository;
    }

//    @PostConstruct
//    public void init(){
////        Card item = new Card();
////        //item.setId(2L);
////        item.setFirstName("goh");
////        item.setPhoneNum1("09534624");
////        repository.findByUsername("admin").getAllCards().add(item);
//        Usr usr = repository.findByUsername("admin");
//        usr.getAllCards().clear();
//        repository.save(usr);
//    }

    //need rename
    public List<Card> findAllCards(String username){
        return repository.findByUsername(username).getAllCards();
    }

    public void addOneCard(String username, Card card) {
        Usr usr = repository.findByUsername(username);
        if (usr.getAllCards() == null) {
            usr.setAllCards(new ArrayList<>());
        }
        usr.getAllCards().add(card);
        usr.setAllCardsLastUpdate(new Date());
        repository.save(usr);
    }

    public void addAllCards(String username, List<Card> cards) {
        Usr usr = repository.findByUsername(username);
        usr.setAllCards(cards);
        usr.setAllCardsLastUpdate(new Date());
        repository.save(usr);
    }

    public Card findPersonalCard(String username) {
        return repository.findByUsername(username).getPersonalCard();
    }

    public void addPersonalCard(String username, Card card) {
        Usr usr = repository.findByUsername(username);
        usr.setPersonalCard(card);
        usr.setPersonalCardLastUpdate(new Date());
        repository.save(usr);
    }
}
