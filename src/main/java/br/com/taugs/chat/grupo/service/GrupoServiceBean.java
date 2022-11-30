package br.com.taugs.chat.grupo.service;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.taugs.chat.grupo.entity.Grupo;
import br.com.taugs.chat.grupo.search.GrupoFilter;
import br.com.taugs.chat.grupo.search.GrupoMapper;
import br.com.taugs.chat.grupo.search.GrupoResponse;
import br.com.taugs.chat.mensagem.service.MensagemService;
import br.com.taugs.chat.utils.Utils;
import br.com.taugs.persistence.AbstractServiceBean;
import br.com.taugs.persistence.ServiceException;

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
	public Grupo salvar(Grupo entity) throws ServiceException {
		return this.salvarEntity(entity);
	}

	@Override
	public String excluir(Long id) throws ServiceException {
		return this.excluirEntity(id);
	}

	@Override
	public Grupo detalhar(Long id) throws ServiceException {
		return this.detalhar(id);
	}

	@Override
	public List<GrupoResponse> listaGrupo(GrupoFilter filter) {
		List<Grupo> listaGrupo = this.getEntityManager().createQuery(Grupo.PESQUISAR_POR_NOME, Grupo.class)//
		        .setParameter("nome", Utils.stringLike(filter.getNome()))//
		        .getResultList();
		List<GrupoResponse> resultado = GrupoMapper.toResponse(listaGrupo, this.mensagemService);
		return resultado;
	}

}
