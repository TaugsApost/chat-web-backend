package br.com.taugs.chat.usuario.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import br.com.taugs.chat.usuario.entity.Usuario;
import br.com.taugs.chat.usuario.search.UsuarioFilter;
import br.com.taugs.chat.usuario.search.UsuarioMapper;
import br.com.taugs.chat.usuario.search.UsuarioResponse;
import br.com.taugs.chat.utils.Utils;
import br.com.taugs.persistence.AbstractServiceBean;
import br.com.taugs.persistence.ServiceException;

@Service
@Transactional
public class UsuarioServiceBean extends AbstractServiceBean<Usuario, Long> implements UsuarioService {

	public UsuarioServiceBean(EntityManager em) {
		super(em);
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<Usuario> listarTodos() throws ServiceException {
		return this.listarTodosEntity();
	}

	@Override
	public Usuario salvar(Usuario entity) throws ServiceException {
		return this.salvarEntity(entity);
	}

	@Override
	public String excluir(Long id) throws ServiceException {
		return this.excluirEntity(id);
	}

	@Override
	public Usuario detalhar(Long id) throws ServiceException {
		return this.detalharEntity(id);
	}

	@Override
	public List<UsuarioResponse> pesquisar(UsuarioFilter filtro) {
		List<Usuario> listaUsuario = this.getEntityManager().createQuery(Usuario.QUERY_CONSULTA, Usuario.class)//
		        .setParameter("userName", Utils.stringLike(filtro.getUserName()))//
		        .getResultList();
		return UsuarioMapper.toResponse(listaUsuario);
	}

}
