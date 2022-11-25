package br.com.taugs.chat.usuarioconversa.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import br.com.taugs.chat.usuarioconversa.entity.UsuarioConversa;
import br.com.taugs.chat.usuarioconversa.entity.UsuarioConversaPK;
import br.com.taugs.persistence.AbstractServiceBean;
import br.com.taugs.persistence.ServiceException;

@Service
@Transactional
public class UsuarioConversaServiceBean extends AbstractServiceBean<UsuarioConversa, Long> implements UsuarioConversaService {

	public UsuarioConversaServiceBean(EntityManager em) {
		super(em);
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<UsuarioConversa> listarTodos() throws ServiceException {
		return this.listarTodosEntity();
	}

	@Override
	public UsuarioConversa salvar(UsuarioConversa entity) throws ServiceException {
		return this.salvarEntity(entity);
	}

	@Override
	public String excluir(Long id) throws ServiceException {
		return this.excluirEntity(id);
	}

	@Override
	public UsuarioConversa detalhar(Long id) throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UsuarioConversa> listarPorUsuario(Long idUsuario) {
		return this.getEntityManager().createQuery("SELECT usuarioConversa FROM usuarioConversa WHERE " //
		        + "usuarioConversa.idUsuario = : idUsuario " //
		        + "order by usuarioConversa.conversa.dataAlteracao", UsuarioConversa.class)//
		        .setParameter("idUsuario", idUsuario) //
		        .getResultList();
	}

	@Override
	public UsuarioConversa detalhar(UsuarioConversaPK pk) {
		return this.getEntityManager().createQuery("SELECT usuarioConversa FROM usuarioConversa WHERE " //
		        + "usuarioConversa.idUsuario = : idUsuario " //
		        + "AND usuarioConversa.idConversa = :idConversa", UsuarioConversa.class)//
		        .setParameter("idConversa", pk.getIdConversa())//
		        .setParameter("idUsuario", pk.getIdUsuario())//
		        .getSingleResult();
	}

}
