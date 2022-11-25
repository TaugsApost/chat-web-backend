package br.com.taugs.chat.contato.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.taugs.chat.contato.entity.Contato;
import br.com.taugs.chat.contato.search.ContatoFilter;
import br.com.taugs.chat.contato.search.ContatoResponse;
import br.com.taugs.chat.contato.service.ContatoService;
import br.com.taugs.chat.utils.RestMapping;
import br.com.taugs.persistence.ServiceException;

@CrossOrigin("*")
@RestController
@RequestMapping("/contato")
public class ContatoResource {

	@Autowired
	ContatoService service;

	@PostMapping(value = RestMapping.SALVAR)
	public ResponseEntity<Contato> salvar(@RequestBody Contato contato) throws ServiceException {
		Contato entity = service.salvar(contato);
		return new ResponseEntity<Contato>(entity, HttpStatus.OK);
	}

	@PostMapping(value = RestMapping.PESQUISAR)
	public ResponseEntity<List<ContatoResponse>> consultar(@RequestBody ContatoFilter filter) throws ServiceException {
		List<ContatoResponse> lista = service.pesquisar(filter);
		return new ResponseEntity<List<ContatoResponse>>(lista, HttpStatus.OK);
	}

	@GetMapping(value = RestMapping.DETALHAR + "/{id}")
	public ResponseEntity<Contato> detalhar(@PathVariable("id") Long id) throws ServiceException {
		Contato entity = service.detalhar(id);
		return new ResponseEntity<Contato>(entity, HttpStatus.OK);
	}

	@GetMapping(value = RestMapping.LISTAR_TODOS)
	public ResponseEntity<List<Contato>> listarContatos() throws ServiceException {
		List<Contato> entity = service.listarTodos();
		return new ResponseEntity<List<Contato>>(entity, HttpStatus.OK);
	}

	@GetMapping(value = RestMapping.EXCLUIR + "/{id}")
	public ResponseEntity<String> excluirContato(@PathVariable("id") Long id) throws ServiceException {
		String msg = service.excluir(id);
		return new ResponseEntity<String>(msg, HttpStatus.OK);
	}

}
