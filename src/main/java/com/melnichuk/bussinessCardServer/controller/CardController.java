package com.melnichuk.bussinessCardServer.controller;

import com.melnichuk.bussinessCardServer.document.Card;
import com.melnichuk.bussinessCardServer.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("cards")
public class CardController {

    private final CardService service;

    @Autowired
    public CardController(CardService service) {
        this.service = service;
    }

    @GetMapping
    public List<Card> getAll(){
        return service.findAll();
    }

//    private int counter = 4;
//
//    private List<Map<String, String>> cards = new ArrayList<Map<String, String>>(){{
//        add(new HashMap<String, String>() {{put("id", "1"); put("text", "First card"); }});
//        add(new HashMap<String, String>() {{put("id", "2"); put("text", "Second card"); }});
//        add(new HashMap<String, String>() {{put("id", "3"); put("text", "Third card"); }});
//    }};
//
//    @GetMapping
//    public List<Map<String, String>> list(){
//        return cards;
//    }
//
//    @GetMapping("{id}")
//    public Map<String, String> getOne(@PathVariable String id){
//        return getCard(id);
//    }
//
//    private Map<String, String> getCard(@PathVariable String id) {
//        return cards.stream()
//                .filter(cards -> cards.get("id").equals(id))
//                .findFirst()
//                .orElseThrow(NotFoundException::new);
//    }
//
//    @PostMapping
//    public Map<String, String> create(@RequestBody Map<String, String> card) {
//        card.put("id", String.valueOf(counter++));
//
//        cards.add(card);
//
//        return card;
//    }
//
//    @PutMapping("{id}")
//    public Map<String, String> update(@PathVariable String id, @RequestBody Map<String, String> card){
//        Map<String, String> cardFromDB = getCard(id);
//
//        cardFromDB.putAll(card);
//        cardFromDB.put("id", id);
//
//        return cardFromDB;
//    }
//
//    @DeleteMapping("{id}")
//    public void delete(@PathVariable String id){
//        Map<String, String> card = getCard(id);
//
//        cards.remove(card);
//    }
}
