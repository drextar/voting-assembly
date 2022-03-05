package br.com.sicredi.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.sicredi.document.Vote;

@Repository
public interface VoteRepository extends MongoRepository<Vote, String>{

	@Query("{ 'cpf': ?0, 'sessionID': ?1 }")
	List<Vote> findByCpf(String cpf, String sessaoId);

	@Query("{ 'sessionID': ?0 }")
	List<Vote> findBySessionId(String sessionId);

}
