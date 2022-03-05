package br.com.sicredi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.sicredi.document.Scheduler;
import br.com.sicredi.service.SchedulerService;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/scheduler")
public class SchedulerController {

	@Autowired
	private SchedulerService pautaService;
	
	@GetMapping
	public Flux<Scheduler> getScheduler() {
		return pautaService.findAll();
	}
	
    @GetMapping(value="/{id}")
    public Mono<Scheduler> getSchedulerID(@PathVariable String id) {
        return pautaService.findById(id);
    }
    
    @PostMapping
    public Mono<Scheduler> save(@RequestBody Scheduler pauta) {
        return pautaService.save(pauta);
    }

}
