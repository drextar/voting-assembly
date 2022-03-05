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

import br.com.sicredi.document.Session;
import br.com.sicredi.service.SessionService;

@RestController
@RequestMapping("/session")
public class SessionController {

	@Autowired
	private SessionService sessaoService;
	

	@GetMapping
	public List<Session> getSession() {
		return sessaoService.findAll();
	}

	@GetMapping(value="/{id}")
	public Optional<Session> getSessionID(@PathVariable String id) {
		return sessaoService.findById(id);
	}

	@GetMapping(value="/result/{id}")
	public String resultVoteSession(@PathVariable String id) {
		return sessaoService.resultVoteSession(id);
	}
	
	@PostMapping
	public Session save(@RequestBody Session sessao) {
		return sessaoService.save(sessao);
	}

}
