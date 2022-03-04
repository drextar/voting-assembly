package br.com.sicredi.services;

import java.util.List;
import java.util.Optional;

import br.com.sicredi.document.Vote;

public interface VoteService {

	List<Vote> findAll();	
	Optional<Vote> findById(String id);
	Vote vote(Vote voto);
}
