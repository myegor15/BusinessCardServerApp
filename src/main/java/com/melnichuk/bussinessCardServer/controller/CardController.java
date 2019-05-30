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
    public void addOneCard(@RequestHeader("Update-Time") long time,
                           @RequestBody Card card) {
        service.addOneCard(time, card);
    }

    @PostMapping
    public void addAllCards(@RequestHeader("Update-Time") long time,
                            @RequestBody List<Card> cards) {
        service.addAllCards(time, cards);
    }

    @GetMapping("/personal")
    public Card getPersonalCard() {
        return service.findPersonalCard();
    }

    @PostMapping("/personal")
    public void addPersonalCard(@RequestHeader("Update-Time") long time,
                                @RequestBody Card card) {
        service.addPersonalCard(time, card);
    }

    @GetMapping("/update")
    public List<Long> getCardsLastUpdate() {
        return service.findCardsLastUpdate();
    }
}