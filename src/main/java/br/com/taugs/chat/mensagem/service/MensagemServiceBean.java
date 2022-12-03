package br.com.taugs.chat.mensagem.service;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.taugs.chat.conversa.Conversa;
import br.com.taugs.chat.conversa.search.ConversaFilter;
import br.com.taugs.chat.mensagem.chat.entity.MensagemChat;
import br.com.taugs.chat.mensagem.chat.service.MensagemChatService;
import br.com.taugs.chat.mensagem.entity.Mensagem;
import br.com.taugs.chat.mensagem.grupo.entity.MensagemGrupo;
import br.com.taugs.chat.mensagem.grupo.service.MensagemGrupoService;
import br.com.taugs.chat.utils.Utils;
import br.com.taugs.persistence.AbstractServiceBean;
import br.com.taugs.persistence.ServiceException;

@Service
@Transactional
public class MensagemServiceBean extends AbstractServiceBean<Mensagem, Long> implements MensagemService {

	@Autowired
	MensagemChatService mensagemCharService;

	@Autowired
	MensagemGrupoService mensagemGrupoService;

	public MensagemServiceBean(EntityManager em) {
		super(em);
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<Mensagem> listarTodos() throws ServiceException {
		return this.listarTodosEntity();
	}

	@Override
	protected void beforeSave(Mensagem entity) throws ServiceException {
		entity.setDataEnvio(Timestamp.from(Instant.now()));
		super.beforeSave(entity);
	}

	@Override
	public Mensagem salvar(Mensagem entity) throws ServiceException {
		return this.salvarEntity(entity);
	}

	@Override
	public String excluir(Long id) throws ServiceException {
		return this.excluirEntity(id);
	}

	@Override
	public Mensagem detalhar(Long id) throws ServiceException {
		return this.detalharEntity(id);
	}

	@Override
	public List<MensagemChat> listarConversasUsuario(ConversaFilter filter) {
		List<MensagemChat> mensagens = this.getEntityManager().createQuery(MensagemChat.LISTAR_MENSAGENS_USUARIO, MensagemChat.class)//
		        .setParameter("username", filter.getUsername())//
		        .setParameter("str", Utils.stringLike(filter.getFiltro()))//
		        .getResultList();
		criarListaConversa(mensagens);
		return mensagens;
	}

	private void criarListaConversa(List<MensagemChat> lista) {
		List<MensagemChat> lixo = new ArrayList<MensagemChat>();
		for (MensagemChat msg : lista) {
			for (int i = lista.indexOf(msg) + 1; i < lista.size(); i++) {
				MensagemChat comparar = lista.get(i);
				if (msg.getUsernameEmissor().equals(comparar.getUsernameReceptor()) //
				        && msg.getUsernameReceptor().equals(comparar.getUsernameEmissor())) {
					if (comparar.getDataEnvio().after(msg.getDataEnvio())) {
						lixo.add(msg);
					} else {
						lixo.add(comparar);
					}
				}
			}
		}
		lixo.forEach(msg -> {
			lista.remove(msg);
		});
	}

	@Override
	public List<MensagemChat> listarMensagensConversa(Conversa conversa) {
		List<MensagemChat> mensagens = this.getEntityManager().createQuery(MensagemChat.LISTAR_MENSAGENS_CONVERSA, MensagemChat.class)//
		        .setParameter("username1", conversa.getUsername1())//
		        .setParameter("username2", conversa.getUsername2())//
		        .getResultList();
		return mensagens;
	}

	@Override
	public List<MensagemGrupo> listarMensagensGrupo(Long idGrupo) {
		return this.getEntityManager().createQuery(MensagemGrupo.LISTAR_MENSAGENS_GRUPO, MensagemGrupo.class)//
		        .setParameter("idGrupo", idGrupo)//
		        .getResultList();
	}

	@Override
	public MensagemGrupo salvarMensagemGrupo(MensagemGrupo entity) throws ServiceException {
		return this.mensagemGrupoService.salvar(entity);
	}

	@Override
	public MensagemChat salvarMensagemChat(MensagemChat entity) throws ServiceException {
		return mensagemCharService.salvar(entity);
	}

	@Override
	public String deletarMensagemChat(Long id) throws ServiceException {
		return mensagemCharService.excluir(id);
	}

	@Override
	public List<MensagemGrupo> buscarTodasMensagensGrupoUsuario(String username) {
		System.out.println(username);
		return this.getEntityManager().createQuery(MensagemGrupo.BUSCAR_TODAS_MENSAGEM_GRUPO_USUARIO, MensagemGrupo.class)//
		        .setParameter("username", username)//
		        .getResultList();
	}

	@Override
	public List<MensagemGrupo> listarGrupoUsuario(String username) {
		System.out.println(username);
		return this.getEntityManager().createQuery(MensagemGrupo.CRIAR_LISTA_GRUPO, MensagemGrupo.class)//
		        .setParameter("username", username)//
		        .getResultList();
	}

}
