package br.com.taugs.chat.usuario.resource;

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

import br.com.taugs.chat.login.Login;
import br.com.taugs.chat.usuario.entity.Usuario;
import br.com.taugs.chat.usuario.search.UsuarioFilter;
import br.com.taugs.chat.usuario.search.UsuarioResponse;
import br.com.taugs.chat.usuario.service.UsuarioService;
import br.com.taugs.chat.utils.RestMapping;
import br.com.taugs.persistence.ServiceException;

@CrossOrigin("*")
@RestController
@RequestMapping("/usuario")
public class UsuarioResource {

	@Autowired
	UsuarioService service;

	@PostMapping(value = RestMapping.SALVAR)
	public ResponseEntity<Usuario> salvar(@RequestBody Usuario usuario) throws ServiceException {
		Usuario entity = service.salvar(usuario);
		return new ResponseEntity<Usuario>(entity, HttpStatus.OK);
	}

	@PostMapping(value = RestMapping.EDITAR)
	public ResponseEntity<Usuario> editar(@RequestBody Usuario usuario) throws ServiceException {
		Usuario entity = service.editar(usuario);
		return new ResponseEntity<Usuario>(entity, HttpStatus.OK);
	}

	@PostMapping(value = RestMapping.PESQUISAR)
	public ResponseEntity<List<UsuarioResponse>> consultar(@RequestBody UsuarioFilter filter) throws ServiceException {
		List<UsuarioResponse> lista = service.pesquisar(filter);
		return new ResponseEntity<List<UsuarioResponse>>(lista, HttpStatus.OK);
	}

	@PostMapping(value = RestMapping.DETALHAR)
	public ResponseEntity<Usuario> detalhar(@RequestBody UsuarioFilter filter) throws ServiceException {
		Usuario entity = service.detalhar(filter);
		return new ResponseEntity<Usuario>(entity, HttpStatus.OK);
	}

	@GetMapping(value = RestMapping.LISTAR_TODOS)
	public ResponseEntity<List<Usuario>> listarUsuarios() throws ServiceException {
		List<Usuario> entity = service.listarTodos();
		return new ResponseEntity<List<Usuario>>(entity, HttpStatus.OK);
	}

	@GetMapping(value = RestMapping.EXCLUIR + "/{id}")
	public ResponseEntity<String> excluirUsuario(@PathVariable("id") Long id) throws ServiceException {
		String msg = service.excluir(id);
		return new ResponseEntity<String>(msg, HttpStatus.OK);
	}

	@PostMapping(value = "/logar")
	public ResponseEntity<Usuario> logar(@RequestBody Login login) throws ServiceException {
		Usuario response = service.logar(login);
		if (response != null) {
			return new ResponseEntity<Usuario>(response, HttpStatus.OK);
		} else {
			return new ResponseEntity<Usuario>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
