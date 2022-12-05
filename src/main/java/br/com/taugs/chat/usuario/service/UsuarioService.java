package br.com.taugs.chat.usuario.service;

import java.util.List;

import br.com.taugs.chat.login.Login;
import br.com.taugs.chat.usuario.entity.Usuario;
import br.com.taugs.chat.usuario.search.UsuarioFilter;
import br.com.taugs.chat.usuario.search.UsuarioResponse;
import br.com.taugs.persistence.IService;
import br.com.taugs.persistence.ServiceException;

public interface UsuarioService extends IService<Usuario, Long> {

	List<UsuarioResponse> pesquisar(UsuarioFilter filtro);

	Usuario detalhar(UsuarioFilter filtro) throws ServiceException;

	Usuario logar(Login login) throws ServiceException;

	Usuario editar(Usuario entity) throws ServiceException;
}
