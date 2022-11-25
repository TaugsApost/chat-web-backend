package br.com.taugs.chat.conversa.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.taugs.chat.conversa.entity.ConversaDTO;
import br.com.taugs.chat.conversa.service.ConversaService;
import br.com.taugs.chat.utils.RestMapping;
import br.com.taugs.persistence.ServiceException;

@CrossOrigin("*")
@RestController
@RequestMapping("/conversa")
public class ConversaResource {

	@Autowired
	ConversaService service;

	@PostMapping(value = RestMapping.SALVAR)
	public ResponseEntity<String> salvar(@RequestBody ConversaDTO conversaDTO) throws ServiceException {
		service.salvarConversa(conversaDTO);
		return new ResponseEntity<String>("Conversa salva com sucesso", HttpStatus.OK);
	}

}
