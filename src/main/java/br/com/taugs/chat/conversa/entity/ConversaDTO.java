package br.com.taugs.chat.conversa.entity;

import java.util.List;

import br.com.taugs.chat.mensagem.entity.Mensagem;
import br.com.taugs.chat.usuarioconversa.entity.UsuarioConversa;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ConversaDTO {

	private List<UsuarioConversa> listaUsuarios;
	private Mensagem mensagem;
	private Conversa conversa;

}
