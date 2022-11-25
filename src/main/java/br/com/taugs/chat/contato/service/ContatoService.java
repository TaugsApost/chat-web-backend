package br.com.taugs.chat.contato.service;

import java.util.List;

import br.com.taugs.chat.contato.entity.Contato;
import br.com.taugs.chat.contato.search.ContatoFilter;
import br.com.taugs.chat.contato.search.ContatoResponse;
import br.com.taugs.persistence.IService;

public interface ContatoService extends IService<Contato, Long> {

	List<ContatoResponse> pesquisar(ContatoFilter filter);

}
