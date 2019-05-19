package com.melnichuk.bussinessCardServer.repository;

import com.melnichuk.bussinessCardServer.document.Card;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CardRepository extends MongoRepository<Card, Long> {
}
