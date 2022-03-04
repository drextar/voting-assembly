package br.com.sicredi.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import br.com.sicredi.document.Scheduler;

@Repository
public interface SchedulerRepository extends ReactiveMongoRepository<Scheduler, String>{

}
