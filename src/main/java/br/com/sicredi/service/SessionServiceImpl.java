package br.com.sicredi.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.sicredi.document.Session;
import br.com.sicredi.document.Vote;
import br.com.sicredi.util.exception.ScheduleNameEmptyException;
import br.com.sicredi.repository.SessionRepository;
import br.com.sicredi.repository.VoteRepository;

@Service
public class SessionServiceImpl implements SessionService{

	@Autowired
	private SessionRepository sessionRepository;
	
	@Autowired
	private VoteRepository voteRepository;
	
	@Override
	public List<Session> findAll() {
		return sessionRepository.findAll();
	}

	@Override
	public Optional<Session> findById(String id) {
		return sessionRepository.findById(id);
	}

	@Override
	public Session save(Session session) {	
		session.setStartTime(LocalDateTime.now());
		
		if(session.getValidityTime() == null) {
			session.setValidityTime((long) 60);
		}
		
		if(session.getSchedulerID().isEmpty()) {
			throw new ScheduleNameEmptyException("Obrigatorio informar um ID valido");
		}

		return sessionRepository.save(session);
	}

	@Override
	public String resultVoteSession(String id) {
		List<Vote> votes = voteRepository.findBySessionId(id);
		String result = "";
		
		if(!votes.isEmpty()) {
			result = "Total de Votos: " + votes.size() + "\n";
			Integer votesInFavor = 0;
			Integer votesAgainst = 0;
	 		
			for (Vote vote : votes) {
				if(vote.isInFavor()) {
					votesInFavor++;
				} else {
					votesAgainst++;
				}
			}
			
			result += "Votos a favor: " + votesInFavor + " \nVotos contra: " + votesAgainst;
		} else {
			result = "Nao foram computados votos para esta sessao";
		}
		
		return result;
	}		
}
