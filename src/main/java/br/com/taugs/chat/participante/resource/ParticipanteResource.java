package br.com.taugs.chat.participante.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.taugs.chat.participante.entity.Participante;
import br.com.taugs.chat.participante.service.ParticipanteService;
import br.com.taugs.chat.utils.RestMapping;
import br.com.taugs.persistence.ServiceException;

@CrossOrigin("*")
@RestController
@RequestMapping("/participante")
public class ParticipanteResource {

	@Autowired
	ParticipanteService service;

	@PostMapping(value = RestMapping.SALVAR)
	public ResponseEntity<Participante> salvar(@RequestBody Participante participante) throws ServiceException {
		Participante entity = service.salvar(participante);
		return new ResponseEntity<Participante>(entity, HttpStatus.OK);
	}

}
