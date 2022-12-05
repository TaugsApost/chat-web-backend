package br.com.taugs.chat.contato.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import br.com.taugs.chat.contato.entity.Contato;
import br.com.taugs.chat.contato.search.ContatoFilter;
import br.com.taugs.chat.contato.search.ContatoMapper;
import br.com.taugs.chat.contato.search.ContatoResponse;
import br.com.taugs.chat.utils.Utils;
import br.com.taugs.persistence.AbstractServiceBean;
import br.com.taugs.persistence.ServiceException;

@Service
@Transactional
public class ContatoServiceBean extends AbstractServiceBean<Contato, Long> implements ContatoService {

	public ContatoServiceBean(EntityManager em) {
		super(em);
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<Contato> listarTodos() throws ServiceException {
		return this.listarTodosEntity();
	}

	@Override
	public Contato salvar(Contato entity) throws ServiceException {
		return this.salvarEntity(entity);
	}

	@Override
	public String excluir(Long id) throws ServiceException {
		return this.excluirEntity(id);
	}

	@Override
	public Contato detalhar(Long id) throws ServiceException {
		return this.detalharEntity(id);
	}

	@Override
	public List<ContatoResponse> pesquisar(ContatoFilter filter) {
		List<Contato> listaContato = this.getEntityManager().createQuery(Contato.QUERY_PESQUISA, Contato.class)//
		        .setParameter("nome", Utils.stringLike(filter.getNome()))//
		        .setParameter("username", filter.getUsername()).getResultList();
		return ContatoMapper.toResponse(listaContato);
	}

	@Override
	public Contato editar(Contato entity) throws ServiceException {
		return this.updateEntity(entity);
	}

	@Override
	public String excluir(Contato entity) {
		return this.excluirEntity(entity);
	}

}
