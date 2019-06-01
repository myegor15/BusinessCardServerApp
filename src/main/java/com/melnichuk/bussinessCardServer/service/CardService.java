package com.melnichuk.bussinessCardServer.service;

import com.melnichuk.bussinessCardServer.document.Card;
import com.melnichuk.bussinessCardServer.document.Usr;
import com.melnichuk.bussinessCardServer.repository.UsrRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
    public List<Card> findAllCards(){
        return repository.findByUsername(getUsername()).getAllCards();
    }

    public void addOneCard(long time, Card card) {
        Usr usr = repository.findByUsername(getUsername());
        if (usr.getAllCards() == null) {
            usr.setAllCards(new ArrayList<>());
        }
        usr.getAllCards().add(card);
        usr.setAllCardsLastUpdate(time);
        repository.save(usr);
    }

    public void addAllCards(long time, List<Card> cards) {
        Usr usr = repository.findByUsername(getUsername());
        usr.setAllCards(cards);
        usr.setAllCardsLastUpdate(time);
        repository.save(usr);
    }

    public Card findPersonalCard() {
        return repository.findByUsername(getUsername()).getPersonalCard();
    }

    public void addPersonalCard(long time, Card card) {
        Usr usr = repository.findByUsername(getUsername());
        usr.setPersonalCard(card);
        usr.setPersonalCardLastUpdate(time);
        repository.save(usr);
    }

    public List<Long> findCardsLastUpdate() {
        List<Long> list = new ArrayList<>();
        list.add(repository.findByUsername(getUsername()).getPersonalCardLastUpdate());
        list.add(repository.findByUsername(getUsername()).getAllCardsLastUpdate());

        return list;
    }

    public List<Card> globalSearch(String name) {
        List<Usr> usrList = repository.findAllByPersonalCard_FirstName(name);
        usrList.addAll(repository.findAllByPersonalCard_LastName(name));
        usrList.addAll(repository.findAllByPersonalCard_Company(name));
//        usrList.remove(repository.findByUsername(getUsername()));
        List<Card> cardList = new ArrayList<>();
        usrList.forEach(usr -> {
            Card card = new Card();
            card.setFirstName(usr.getPersonalCard().getFirstName());
            card.setSecondName(usr.getPersonalCard().getSecondName());
            card.setLastName(usr.getPersonalCard().getLastName());
            card.setCompany(usr.getPersonalCard().getCompany());
            card.setEmail(usr.getPersonalCard().getEmail());
            cardList.add(card);
        });

        return cardList;
    }

    private String getUsername() {
        return SecurityContextHolder.getContext().getAuthentication().getName();
    }
}
