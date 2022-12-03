package br.com.taugs.chat.grupo.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.taugs.chat.grupo.entity.Grupo;
import br.com.taugs.chat.grupo.search.GrupoFilter;
import br.com.taugs.chat.grupo.search.GrupoResponse;
import br.com.taugs.chat.grupo.service.GrupoService;
import br.com.taugs.chat.utils.RestMapping;
import br.com.taugs.persistence.ServiceException;

@CrossOrigin("*")
@RestController
@RequestMapping("/grupo")
public class GrupoResource {

	@Autowired
	GrupoService service;

	@PostMapping(value = RestMapping.SALVAR)
	public ResponseEntity<Grupo> salvar(@RequestBody Grupo grupo) throws ServiceException {
		Grupo entity = service.salvar(grupo);
		return new ResponseEntity<Grupo>(entity, HttpStatus.OK);
	}

	@PostMapping(value = RestMapping.PESQUISAR)
	public ResponseEntity<List<GrupoResponse>> consultar(@RequestBody GrupoFilter filter) {
		List<GrupoResponse> response = this.service.listaGrupo(filter);
		return new ResponseEntity<List<GrupoResponse>>(response, HttpStatus.OK);
	}

	@PostMapping(value = "/buscarPorUsuario")
	public ResponseEntity<List<Grupo>> buscarPorUsuario(@RequestBody String username) {
		List<Grupo> response = this.service.listaGrupo(username);
		return new ResponseEntity<List<Grupo>>(response, HttpStatus.OK);
	}

}
