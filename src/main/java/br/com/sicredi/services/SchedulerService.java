package br.com.sicredi.services;

import br.com.sicredi.document.Scheduler;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface SchedulerService {

	Flux<Scheduler> findAll();	
	Mono<Scheduler> findById(String id);
	Mono<Scheduler> save(Scheduler pauta);
	
}
