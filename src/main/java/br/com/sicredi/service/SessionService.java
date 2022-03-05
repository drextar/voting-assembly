package br.com.sicredi.service;

import java.util.List;
import java.util.Optional;

import br.com.sicredi.document.Session;

public interface SessionService {
	
	List<Session> findAll();	
	Optional<Session> findById(String id);	
	Session save(Session session);
	String resultVoteSession(String id);
	
}
