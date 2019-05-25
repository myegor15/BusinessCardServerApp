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
    public List<Card> getAll(@RequestHeader("username") String username){
        return service.findAllCards(username);
    }

    @PostMapping("/one")
    public void addOneCard(@RequestHeader("username") String username, @RequestBody Card card) {
        service.addOneCard(username, card);
    }

    @PostMapping
    public void addAllCards(@RequestHeader("username") String username, @RequestBody List<Card> cards) {
        service.addAllCards(username, cards);
    }

    @GetMapping("/personal")
    public Card getPersonalCard(@RequestHeader("username") String username) {
        return service.findPersonalCard(username);
    }

    @PostMapping("/personal")
    public void addPersonalCard(@RequestHeader("username") String username, @RequestBody Card card) {
        service.addPersonalCard(username, card);
    }
}