package br.com.sicredi;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class VotingAssemblyApplicationTests {
	
	@Test
	void contextLoads() {
        var application = new VotingAssemblyApplication();
        assertThat(application).isNotNull();
	}
	
}
