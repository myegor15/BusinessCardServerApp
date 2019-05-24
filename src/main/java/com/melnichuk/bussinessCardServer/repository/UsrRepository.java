package com.melnichuk.bussinessCardServer.repository;

import com.melnichuk.bussinessCardServer.document.Usr;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsrRepository extends MongoRepository<Usr, ObjectId> {
    Usr findByUsername(String username);
}
