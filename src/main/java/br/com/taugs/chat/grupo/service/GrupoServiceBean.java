package br.com.taugs.chat.grupo.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.taugs.chat.grupo.entity.Grupo;
import br.com.taugs.chat.grupo.search.GrupoFilter;
import br.com.taugs.chat.grupo.search.GrupoMapper;
import br.com.taugs.chat.grupo.search.GrupoResponse;
import br.com.taugs.chat.mensagem.service.MensagemService;
import br.com.taugs.chat.utils.Utils;
import br.com.taugs.persistence.AbstractServiceBean;
import br.com.taugs.persistence.ServiceException;

@Service
@Transactional
public class GrupoServiceBean extends AbstractServiceBean<Grupo, Long> implements GrupoService {

	@Autowired
	MensagemService mensagemService;

	public GrupoServiceBean(EntityManager em) {
		super(em);
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<Grupo> listarTodos() throws ServiceException {
		return this.listarTodosEntity();
	}

	@Override
	protected void beforeSave(Grupo entity) throws ServiceException {
		if (entity.getNome().length() > 20)
			throw new ServiceException("O nome do grupo excede o maximo permitido (20)");
		super.beforeSave(entity);
	}

	@Override
	public Grupo salvar(Grupo entity) throws ServiceException {
		return this.salvarEntity(entity);
	}

	@Override
	public String excluir(Long id) throws ServiceException {
		return this.excluirEntity(id);
	}

	@Override
	public Grupo detalhar(Long id) throws ServiceException {
		return this.detalharEntity(id);
	}

	@Override
	public List<GrupoResponse> listaGrupo(GrupoFilter filter) {
		List<Grupo> listaGrupo = this.getEntityManager().createQuery(Grupo.PESQUISAR_POR_NOME, Grupo.class)//
		        .setParameter("nome", Utils.stringLike(filter.getNome()))//
		        .getResultList();
		List<GrupoResponse> resultado = GrupoMapper.toResponse(listaGrupo, this.mensagemService);
		return resultado;
	}

	@Override
	public List<Grupo> listaGrupo(String username) {
		return this.getEntityManager().createQuery(Grupo.BUSCAR_GRUPO, Grupo.class)//
		        .setParameter("username", username)//
		        .getResultList();
	}

}
