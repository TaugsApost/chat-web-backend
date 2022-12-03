package br.com.taugs.chat.mensagem;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import br.com.taugs.chat.conversa.Conversa;
import br.com.taugs.chat.conversa.search.ConversaFilter;
import br.com.taugs.chat.mensagem.chat.entity.MensagemChat;
import br.com.taugs.chat.mensagem.grupo.entity.MensagemGrupo;
import br.com.taugs.chat.mensagem.service.MensagemService;
import br.com.taugs.persistence.ServiceException;

@CrossOrigin("*")
@RestController
@RequestMapping("/mensagem")
@JsonIgnoreProperties(ignoreUnknown = true)
public class MensagemResource {

	@Autowired
	MensagemService service;

	@PostMapping(value = "/salvarMensagemGrupo")
	public ResponseEntity<MensagemGrupo> salvarMensagemGrupo(@RequestBody MensagemGrupo msg) throws ServiceException {
		MensagemGrupo entity = service.salvarMensagemGrupo(msg);
		return new ResponseEntity<MensagemGrupo>(entity, HttpStatus.OK);
	}

	@PostMapping(value = "/salvarMensagemChat")
	public ResponseEntity<MensagemChat> salvarMensagemChat(@RequestBody MensagemChat msg) throws ServiceException {
		MensagemChat entity = service.salvarMensagemChat(msg);
		return new ResponseEntity<MensagemChat>(entity, HttpStatus.OK);
	}

	@PostMapping(value = "/deletarMensagemChat")
	public ResponseEntity<String> deletarMensagemChat(@RequestBody Long id) throws ServiceException {
		String entity = service.deletarMensagemChat(id);
		return new ResponseEntity<String>(entity, HttpStatus.OK);
	}

	@PostMapping(value = "/listarConversas")
	public ResponseEntity<List<MensagemChat>> listarConversas(@RequestBody ConversaFilter filter) throws ServiceException {
		List<MensagemChat> response = service.listarConversasUsuario(filter);
		return new ResponseEntity<List<MensagemChat>>(response, HttpStatus.OK);
	}

	@PostMapping(value = "/listarMensagens")
	public ResponseEntity<List<MensagemChat>> listarConversas(@RequestBody Conversa conversa) throws ServiceException {
		List<MensagemChat> response = service.listarMensagensConversa(conversa);
		return new ResponseEntity<List<MensagemChat>>(response, HttpStatus.OK);
	}

	@PostMapping(value = "/listarMensagensGrupo")
	public ResponseEntity<List<MensagemGrupo>> listarMensagemGrupo(@RequestBody Long id) throws ServiceException {
		List<MensagemGrupo> response = service.listarMensagensGrupo(id);
		return new ResponseEntity<List<MensagemGrupo>>(response, HttpStatus.OK);
	}

	@PostMapping(value = "/criarListaGrupos")
	public ResponseEntity<List<MensagemGrupo>> criarListaGrupo(@RequestBody String username) throws ServiceException {
		List<MensagemGrupo> response = service.listarGrupoUsuario(username);
		return new ResponseEntity<List<MensagemGrupo>>(response, HttpStatus.OK);
	}

	@PostMapping(value = "/buscarMensagensGrupoUsuario")
	public ResponseEntity<List<MensagemGrupo>> buscarMensagensGrupoUsuario(@RequestBody String username) throws ServiceException {
		List<MensagemGrupo> response = service.buscarTodasMensagensGrupoUsuario(username);
		return new ResponseEntity<List<MensagemGrupo>>(response, HttpStatus.OK);
	}

}
