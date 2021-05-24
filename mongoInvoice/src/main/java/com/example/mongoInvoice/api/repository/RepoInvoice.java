package com.example.mongoInvoice.api.repository;

import com.example.mongoInvoice.api.entity.Invoice; 
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;



@Repository

public interface RepoInvoice extends MongoRepository<Invoice, Integer> {


}
