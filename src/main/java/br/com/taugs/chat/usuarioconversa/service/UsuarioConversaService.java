package br.com.taugs.chat.usuarioconversa.service;

import java.util.List;

import br.com.taugs.chat.usuarioconversa.entity.UsuarioConversa;
import br.com.taugs.chat.usuarioconversa.entity.UsuarioConversaPK;
import br.com.taugs.persistence.IService;

public interface UsuarioConversaService extends IService<UsuarioConversa, Long> {

	List<UsuarioConversa> listarPorUsuario(Long idUsuario);

	UsuarioConversa detalhar(UsuarioConversaPK pk);

}
