package br.com.sicredi.document;

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
@Document(collection = "Vote")
public class Vote {

	@Id
	private String voteID;
	private boolean inFavor;
	private String cpf;
	private String sessionID;

	public boolean inFavor() {
		return inFavor;
	}

	public void setaFavor(boolean inFavor) {
		this.inFavor = inFavor;
	}
	
}
