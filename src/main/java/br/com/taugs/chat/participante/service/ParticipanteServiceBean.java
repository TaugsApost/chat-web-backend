package br.com.taugs.chat.participante.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import br.com.taugs.chat.participante.entity.Participante;
import br.com.taugs.persistence.AbstractServiceBean;
import br.com.taugs.persistence.ServiceException;

@Service
@Transactional
public class ParticipanteServiceBean extends AbstractServiceBean<Participante, Long> implements ParticipanteService {

	public ParticipanteServiceBean(EntityManager em) {
		super(em);
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<Participante> listarTodos() throws ServiceException {
		return this.listarTodosEntity();
	}

	@Override
	public Participante salvar(Participante entity) throws ServiceException {
		return this.salvarEntity(entity);
	}

	@Override
	public String excluir(Long id) throws ServiceException {
		return this.excluirEntity(id);
	}

	@Override
	public Participante detalhar(Long id) throws ServiceException {
		return this.detalharEntity(id);
	}

}
