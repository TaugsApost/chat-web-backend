package br.com.taugs.chat.mensagem.service;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import br.com.taugs.chat.mensagem.entity.Mensagem;
import br.com.taugs.persistence.AbstractServiceBean;
import br.com.taugs.persistence.ServiceException;

@Service
@Transactional
public class MensagemServiceBean extends AbstractServiceBean<Mensagem, Long> implements MensagemService {

	public MensagemServiceBean(EntityManager em) {
		super(em);
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<Mensagem> listarTodos() throws ServiceException {
		return this.listarTodosEntity();
	}

	@Override
	protected void beforeSave(Mensagem entity) throws ServiceException {
		entity.setDataEnvio(Timestamp.from(Instant.now()));
		super.beforeSave(entity);
	}

	@Override
	public Mensagem salvar(Mensagem entity) throws ServiceException {
		return this.salvarEntity(entity);
	}

	@Override
	public String excluir(Long id) throws ServiceException {
		return this.excluirEntity(id);
	}

	@Override
	public Mensagem detalhar(Long id) throws ServiceException {
		return this.detalharEntity(id);
	}

}
