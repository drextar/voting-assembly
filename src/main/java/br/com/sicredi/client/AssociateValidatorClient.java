package br.com.sicredi.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import br.com.sicredi.dto.AssociateStatusDTO;

@Service
@FeignClient(name = "ValidadorCpfClient", url = "https://user-info.herokuapp.com/users")
public interface AssociateValidatorClient {

    @GetMapping(value = "/{cpf}")
    AssociateStatusDTO getAssociateVotingStatus(@PathVariable("cpf") String cpf);

}
