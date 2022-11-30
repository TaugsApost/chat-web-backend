package br.com.taugs.chat.mensagem.service;

import java.util.List;

import br.com.taugs.chat.conversa.Conversa;
import br.com.taugs.chat.mensagem.chat.entity.MensagemChat;
import br.com.taugs.chat.mensagem.entity.Mensagem;
import br.com.taugs.chat.mensagem.grupo.entity.MensagemGrupo;
import br.com.taugs.persistence.IService;
import br.com.taugs.persistence.ServiceException;

public interface MensagemService extends IService<Mensagem, Long> {

	List<MensagemChat> listarMensagensUsuario(String username);

	List<MensagemChat> listarMensagensConversa(Conversa conversa);

	List<MensagemGrupo> listarMensagensGrupo(Long idGrupo);

	MensagemGrupo salvarMensagemGrupo(MensagemGrupo entity) throws ServiceException;

	MensagemChat salvarMensagemChat(MensagemChat entity) throws ServiceException;

}
