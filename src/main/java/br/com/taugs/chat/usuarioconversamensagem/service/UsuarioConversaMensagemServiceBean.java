package br.com.taugs.chat.usuarioconversamensagem.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import br.com.taugs.chat.mensagem.entity.Mensagem;
import br.com.taugs.chat.usuarioconversamensagem.entity.UsuarioConversaMensagem;
import br.com.taugs.persistence.AbstractServiceBean;
import br.com.taugs.persistence.ServiceException;

@Service
@Transactional
public class UsuarioConversaMensagemServiceBean extends AbstractServiceBean<UsuarioConversaMensagem, Long> implements UsuarioConversaMensagemService {

	public UsuarioConversaMensagemServiceBean(EntityManager em) {
		super(em);
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<UsuarioConversaMensagem> listarTodos() throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UsuarioConversaMensagem salvar(UsuarioConversaMensagem entity) throws ServiceException {
		return this.salvarEntity(entity);
	}

	@Override
	public String excluir(Long id) throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UsuarioConversaMensagem detalhar(Long id) throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UsuarioConversaMensagem detalhar(Long idUsuario, Long idMensagem, Long idConversa) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UsuarioConversaMensagem> listarPorUsuarioEConversa(Long idConversa, Long idUsuario) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Mensagem> listarMensagemPorUsuarioEConversa(Long idConversa, Long idUsuario) {
		// TODO Auto-generated method stub
		return null;
	}

}
