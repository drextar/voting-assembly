package br.com.sicredi.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import br.com.sicredi.document.Session;

@Repository
public interface SessionRepository extends MongoRepository<Session, String>{

}
