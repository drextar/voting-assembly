package br.com.sicredi.services;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.sicredi.client.AssociateValidatorClient;
import br.com.sicredi.document.Session;
import br.com.sicredi.document.Vote;
import br.com.sicredi.exception.AssociateNotFoundException;
import br.com.sicredi.exception.SessionExpirateTimeException;
import br.com.sicredi.repository.SessionRepository;
import br.com.sicredi.repository.VoteRepository;

@Service
public class VoteServiceImpl implements VoteService {
	
	final Logger logger = LoggerFactory.getLogger(VoteServiceImpl.class);

	@Autowired
	private VoteRepository voteRepository;
	
	@Autowired
	private SessionRepository sessionRepository;

	@Autowired
	private AssociateValidatorClient associateValidatorClient;
	
	@Override
	public List<Vote> findAll() {
		return voteRepository.findAll();
	}

	@Override
	public Optional<Vote> findById(String id) {
		return voteRepository.findById(id);
	}
	
	private void verifyIfAssociateIsAbleToVote(Vote voto) {
        var associateVotingStatus = associateValidatorClient.getAssociateVotingStatus(voto.getCpf());        
        
        if (!associateVotingStatus.getStatus().equals("ABLE_TO_VOTE")) {        
            throw new AssociateNotFoundException("CPF Invalido, confira as informacoes e tente novamente");
        }

    }
	
	@Override
	public Vote vote(Vote vote) {

		verifyIfAssociateIsAbleToVote(vote);
		
		List<Vote> lista = voteRepository.findByCpf(vote.getCpf(), vote.getSessionID());
		Optional<Session> sessao = sessionRepository.findById(vote.getSessionID());
		
		if(!sessao.isPresent()) {
			return new Vote();
		}
		
		Session sessionValid = sessao.get();
		
		System.out.println(sessionValid.getStartTime().plusSeconds(sessionValid.getValidityTime()));
		System.out.println(LocalDateTime.now());
		
		//Verificar se a sessao ainda esta valida
		if(sessionValid.getStartTime().plusSeconds(sessionValid.getValidityTime()).isAfter(LocalDateTime.now()) ) {
			
			//Verificar se o usuario ja votou
			if(!lista.isEmpty()) {
				return new Vote();
			} else {
				return voteRepository.save(vote);			
			}
			
		} else {
			throw new SessionExpirateTimeException("Sessao expirada");
		}
	}
}
