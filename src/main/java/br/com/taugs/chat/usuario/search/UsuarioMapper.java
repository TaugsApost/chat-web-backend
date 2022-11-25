package br.com.taugs.chat.usuario.search;

import java.util.ArrayList;
import java.util.List;

import br.com.taugs.chat.usuario.entity.Usuario;

public class UsuarioMapper {

	private static UsuarioResponse toResponse(Usuario from) {
		UsuarioResponse to = new UsuarioResponse();

		to.setId(from.getId());
		to.setUserName(from.getUserName());

		return to;
	}

	public static List<UsuarioResponse> toResponse(List<Usuario> from) {
		List<UsuarioResponse> to = new ArrayList<UsuarioResponse>();
		from.forEach(usuario -> {
			to.add(toResponse(usuario));
		});
		return to;
	}

}
