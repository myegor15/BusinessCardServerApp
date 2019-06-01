package com.melnichuk.bussinessCardServer.repository;

import com.melnichuk.bussinessCardServer.document.Usr;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsrRepository extends MongoRepository<Usr, ObjectId> {
    Usr findByUsername(String username);

    List<Usr> findAllByPersonalCard_FirstName(String name);
    List<Usr> findAllByPersonalCard_LastName(String name);
    List<Usr> findAllByPersonalCard_Company(String name);
}
