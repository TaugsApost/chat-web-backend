package br.com.taugs.chat.grupo.search;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import br.com.taugs.chat.grupo.entity.Grupo;
import br.com.taugs.chat.mensagem.grupo.entity.MensagemGrupo;
import br.com.taugs.chat.mensagem.service.MensagemService;

public class GrupoMapper {

	private static GrupoResponse toResponse(Grupo from, MensagemService msgService) {
		GrupoResponse to = new GrupoResponse();

		to.setIdGrupo(from.getId());
		to.setDataAlteracao(from.getDataAlteracao());
		to.setNome(from.getNome());
		to.setMensagem(retornarMensagem(from.getId(), msgService));

		return to;
	}

	public static List<GrupoResponse> toResponse(List<Grupo> from, MensagemService msgService) {
		List<GrupoResponse> to = new ArrayList<GrupoResponse>();
		from.forEach(response -> {
			to.add(toResponse(response, msgService));
		});
		return to;
	}

	public static String retornarMensagem(Long id, MensagemService msgService) {
		Timestamp hora = Timestamp.from(Instant.MIN);
		String mensagem = "";
		for (MensagemGrupo msg : msgService.listarMensagensGrupo(id)) {
			if (msg.getDataEnvio().after(hora)) {
				mensagem = msg.getConteudo();
				hora = msg.getDataEnvio();
			}
		}
		return mensagem;

	}

}
