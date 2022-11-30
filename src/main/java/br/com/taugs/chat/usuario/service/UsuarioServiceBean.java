package br.com.taugs.chat.usuario.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import br.com.taugs.chat.login.Login;
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
	public Usuario detalhar(UsuarioFilter filtro) throws ServiceException {
		Usuario usuario = null;
		try {
			usuario = this.getEntityManager().createQuery(Usuario.PESQUISAR_POR_ID, Usuario.class)//
			        .setParameter("username", filtro.getUserName())//
			        .getSingleResult();
			return usuario;
		} catch (NoResultException e) {
			return null;
		}

	}

	@Override
	public List<UsuarioResponse> pesquisar(UsuarioFilter filtro) {
		List<Usuario> listaUsuario = this.getEntityManager().createQuery(Usuario.QUERY_CONSULTA, Usuario.class)//
		        .setParameter("username", Utils.stringLike(filtro.getUserName()))//
		        .getResultList();
		return UsuarioMapper.toResponse(listaUsuario);
	}

	@Override
	public Usuario detalhar(Long id) throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UsuarioResponse logar(Login login) throws ServiceException {
		try {
			Usuario usuario = this.getEntityManager().createQuery(Usuario.LOGAR, Usuario.class)//
			        .setParameter("username", login.getUsername())//
			        .setParameter("senha", login.getSenha())//
			        .getSingleResult();
			return new UsuarioResponse(usuario.getUsername());
		} catch (NoResultException e) {
			return null;
		}
	}

}
