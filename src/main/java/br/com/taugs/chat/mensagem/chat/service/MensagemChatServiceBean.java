package br.com.taugs.chat.mensagem.chat.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import br.com.taugs.chat.mensagem.chat.entity.MensagemChat;
import br.com.taugs.persistence.AbstractServiceBean;
import br.com.taugs.persistence.ServiceException;

@Service
@Transactional
public class MensagemChatServiceBean extends AbstractServiceBean<MensagemChat, Long> implements MensagemChatService {

	public MensagemChatServiceBean(EntityManager em) {
		super(em);
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<MensagemChat> listarTodos() throws ServiceException {
		return this.listarTodosEntity();
	}

	@Override
	public MensagemChat salvar(MensagemChat entity) throws ServiceException {
		return this.salvarEntity(entity);
	}

	@Override
	public String excluir(Long id) throws ServiceException {
		return this.excluirEntity(id);
	}

	@Override
	public MensagemChat detalhar(Long id) throws ServiceException {
		return this.detalharEntity(id);
	}

}
