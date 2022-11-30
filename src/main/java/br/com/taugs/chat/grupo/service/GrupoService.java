package br.com.taugs.chat.grupo.service;

import java.util.List;

import br.com.taugs.chat.grupo.entity.Grupo;
import br.com.taugs.chat.grupo.search.GrupoFilter;
import br.com.taugs.chat.grupo.search.GrupoResponse;
import br.com.taugs.persistence.IService;

public interface GrupoService extends IService<Grupo, Long> {

	List<GrupoResponse> listaGrupo(GrupoFilter filter);

}
