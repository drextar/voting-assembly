package br.com.sicredi.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.sicredi.document.Vote;
import br.com.sicredi.service.VoteService;

@RestController
@RequestMapping("/vote")
public class VoteController {

	@Autowired
	private VoteService votoService;

	@GetMapping
	public List<Vote> getVote() {
		return votoService.findAll();
	}

	@GetMapping(value="/{id}")
	public Optional<Vote> getVoteID(@PathVariable String id) {
		return votoService.findById(id);
	}

	@PostMapping
	public ResponseEntity<Vote> save(@RequestBody Vote vote) {		
		Vote votoSaved = votoService.vote(vote);

		if(votoSaved.getVoteID() == null) {
			return new ResponseEntity("Este usuario ja votou", HttpStatus.ACCEPTED);
		} else {
			return new ResponseEntity<Vote>(votoSaved, HttpStatus.CREATED);
		}		
	}
	
}
