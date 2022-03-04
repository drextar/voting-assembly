package br.com.sicredi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class VotingAssemblyApplication {

	public static void main(String[] args) {
		SpringApplication.run(VotingAssemblyApplication.class, args);
	}

}
