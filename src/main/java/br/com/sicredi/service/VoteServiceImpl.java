package br.com.sicredi.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import br.com.sicredi.util.exception.*;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.sicredi.client.AssociateValidatorClient;
import br.com.sicredi.document.Session;
import br.com.sicredi.document.Vote;
import br.com.sicredi.dto.AssociateStatusDTO;
import br.com.sicredi.repository.SessionRepository;
import br.com.sicredi.repository.VoteRepository;

@Slf4j
@Service
public class VoteServiceImpl implements VoteService {
	
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
	
	private void verifyIfAssociateIsAbleToVote(Vote vote) {
		
        AssociateStatusDTO associateVotingStatus = associateValidatorClient.getAssociateVotingStatus(vote.getCpf());        

        if (!associateVotingStatus.getStatus().equals("ABLE_TO_VOTE")) {        
        	log.info("A API retornou UNABLE_TO_VOTE");
            throw new AssociateNotEligibleToVoteException("Associado não habilitado para voto");
        }
        
	}
		
	private void verifyIfCpfIsValid(Vote vote) {
		String path = "/users/" + vote.getCpf();

		try {
			UriComponents uriComponents = UriComponentsBuilder.newInstance()
					.scheme("https")
					.host("user-info.herokuapp.com")
					.path(path).build();

			RestTemplate restTemplate = new RestTemplate();

			@SuppressWarnings("unused")
			ResponseEntity<AssociateStatusDTO> associateStatus = restTemplate.exchange(uriComponents.toUri(), HttpMethod.GET, null, AssociateStatusDTO.class);
		} catch (HttpClientErrorException e) {
        	log.info("A API retornou 404 por conta do CPF passado ser invalido");
			throw new AssociateCpfInvalidException("O CPF deve ter 11 digitos e ser valido");
		}
	}
	
	@Override
	public Vote save(Vote vote) {
		
		verifyIfCpfIsValid(vote);

		verifyIfAssociateIsAbleToVote(vote);
		
		List<Vote> lista = voteRepository.findByCpf(vote.getCpf(), vote.getSessionID());
		Optional<Session> sessao = sessionRepository.findById(vote.getSessionID());
		
		if(!sessao.isPresent()) {
        	log.info("Sesssao nao encontrada");
			return new Vote();
		}
		
		Session sessionValid = sessao.get();
		
		if(sessionValid.getStartTime().plusSeconds(sessionValid.getValidityTime()).isAfter(LocalDateTime.now()) ) {
			
			if(!lista.isEmpty()) {
				log.info("Associado informado ja votou nessa sessao");
				throw new AssociateHasAlreadyVotedException("Associado informado ja votou nessa sessao");
			} else {
				return voteRepository.save(vote);			
			}
			
		} else {
			throw new SessionExpirateTimeException("Sessao expirada");
		}		
	}
}
