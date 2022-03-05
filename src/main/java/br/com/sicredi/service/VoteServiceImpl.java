package br.com.sicredi.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.sicredi.document.Session;
import br.com.sicredi.document.Vote;
import br.com.sicredi.dto.AssociateStatusDTO;
import br.com.sicredi.repository.SessionRepository;
import br.com.sicredi.repository.VoteRepository;
import br.com.sicredi.util.exception.AssociateNotFoundException;
import br.com.sicredi.util.exception.SessionExpirateTimeException;

@Service
public class VoteServiceImpl implements VoteService {
	
	@Autowired
	private VoteRepository voteRepository;
	
	@Autowired
	private SessionRepository sessionRepository;
	
	@Override
	public List<Vote> findAll() {
		return voteRepository.findAll();
	}

	@Override
	public Optional<Vote> findById(String id) {
		return voteRepository.findById(id);
	}
	
	private void verifyIfAssociateIsAbleToVote(Vote vote) {
		String path = "/users/" + vote.getCpf();
		
		try {
			UriComponents uriComponents = UriComponentsBuilder.newInstance()
				      .scheme("https")
				      .host("user-info.herokuapp.com")
				      .path(path).build();
			
			RestTemplate restTemplate = new RestTemplate();
			
			ResponseEntity<AssociateStatusDTO> associateStatus = restTemplate.exchange(uriComponents.toUri(), HttpMethod.GET, null, AssociateStatusDTO.class);
		} catch (HttpClientErrorException e) {
			throw new AssociateNotFoundException("O CPF deve ter 11 digitos e ser valido");
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
		
		// Verificar se a sessao ainda esta valida
		if(sessionValid.getStartTime().plusSeconds(sessionValid.getValidityTime()).isAfter(LocalDateTime.now()) ) {
			
			// Verificar se o usuario ja votou
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
