package br.com.taugs.chat.conversa.service;

import br.com.taugs.chat.conversa.entity.Conversa;
import br.com.taugs.chat.conversa.entity.ConversaDTO;
import br.com.taugs.persistence.IService;
import br.com.taugs.persistence.ServiceException;

public interface ConversaService extends IService<Conversa, Long> {

	void salvarConversa(ConversaDTO conversaDTO) throws ServiceException;

}
