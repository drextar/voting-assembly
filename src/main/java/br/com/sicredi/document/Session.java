package br.com.sicredi.document;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "Session")
public class Session {

	@Id
	private String sessionID;
	private LocalDateTime startTime;	
	private Long validityTime;
	private String schedulerID;
	
}
