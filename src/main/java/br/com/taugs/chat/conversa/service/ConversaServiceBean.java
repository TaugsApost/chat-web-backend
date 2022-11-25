package br.com.taugs.chat.conversa.service;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.taugs.chat.conversa.entity.Conversa;
import br.com.taugs.chat.conversa.entity.ConversaDTO;
import br.com.taugs.chat.mensagem.service.MensagemService;
import br.com.taugs.chat.usuarioconversa.entity.UsuarioConversaPK;
import br.com.taugs.chat.usuarioconversa.service.UsuarioConversaService;
import br.com.taugs.chat.usuarioconversamensagem.entity.UsuarioConversaMensagem;
import br.com.taugs.chat.usuarioconversamensagem.service.UsuarioConversaMensagemService;
import br.com.taugs.persistence.AbstractServiceBean;
import br.com.taugs.persistence.ServiceException;

@Transactional
@Service
public class ConversaServiceBean extends AbstractServiceBean<Conversa, Long> implements ConversaService {

	@Autowired
	MensagemService mensagemService;

	@Autowired
	UsuarioConversaService usuarioConversaService;

	@Autowired
	UsuarioConversaMensagemService usuarioConversaMensagemSerivce;

	public ConversaServiceBean(EntityManager em) {
		super(em);
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<Conversa> listarTodos() throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected void beforeSave(Conversa entity) throws ServiceException {
		entity.setDataAlteracao(Timestamp.from(Instant.now()));
		super.beforeSave(entity);
	}

	@Override
	public Conversa salvar(Conversa entity) throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String excluir(Long id) throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Conversa detalhar(Long id) throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void salvarConversa(ConversaDTO conversaDTO) throws ServiceException {
		Long idMensagem = this.mensagemService.salvar(conversaDTO.getMensagem()).getId();
		Long idConversa = salvar(conversaDTO.getConversa()).getId();
		conversaDTO.getListaUsuarios().forEach(usuario -> {
			try {
				if (usuarioConversaService.detalhar(new UsuarioConversaPK(usuario.getIdUsuario(), idConversa)) == null) {
					usuario.setIdConversa(idConversa);
					usuario = this.usuarioConversaService.salvar(usuario);
				}
				this.usuarioConversaMensagemSerivce.salvar(new UsuarioConversaMensagem(idConversa, idMensagem, usuario.getIdUsuario()));
			} catch (ServiceException e) {
				e.printStackTrace();
			}
		});
	}

}
