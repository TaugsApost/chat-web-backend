package br.com.taugs.chat.mensagem.grupo.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import br.com.taugs.chat.mensagem.grupo.entity.MensagemGrupo;
import br.com.taugs.persistence.AbstractServiceBean;
import br.com.taugs.persistence.ServiceException;

@Service
@Transactional
public class MensagemGrupoServiceBean extends AbstractServiceBean<MensagemGrupo, Long> implements MensagemGrupoService {

	public MensagemGrupoServiceBean(EntityManager em) {
		super(em);
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<MensagemGrupo> listarTodos() throws ServiceException {
		return this.listarTodosEntity();
	}

	@Override
	public MensagemGrupo salvar(MensagemGrupo entity) throws ServiceException {
		return this.salvarEntity(entity);
	}

	@Override
	public String excluir(Long id) throws ServiceException {
		return this.excluirEntity(id);
	}

	@Override
	public MensagemGrupo detalhar(Long id) throws ServiceException {
		return this.detalhar(id);
	}

}
