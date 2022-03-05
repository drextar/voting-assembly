package br.com.sicredi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.sicredi.document.Scheduler;
import br.com.sicredi.util.exception.ScheduleNameEmptyException;
import br.com.sicredi.repository.SchedulerRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class SchedulerServiceImpl implements SchedulerService{

	@Autowired
	private SchedulerRepository pautaRepository;
	
	@Override
	public Flux<Scheduler> findAll() {	
		return pautaRepository.findAll();
	}

	@Override
	public Mono<Scheduler> findById(String id) {
		return pautaRepository.findById(id);
	}

	@Override
	public Mono<Scheduler> save(Scheduler scheduler) {	
		if (scheduler.getNameSchedule().isEmpty()) {
			throw new ScheduleNameEmptyException("Obrigatorio informar o nome da Pauta");
		}
		return pautaRepository.save(scheduler);
	}	
}
