package br.com.taugs.chat.usuarioconversamensagem.service;

import java.util.List;

import br.com.taugs.chat.mensagem.entity.Mensagem;
import br.com.taugs.chat.usuarioconversamensagem.entity.UsuarioConversaMensagem;
import br.com.taugs.persistence.IService;

public interface UsuarioConversaMensagemService extends IService<UsuarioConversaMensagem, Long> {

	UsuarioConversaMensagem detalhar(Long idUsuario, Long idMensagem, Long idConversa);

	List<UsuarioConversaMensagem> listarPorUsuarioEConversa(Long idConversa, Long idUsuario);

	List<Mensagem> listarMensagemPorUsuarioEConversa(Long idConversa, Long idUsuario);

}
