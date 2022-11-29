package br.com.taugs.chat.contato.search;

import java.util.ArrayList;
import java.util.List;

import br.com.taugs.chat.contato.entity.Contato;

public class ContatoMapper {

	private static ContatoResponse toResponse(Contato from) {
		ContatoResponse to = new ContatoResponse();

		to.setNome(from.getNomeContato());
		to.setUsernameContato(from.getUsernameContato());

		return to;
	}

	public static List<ContatoResponse> toResponse(List<Contato> from) {
		List<ContatoResponse> to = new ArrayList<ContatoResponse>();
		from.forEach(contato -> {
			to.add(toResponse(contato));
		});
		return to;
	}

}
