package com.melnichuk.bussinessCardServer.controller;

import com.melnichuk.bussinessCardServer.document.Card;
import com.melnichuk.bussinessCardServer.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cards")
public class CardController {

    private final CardService service;

    @Autowired
    public CardController(CardService service) {
        this.service = service;
    }

    @GetMapping
    public List<Card> getAll(){
        return service.findAllCards();
    }

    @PostMapping("/one")
    public void addOneCard(@RequestBody Card card) {
        service.addOneCard(card);
    }

    @PostMapping
    public void addAllCards(@RequestBody List<Card> cards) {
        service.addAllCards(cards);
    }

    @GetMapping("/personal")
    public Card getPersonalCard() {
        return service.findPersonalCard();
    }

    @PostMapping("/personal")
    public void addPersonalCard(@RequestBody Card card) {
        service.addPersonalCard(card);
    }
}