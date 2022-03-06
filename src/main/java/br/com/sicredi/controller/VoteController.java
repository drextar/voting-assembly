package br.com.sicredi.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
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
	private VoteService voteService;

	@GetMapping
	public List<Vote> getVote() {
		return voteService.findAll();
	}

	@GetMapping(value="/{id}")
	public Optional<Vote> getVoteID(@PathVariable String id) {
		return voteService.findById(id);
	}

	@PostMapping
	public Vote save(@RequestBody Vote vote) {
		return voteService.save(vote);
	}
	
}
